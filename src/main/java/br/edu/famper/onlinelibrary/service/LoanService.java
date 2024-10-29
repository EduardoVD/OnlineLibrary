package br.edu.famper.onlinelibrary.service;
import br.edu.famper.onlinelibrary.dto.LoanDto;
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

    public LoanDto getLoanById(Long id) {return null;}

    public Loan saveLoan(LoanDto loanDto) {return null;}

    public LoanDto updateLoan(Long id, LoanDto loanDto) {return null;}

    public boolean deleteLoan(Long id) {return false;}

}