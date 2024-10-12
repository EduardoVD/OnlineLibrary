package br.edu.famper.onlinelibrary.service;

import br.edu.famper.onlinelibrary.dto.UserDto;
import br.edu.famper.onlinelibrary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(user -> UserDto
                        .builder()
                        .name(user.getName())
                        .phone(user.getPhone())
                        .country(user.getCountry())
                        .state(user.getState())
                        .city(user.getCity())
                        .build()
                )
                .toList();
    }
}
