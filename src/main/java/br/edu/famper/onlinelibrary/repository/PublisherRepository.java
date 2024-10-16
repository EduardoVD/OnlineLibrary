package br.edu.famper.onlinelibrary.repository;

import br.edu.famper.onlinelibrary.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
