package br.edu.famper.onlinelibrary.controller;
import br.edu.famper.onlinelibrary.dto.PublisherDto;
import br.edu.famper.onlinelibrary.exception.ResourceNotFoundException;
import br.edu.famper.onlinelibrary.model.Author;
import br.edu.famper.onlinelibrary.model.Publisher;
import br.edu.famper.onlinelibrary.service.PublisherService;
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

//Controller For Operations´s Management Related To "Publisher"...

@Slf4j
@RestController
@RequestMapping("/onlineLibrary/publisher")
@RequiredArgsConstructor
@CrossOrigin
@Tag(name = "Publisher", description = "Operations For Publisher...")
public class PublisherController {

    private final PublisherService publisherService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get All Publishers From Database...", description = "Fetches All Publishers From Database And Return In JSON Array...")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public List<PublisherDto> getAllPublishers(){
        log.info("Searching For All Publishers...");
        return publisherService.getAllPublishers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get One Publisher From Database", description = "Fetches One Publisher From Database And Return In JSON Object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    public ResponseEntity<PublisherDto> getPublisherById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Searching For Publisher By Code: {}", id);
        return ResponseEntity.ok().body(publisherService.getPublisherById(id));
    }

    @PostMapping
    @Operation(summary = "Save Publisher", description = "Save Publisher In Database")
    public Publisher createPublisher(@RequestBody PublisherDto publisherDto) throws ResourceNotFoundException {
        log.info("Registering Publisher: {}", publisherDto);
        return publisherService.savePublisher(publisherDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update Publisher", description = "Update Publisher In Database")
    public ResponseEntity<PublisherDto> updatePublisher(@PathVariable(name = "id") Long id, @RequestBody PublisherDto publisherDto) throws ResourceNotFoundException {
        log.info("Updating Publisher: {}", publisherDto);
        return ResponseEntity.ok().body(publisherService.updatePublisher(id, publisherDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Publisher", description = "Delete Publisher In Database")
    public Map<String, Boolean> deletePublisher(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Deleting Publisher: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", publisherService.deletePublisher(id));
        return response;}
}