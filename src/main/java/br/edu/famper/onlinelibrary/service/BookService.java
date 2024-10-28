package br.edu.famper.onlinelibrary.service;

import br.edu.famper.onlinelibrary.dto.BookDto;
import br.edu.famper.onlinelibrary.model.Book;
import br.edu.famper.onlinelibrary.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookDto> getAllBooks() {
        return bookRepository
                .findAll()
                .stream()
                .map(book -> BookDto
                        .builder()
                        .title(book.getTitle())
                        .yearOfPublication(book.getYearOfPublication())
                        .price(book.getPrice())
                        .author(book.getAuthor())
                        .build()
                )
                .toList();
    }

    public BookDto getBookById(Long id) {return null;}

    public Book saveBook(BookDto bookDto) {return null;}

    public BookDto updateBook(Long id, BookDto bookDto) {return null;}

    public boolean deleteBook(Long id) {return false;}

}
