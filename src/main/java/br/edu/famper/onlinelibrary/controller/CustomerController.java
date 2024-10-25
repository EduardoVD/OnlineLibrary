package br.edu.famper.onlinelibrary.controller;

import br.edu.famper.onlinelibrary.dto.CustomerDto;
import br.edu.famper.onlinelibrary.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/onlineLibrary/user")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<CustomerDto> getAllUsers() {
        log.info("Searching For All Users");
        return customerService.getAllUsers();
    }
}
