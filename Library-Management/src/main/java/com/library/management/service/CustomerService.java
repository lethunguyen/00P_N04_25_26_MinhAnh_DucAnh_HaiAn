package com.library.management.service;

import com.library.management.model.Customer;
import com.library.management.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) { this.repo = repo; }

    public List<Customer> findAll() { return repo.findAll(); }
    public Optional<Customer> findById(Long id) { return repo.findById(id); }
    public Customer save(Customer c) { return repo.save(c); }
    public void deleteById(Long id) { repo.deleteById(id); }

    public Customer findByUsername(String username) { return repo.findByUsername(username); }
}
