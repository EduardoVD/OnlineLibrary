package br.edu.famper.onlinelibrary.service;

import br.edu.famper.onlinelibrary.dto.AuthorDto;
import br.edu.famper.onlinelibrary.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorService {

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
                        .build()
                )
                .toList();
    }
}
