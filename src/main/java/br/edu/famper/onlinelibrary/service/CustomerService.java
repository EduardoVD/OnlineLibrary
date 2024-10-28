package br.edu.famper.onlinelibrary.service;

import br.edu.famper.onlinelibrary.dto.CustomerDto;
import br.edu.famper.onlinelibrary.model.Customer;
import br.edu.famper.onlinelibrary.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDto> getAllUsers() {
        return customerRepository
                .findAll()
                .stream()
                .map(user -> CustomerDto
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

    public CustomerDto getCustomerById(Long id) {return null;}

    public Customer saveCustomer(CustomerDto customerDto) {return null;}

    public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {return null;}

    public boolean deleteCustomer(Long id) {return false;}

}
