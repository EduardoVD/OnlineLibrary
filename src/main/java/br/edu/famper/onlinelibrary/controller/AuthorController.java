package br.edu.famper.onlinelibrary.controller;
import br.edu.famper.onlinelibrary.dto.AuthorDto;
import br.edu.famper.onlinelibrary.exception.ResourceNotFoundException;
import br.edu.famper.onlinelibrary.model.Author;
import br.edu.famper.onlinelibrary.service.AuthorService;
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

//Controller For Operations´s Management Related To "Author"...

@RestController
@RequestMapping("onlineLibrary/author")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Author", description = "Operations For Author...")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get All Authors From Database...", description = "Fetches All Authors From Database And Return In JSON Array...")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public List<AuthorDto> getAllAuthors() {
        log.info("Searching For All Authors...");
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get One Author From Database", description = "Fetches One Author From Database And Return In JSON Object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Searching For Author By Code: {}", id);
        return ResponseEntity.ok().body(authorService.getAuthorById(id));
    }

    @PostMapping
    @Operation(summary = "Save Author", description = "Save Author In Database")
    public Author createAuthor(@RequestBody AuthorDto authorDto) throws ResourceNotFoundException {
        log.info("Registering Author: {}", authorDto);
        return authorService.saveAuthor(authorDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update Author", description = "Update Author In Database")
    public ResponseEntity<AuthorDto> updateAuthor(@PathVariable(name = "id") Long id, @RequestBody AuthorDto authorDto) throws ResourceNotFoundException {
        log.info("Updating Author: {}", authorDto);
        return ResponseEntity.ok().body(authorService.updateAuthor(id, authorDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Author", description = "Delete Author In Database")
    public Map<String, Boolean> deleteAuthor(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
    log.info("Deleting Author: {}", id);
    Map<String, Boolean> response = new HashMap<>();
    response.put("Deleted", authorService.deleteAuthor(id));
    return response;}
}
