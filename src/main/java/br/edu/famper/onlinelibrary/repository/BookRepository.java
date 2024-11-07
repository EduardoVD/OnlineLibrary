package br.edu.famper.onlinelibrary.repository;
import br.edu.famper.onlinelibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Creating The Repository For "Book"...

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}

//It´s Used To Interact With The Database, In An Easy Way And Organized...
