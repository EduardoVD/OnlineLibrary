package br.edu.famper.onlinelibrary.service;

import br.edu.famper.onlinelibrary.dto.LoanDto;
import br.edu.famper.onlinelibrary.model.Book;
import br.edu.famper.onlinelibrary.model.Loan;
import br.edu.famper.onlinelibrary.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Provides an Editor´s List Formatted Like DTO...

@Service
@RequiredArgsConstructor
@Slf4j
public class LoanService {

    //Correct

    @Autowired
    private LoanRepository loanRepository;

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    //Correct
    //Using The Methods Like: "Get", "Save", "Update" And "Delete"...

    public Loan getLoanById(Long id) {
        return loanRepository.findById(id).orElseThrow();
    }

    //Correct

    public Loan saveLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public Loan updateLoan(Long id, Loan loan) {
        Loan newLoan = loanRepository.findById(id).orElseThrow();
        newLoan.setUnpaidDebt(loan.getUnpaidDebt());
        newLoan.setCustomer(loan.getCustomer());
        newLoan.setBook(loan.getBook());
        return loanRepository.save(newLoan);
    }

    //Correct

    public boolean deleteLoan(Long id) {
        try {
            Loan loan = loanRepository.findById(id).orElseThrow();
            loanRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}