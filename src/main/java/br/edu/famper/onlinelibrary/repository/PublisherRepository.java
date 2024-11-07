package br.edu.famper.onlinelibrary.repository;
import br.edu.famper.onlinelibrary.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Creating The Repository For "Publisher"...

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}

//It´s Used To Interact With The Database, In An Easy Way And Organized...
