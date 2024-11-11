package br.edu.famper.onlinelibrary.controller;
import br.edu.famper.onlinelibrary.dto.AuthorDto;
import br.edu.famper.onlinelibrary.dto.BookDto;
import br.edu.famper.onlinelibrary.exception.ResourceNotFoundException;
import br.edu.famper.onlinelibrary.model.Book;
import br.edu.famper.onlinelibrary.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Controller For Operations´s Management Related To "Book"...

@RestController
@RequestMapping("/onlineLibrary/book")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Book", description = "Operations For Book...")
public class BookController {

    private final BookService bookService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get All Books From Database...", description = "Fetches All Books From Database And Return In JSON Array...")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public List<BookDto> getAllBooks() {
        log.info("Searching For All Books...");
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get One Book From Database...", description = "Fetches One Book From Database And Return In JSON Object...")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public ResponseEntity<BookDto> getBookById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Searching For Book By Code: {}", id);
        return ResponseEntity.ok().body(bookService.getBookById(id));
    }

    @PostMapping
    @Operation(summary = "Save Book...", description = "Save Book In Database...")
    public Book createBook(@RequestBody BookDto bookDto) throws ResourceNotFoundException {
        log.info("Registering Book: {}", bookDto);
        return bookService.saveBook(bookDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update Book...", description = "Update Book In Database...")
    public ResponseEntity<BookDto> updateBook(@PathVariable(name = "id") Long id, @RequestBody BookDto bookDto) throws ResourceNotFoundException {
        log.info("Updating Book: {}", bookDto);
        return ResponseEntity.ok().body(bookService.updateBook(id, bookDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Book...", description = "Delete Book In Database...")
    public Map<String, Boolean> deleteBook(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Deleting Book: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", bookService.deleteBook(id));
        return response;}
}
