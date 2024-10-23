package br.edu.famper.onlinelibrary.controller;

import br.edu.famper.onlinelibrary.dto.PublisherDto;
import br.edu.famper.onlinelibrary.service.PublisherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/onlineLibrary/publisher")
@RequiredArgsConstructor
@CrossOrigin
public class PublisherController {

    private final PublisherService publisherService;

    @GetMapping
    public List<PublisherDto> getAllPublishers(){
        log.info("Searching For All Publishers");
        return publisherService.getAllPublishers();
    }
}
