package br.edu.famper.onlinelibrary.repository;
import br.edu.famper.onlinelibrary.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
}
