package com.library.management.service;

import com.library.management.model.Customer;
import com.library.management.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById((long) id);
    }

    public Customer findByUsername(String username) {
        return customerRepository.findAll().stream()
                .filter(c -> c.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
}
