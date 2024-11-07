package br.edu.famper.onlinelibrary.repository;
import br.edu.famper.onlinelibrary.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Creating The Repository For "Loan"...

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
}

//It´s Used To Interact With The Database, In An Easy Way And Organized...
