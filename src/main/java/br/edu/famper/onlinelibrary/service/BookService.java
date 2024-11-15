package br.edu.famper.onlinelibrary.service;
import br.edu.famper.onlinelibrary.dto.BookDto;
import br.edu.famper.onlinelibrary.model.Book;
import br.edu.famper.onlinelibrary.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//Provides an Editor´s List Formatted Like DTO...

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    //Using The Methods Like: "Get", "Save", "Update" And "Delete"...

    @Autowired
    private BookRepository bookRepository;

    //Method For Get All Books From Database...

    public List<BookDto> getAllBooks() {
        return bookRepository
                .findAll()
                .stream()
                .map(book -> BookDto
                        .builder()
                        .title(book.getTitle())
                        .genre(book.getGenre())
                        .numberOfPages(book.getNumberOfPages())
                        .yearOfPublication(book.getYearOfPublication())
                        .price(book.getPrice())
                        .author(book.getAuthor())
                        .build()
                )
                .toList();
    }

    //Method To Get One Book From Database...

    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        return new BookDto()
                .builder()
                .title(book.getTitle())
                .genre(book.getGenre())
                .numberOfPages(book.getNumberOfPages())
                .yearOfPublication(book.getYearOfPublication())
                .price(book.getPrice())
                .author(book.getAuthor())
                .build();
    }

    //Method For Add An New Book...

    public Book saveBook(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setGenre(bookDto.getGenre());
        book.setNumberOfPages(bookDto.getNumberOfPages());
        book.setYearOfPublication(bookDto.getYearOfPublication());
        book.setPrice(bookDto.getPrice());
        book.setAuthor(bookDto.getAuthor());
        return bookRepository.save(book);
    }

    //Method For Update An Book From Database...

    public BookDto updateBook(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setTitle(bookDto.getTitle());
        book.setGenre(bookDto.getGenre());
        book.setNumberOfPages(bookDto.getNumberOfPages());
        book.setYearOfPublication(bookDto.getYearOfPublication());
        book.setPrice(bookDto.getPrice());
        book.setAuthor(bookDto.getAuthor());
        Book bookUpdated = bookRepository.save(book);
        return new BookDto()
                .builder()
                .title(bookUpdated.getTitle())
                .genre(bookUpdated.getGenre())
                .numberOfPages(bookUpdated.getNumberOfPages())
                .yearOfPublication(bookUpdated.getYearOfPublication())
                .price(bookUpdated.getPrice())
                .author(bookUpdated.getAuthor())
                .build();
    }

    //Method For Delete One Book From Database...

    public boolean deleteBook(Long id) {
        try {
            Book book = bookRepository.findById(id).orElseThrow();
            bookRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
