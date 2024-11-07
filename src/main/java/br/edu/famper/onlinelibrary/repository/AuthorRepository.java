package br.edu.famper.onlinelibrary.repository;
import br.edu.famper.onlinelibrary.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Creating The Repository For "Author"...

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}

//It´s Used To Interact With The Database, In An Easy Way And Organized...