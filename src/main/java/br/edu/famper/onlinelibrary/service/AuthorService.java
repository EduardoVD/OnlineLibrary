package br.edu.famper.onlinelibrary.service;
import br.edu.famper.onlinelibrary.dto.AuthorDto;
import br.edu.famper.onlinelibrary.model.Author;
import br.edu.famper.onlinelibrary.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//Provides an Editor´s List Formatted Like DTO...

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorService {

    //Using The Methods Like: "Get", "Save", "Update" And "Delete"...

    @Autowired
    private AuthorRepository authorRepository;

    public List<AuthorDto> getAllAuthors() {
        return authorRepository
                .findAll()
                .stream()
                .map(author -> AuthorDto
                        .builder()
                        .firstName(author.getFirstName())
                        .lastName(author.getLastName())
                        .dateOfBirth(author.getDateOfBirth())
                        .dateOfDeath(author.getDateOfDeath())
                        .writtenBook(author.getWrittenBook())
                        .build()
                )
                .toList();
    }

    public AuthorDto getAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow();
        return new AuthorDto()
                .builder()
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .dateOfBirth(author.getDateOfBirth())
                .dateOfDeath(author.getDateOfDeath())
                .writtenBook(author.getWrittenBook())
                .build();
    }

    public Author saveAuthor(AuthorDto authorDto) {
        Author author = new Author();
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        author.setDateOfBirth(authorDto.getDateOfBirth());
        author.setDateOfDeath(authorDto.getDateOfDeath());
        author.setWrittenBook(authorDto.getWrittenBook());
        return authorRepository.save(author);
    }

    public AuthorDto updateAuthor(Long id, AuthorDto authorDto) {
        Author author = authorRepository.findById(id).orElseThrow();
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        author.setDateOfBirth(authorDto.getDateOfBirth());
        author.setDateOfDeath(authorDto.getDateOfDeath());
        author.setWrittenBook(authorDto.getWrittenBook());
        Author authorUpdated = authorRepository.save(author);
        return new AuthorDto()
                .builder()
                .firstName(authorUpdated.getFirstName())
                .lastName(authorUpdated.getLastName())
                .dateOfBirth(authorUpdated.getDateOfBirth())
                .dateOfDeath(authorUpdated.getDateOfDeath())
                .writtenBook(authorUpdated.getWrittenBook())
                .build();
    }

    public boolean deleteAuthor(Long id) {
        try {
            Author author = authorRepository.findById(id).orElseThrow();
            authorRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
