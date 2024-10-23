package br.edu.famper.onlinelibrary.controller;

import br.edu.famper.onlinelibrary.dto.BookDto;
import br.edu.famper.onlinelibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/onlineLibrary/book")
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService bookService;

    @GetMapping
    @ResponseStatus
    public List<BookDto> getAllBooks() {
        log.info("Searching For All Books");
        return bookService.getAllBooks();
    }
}
