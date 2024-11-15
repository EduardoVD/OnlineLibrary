package br.edu.famper.onlinelibrary.service;
import br.edu.famper.onlinelibrary.model.Loan;
import br.edu.famper.onlinelibrary.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoanService {

    //Using The Methods Like: "Get", "Save", "Update" And "Delete"...

    @Autowired
    private LoanRepository loanRepository;

    //Method For Get All Loans From Database...

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    //Method To Get One Loan From Database...

    public Loan getLoanById(Long id) {
        return loanRepository.findById(id).orElseThrow();
    }

    //Method For Add An New Loan...

    public Loan saveLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    //Method For Update An Loan From Database...

    public Loan updateLoan(Long id, Loan loan) {
        Loan newLoan = loanRepository.findById(id).orElseThrow();
        newLoan.setUnpaidDebt(loan.getUnpaidDebt());
        newLoan.setCustomer(loan.getCustomer());
        newLoan.setBook(loan.getBook());
        return loanRepository.save(newLoan);
    }

    //Method For Delete One Loan From Database...

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