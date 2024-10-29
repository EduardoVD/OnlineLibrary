package br.edu.famper.onlinelibrary.controller;
import br.edu.famper.onlinelibrary.dto.PublisherDto;
import br.edu.famper.onlinelibrary.service.PublisherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
}