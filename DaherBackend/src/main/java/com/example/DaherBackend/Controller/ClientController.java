package com.example.DaherBackend.Controller;

import com.example.DaherBackend.Exception.ResourceNotFoundException;
import com.example.DaherBackend.Model.Client;
import com.example.DaherBackend.Repository.ClientRepository;
import com.example.DaherBackend.Response.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.DaherBackend.Response.CustomResponseHelper.failureResponse;
import static com.example.DaherBackend.Response.CustomResponseHelper.successResponse;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    // Endpoint to get all clients
    @GetMapping("")
    public CustomResponse<List<Client>> getAllClients() {
        CustomResponse<List<Client>> listCustomResponse;
        try {
            // Retrieve all clients from the repository
            listCustomResponse = successResponse(clientRepository.findAll());
        } catch (Exception e) {
            listCustomResponse = failureResponse(e.getMessage());
        }
        return listCustomResponse;
    }

    // Endpoint to get a client by ID
    @GetMapping("/{id}")
    public CustomResponse<Client> getClientById(@PathVariable(value = "id") Long clientId) {
        CustomResponse<Client> customResponse;
        try {
            // Retrieve a client by ID from the repository
            Client client = clientRepository
                    .findById(clientId)
                    .orElseThrow(() -> new ResourceNotFoundException("Client not found on :: " + clientId));
            customResponse = successResponse(client);
        } catch (Exception e) {
            customResponse = failureResponse(e.getMessage());
        }
        return customResponse;
    }

    // Endpoint to create a new client
    @PostMapping("")
    public CustomResponse<Client> createClient(@Validated @RequestBody Client client) {
        CustomResponse<Client> customResponse;
        try {
            // Save a new client to the repository
            Client newClient = clientRepository.save(client);
            customResponse = successResponse(newClient);
        } catch (Exception e) {
            customResponse = failureResponse(e.getMessage());
        }
        return customResponse;
    }

    // Endpoint to update an existing client
    @PutMapping("/{id}")
    public CustomResponse<Client> updateClient(
            @PathVariable(value = "id") Long clientId, @Validated @RequestBody Client clientDetails) {
        CustomResponse<Client> customResponse;
        try {
            // Retrieve an existing client by ID from the repository
            Client existingClient = clientRepository
                    .findById(clientId)
                    .orElseThrow(() -> new ResourceNotFoundException("Client not found on :: " + clientId));

            // Update the client details
            existingClient.setFirstName(clientDetails.getFirstName());
            existingClient.setLastName(clientDetails.getLastName());
            existingClient.setMobile(clientDetails.getMobile());

            // Save the updated client
            final Client updatedClient = clientRepository.save(existingClient);
            customResponse = successResponse(updatedClient);
        } catch (Exception e) {
            customResponse = failureResponse(e.getMessage());
        }
        return customResponse;
    }
}
