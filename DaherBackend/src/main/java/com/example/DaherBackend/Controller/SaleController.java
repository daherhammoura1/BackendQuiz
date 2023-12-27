package com.example.DaherBackend.Controller;

import com.example.DaherBackend.Exception.ResourceNotFoundException;
import com.example.DaherBackend.Model.Sale;
import com.example.DaherBackend.Model.SaleItem;
import com.example.DaherBackend.Repository.SaleItemRepository;
import com.example.DaherBackend.Repository.SaleRepository;
import com.example.DaherBackend.Response.CustomResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.DaherBackend.Response.CustomResponseHelper.failureResponse;
import static com.example.DaherBackend.Response.CustomResponseHelper.successResponse;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    // Logger for logging information
    private final static Logger logger = LoggerFactory.getLogger(SaleController.class);

    // Autowired repositories
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleItemRepository saleItemRepository;

    // Endpoint to get all sales
    @GetMapping("")
    public CustomResponse<List<Sale>> getAllSales() {
        CustomResponse<List<Sale>> listCustomResponse;
        try {
            // Retrieve all sales from the repository
            listCustomResponse = successResponse(saleRepository.findAll());
        } catch (Exception e) {
            listCustomResponse = failureResponse(e.getMessage());
        }
        return listCustomResponse;
    }

    // Endpoint to get a sale by ID
    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable(value = "id") Long saleId)
            throws ResourceNotFoundException {
        // Retrieve a sale by ID from the repository
        Sale sale = saleRepository
                .findById(saleId)
                .orElseThrow(() -> new ResourceNotFoundException("Sale not found on :: " + saleId));
        return ResponseEntity.ok().body(sale);
    }

    // Endpoint to create a new sale
    @PostMapping("")
    public CustomResponse<Sale> createSale(@Valid @RequestBody Sale sale) {
        try {
            // Save the sale to the repository
            List<SaleItem> temp = sale.getSaleItem();
            sale.setSaleItem(new ArrayList<>());
            sale = saleRepository.save(sale);
            for (SaleItem saleItem : temp) {
                // Associate each sale item with the sale and save them
                saleItem.setSale(sale);
                saleItemRepository.save(saleItem);
            }
            logger.info(String.format("%s created", sale));
            return successResponse(sale);
        } catch (Exception e) {
            return failureResponse(e.getMessage());
        }
    }

    // Endpoint to update an existing sale
    @PutMapping("/{id}")
    public CustomResponse<Sale> updateSale(
            @PathVariable(value = "id") Long saleId, @Valid @RequestBody Sale saleDetails) {
        try {
            // Update sale items associated with the sale
            List<SaleItem> updatedSaleItems = new ArrayList<>();
            for (SaleItem saleItem : saleDetails.getSaleItem()) {
                SaleItem newSaleItem = saleItemRepository
                        .findById(saleItem.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Sale Item not found on :: " + saleItem.getId()));

                newSaleItem.setQuantity(saleItem.getQuantity());
                final SaleItem updatedSaleItem = saleItemRepository.save(newSaleItem);
                updatedSaleItems.add(updatedSaleItem);
            }

            // Update the sale with the updated sale items
            Sale newSale = saleRepository
                    .findById(saleId)
                    .orElseThrow(() -> new ResourceNotFoundException("Sale not found on :: " + saleId));

            newSale.setSaleItem(updatedSaleItems);
            final Sale updatedSale = saleRepository.save(newSale);
            logger.info(String.format("%s updated", updatedSale));
            return successResponse(updatedSale);
        } catch (Exception e) {
            return failureResponse(e.getMessage());
        }
    }
}
