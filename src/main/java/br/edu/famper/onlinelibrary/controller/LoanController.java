package br.edu.famper.onlinelibrary.controller;
import br.edu.famper.onlinelibrary.dto.LoanDto;
import br.edu.famper.onlinelibrary.exception.ResourceNotFoundException;
import br.edu.famper.onlinelibrary.model.Loan;
import br.edu.famper.onlinelibrary.service.LoanService;
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

//Controller For Operations´s Management Related To "Loan"...

@RestController
@RequestMapping("/onlineLibrary/loan")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Loan", description = "Operations For Loan...")
public class LoanController {

    private final LoanService loanService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get All Loans From Database...", description = "Fetches All Cities From Database And Return In JSON Array...")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public List<LoanDto> getAllLoans() {
        log.info("Searching For All Loans...");
        return loanService.getAllLoans();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get One Loan From Database", description = "Fetches One Loan From Database And Return In JSON Object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public ResponseEntity<LoanDto> getLoanById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Searching For Loan By Code: {}", id);
        return ResponseEntity.ok().body(loanService.getLoanById(id));
    }

    @PostMapping
    @Operation(summary = "Save Loan", description = "Save Loan In Database")
    public Loan createLoan(@RequestBody LoanDto loanDto) throws ResourceNotFoundException {
        log.info("Registering Loan: {}", loanDto);
        return loanService.saveLoan(loanDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update Loan", description = "Update Loan In Database")
    public ResponseEntity<LoanDto> updateLoan(@PathVariable(name = "id") Long id, @RequestBody LoanDto loanDto) throws ResourceNotFoundException {
        log.info("Updating Loan: {}", loanDto);
        return ResponseEntity.ok().body(loanService.updateLoan(id, loanDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Loan", description = "Delete Loan In Database")
    public Map<String, Boolean> deleteLoan(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Deleting Loan: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", loanService.deleteLoan(id));
        return response;}
}