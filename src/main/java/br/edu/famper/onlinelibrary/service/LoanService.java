package br.edu.famper.onlinelibrary.service;
import br.edu.famper.onlinelibrary.dto.LoanDto;
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

    @Autowired
    private LoanRepository loanRepository;

    public List<LoanDto> getAllLoans() {
        return loanRepository
                .findAll()
                .stream()
                .map(loan -> LoanDto
                        .builder()
                        .unpaidDebt(loan.getUnpaidDebt())
                        .build()
                )
                .toList();
    }

    //Using The Methods Like: "Get", "Save", "Update" And "Delete"...

    public LoanDto getLoanById(Long id) {
        Loan loan = loanRepository.findById(id).orElseThrow();
        return new LoanDto()
                .builder()
                .unpaidDebt(loan.getUnpaidDebt())
                .build();
    }

    public Loan saveLoan(LoanDto loanDto) {
        Loan loan = new Loan();;
        loan.setUnpaidDebt(loanDto.getUnpaidDebt());
        return loanRepository.save(loan);
    }

    public LoanDto updateLoan(Long id, LoanDto loanDto) {
        Loan loan = loanRepository.findById(id).orElseThrow();
        loan.setUnpaidDebt(loanDto.getUnpaidDebt());
        Loan loanUpdated = loanRepository.save(loan);
        return new LoanDto()
                .builder()
                .unpaidDebt(loanUpdated.getUnpaidDebt())
                .build();
    }

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