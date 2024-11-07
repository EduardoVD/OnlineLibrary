package br.edu.famper.onlinelibrary.repository;
import br.edu.famper.onlinelibrary.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Creating The Repository For "Customer"...

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

//It´s Used To Interact With The Database, In An Easy Way And Organized...
