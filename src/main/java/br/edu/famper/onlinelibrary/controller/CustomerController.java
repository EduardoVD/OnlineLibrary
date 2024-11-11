package br.edu.famper.onlinelibrary.controller;
import br.edu.famper.onlinelibrary.dto.CustomerDto;
import br.edu.famper.onlinelibrary.exception.ResourceNotFoundException;
import br.edu.famper.onlinelibrary.model.Customer;
import br.edu.famper.onlinelibrary.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

//Controller For Operations´s Management Related To "Customer"...

@RestController
@RequestMapping("/onlineLibrary/customer")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Customer", description = "Operations For Customer...")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get All Customers From Database...", description = "Fetches All Customers From Database And Return In JSON Array...")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public List<CustomerDto> getAllCustomers() {
        log.info("Searching For All Customers...");
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get One Customer From Database...", description = "Fetches One Customer From Database And Return In JSON Object...")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Searching For Customer By Code: {}", id);
        return ResponseEntity.ok().body(customerService.getCustomerById(id));
    }

    @PostMapping
    @Operation(summary = "Save Customer...", description = "Save Customer In Database...")
    public Customer createCustomer(@RequestBody CustomerDto customerDto) throws ResourceNotFoundException {
        log.info("Registering Customer: {}", customerDto);
        return customerService.saveCustomer(customerDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update Customer...", description = "Update Customer In Database...")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable(name = "id") Long id, @RequestBody CustomerDto customerDto) throws ResourceNotFoundException {
        log.info("Updating Customer: {}", customerDto);
        return ResponseEntity.ok().body(customerService.updateCustomer(id, customerDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Customer...", description = "Delete Customer In Database...")
    public Map<String, Boolean> deleteCustomer(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Deleting Customer: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", customerService.deleteCustomer(id));
        return response;}
}
