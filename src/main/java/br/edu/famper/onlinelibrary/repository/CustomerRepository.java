package br.edu.famper.onlinelibrary.repository;

import br.edu.famper.onlinelibrary.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
