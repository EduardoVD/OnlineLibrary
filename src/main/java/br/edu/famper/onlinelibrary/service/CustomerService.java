package br.edu.famper.onlinelibrary.service;
import br.edu.famper.onlinelibrary.dto.CustomerDto;
import br.edu.famper.onlinelibrary.model.Customer;
import br.edu.famper.onlinelibrary.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//Provides an Editor´s List Formatted Like DTO...

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDto> getAllCustomers() {
        return customerRepository
                .findAll()
                .stream()
                .map(customer -> CustomerDto
                        .builder()
                        .firstName(customer.getFirstName())
                        .lastName(customer.getLastName())
                        .phone(customer.getPhone())
                        .country(customer.getCountry())
                        .state(customer.getState())
                        .city(customer.getCity())
                        .build()
                )
                .toList();
    }

    //Using The Methods Like: "Get", "Save", "Update" And "Delete"...

    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        return new CustomerDto()
                .builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .phone(customer.getPhone())
                .country(customer.getCountry())
                .state(customer.getState())
                .city(customer.getCity())
                .build();
    }

    public Customer saveCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setPhone(customerDto.getPhone());
        customer.setCountry(customerDto.getCountry());
        customer.setState(customerDto.getState());
        customer.setCity(customerDto.getCity());
        return customerRepository.save(customer);
    }

    public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setPhone(customerDto.getPhone());
        customer.setCountry(customerDto.getCountry());
        customer.setState(customerDto.getState());
        customer.setCity(customerDto.getCity());
        Customer customerUpdated = customerRepository.save(customer);
        return new CustomerDto()
                .builder()
                .firstName(customerUpdated.getFirstName())
                .lastName(customerUpdated.getLastName())
                .phone(customerUpdated.getPhone())
                .country(customerUpdated.getCountry())
                .state(customerUpdated.getState())
                .city(customerUpdated.getCity())
                .build();
    }

    public boolean deleteCustomer(Long id) {
        try {
            Customer customer = customerRepository.findById(id).orElseThrow();
            customerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
