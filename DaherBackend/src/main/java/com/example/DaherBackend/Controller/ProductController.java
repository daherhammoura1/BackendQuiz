package com.example.DaherBackend.Controller;

import com.example.DaherBackend.Exception.ResourceNotFoundException;
import com.example.DaherBackend.Model.Product;
import com.example.DaherBackend.Repository.ProductRepository;
import com.example.DaherBackend.Response.CustomResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.DaherBackend.Response.CustomResponseHelper.failureResponse;
import static com.example.DaherBackend.Response.CustomResponseHelper.successResponse;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // Endpoint to get all products
    @GetMapping("")
    public CustomResponse<List<Product>> getAllProducts() {
        CustomResponse<List<Product>> listCustomResponse;
        try {
            // Retrieve all products from the repository
            listCustomResponse = successResponse(productRepository.findAll());
        } catch (Exception e) {
            listCustomResponse = failureResponse(e.getMessage());
        }
        return listCustomResponse;
    }

    // Endpoint to get a product by ID
    @GetMapping("/{id}")
    public CustomResponse<Product> getProductById(@PathVariable(value = "id") Long productId) {
        CustomResponse<Product> customResponse;
        try {
            // Retrieve a product by ID from the repository
            Product product = productRepository
                    .findById(productId)
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found on :: " + productId));
            customResponse = successResponse(product);
        } catch (Exception e) {
            customResponse = failureResponse(e.getMessage());
        }
        return customResponse;
    }

    // Endpoint to create a new product
    @PostMapping("")
    public CustomResponse<Product> createProduct(@Valid @RequestBody Product product) {
        CustomResponse<Product> customResponse;
        try {
            // Save a new product to the repository
            Product newProduct = productRepository.save(product);
            customResponse = successResponse(newProduct);
        } catch (Exception e) {
            customResponse = failureResponse(e.getMessage());
        }
        return customResponse;
    }

    // Endpoint to update an existing product
    @PutMapping("/{id}")
    public CustomResponse<Product> updateProduct(
            @PathVariable(value = "id") Long productId, @Valid @RequestBody Product productDetails) {
        CustomResponse<Product> customResponse;
        try {
            // Retrieve an existing product by ID from the repository
            Product existingProduct = productRepository
                    .findById(productId)
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found on :: " + productId));

            // Update the product details
            existingProduct.setName(productDetails.getName());
            existingProduct.setDescription(productDetails.getDescription());
            existingProduct.setPrice(productDetails.getPrice());
            existingProduct.setCategory(productDetails.getCategory());

            // Save the updated product
            final Product updatedProduct = productRepository.save(existingProduct);
            customResponse = successResponse(updatedProduct);
        } catch (Exception e) {
            customResponse = failureResponse(e.getMessage());
        }
        return customResponse;
    }
}
