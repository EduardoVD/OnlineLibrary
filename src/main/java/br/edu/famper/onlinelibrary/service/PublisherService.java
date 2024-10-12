package br.edu.famper.onlinelibrary.service;

import br.edu.famper.onlinelibrary.dto.PublisherDto;
import br.edu.famper.onlinelibrary.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public List<PublisherDto> getAllPublishers() {
        return publisherRepository
                .findAll()
                .stream()
                .map(publisher -> PublisherDto
                        .builder()
                        .name(publisher.getName())
                        .build()
                )
                .toList();
    }
}
