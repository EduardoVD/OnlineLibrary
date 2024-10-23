package br.edu.famper.onlinelibrary.controller;

import br.edu.famper.onlinelibrary.dto.LoanDto;
import br.edu.famper.onlinelibrary.service.LoanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/onlineLibrary/loan")
@RequiredArgsConstructor
@Slf4j
public class LoanController {

    private final LoanService loanService;

    @GetMapping
    public List<LoanDto> getAllLoans() {
        log.info("Searching For All Loans");
        return loanService.getAllLoans();
    }
}
