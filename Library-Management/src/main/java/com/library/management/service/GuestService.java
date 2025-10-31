package com.library.management.service;

import com.library.management.model.Guest;
import com.library.management.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {
    private final GuestRepository repo;

    public GuestService(GuestRepository repo) { this.repo = repo; }

    public List<Guest> findAll() { return repo.findAll(); }
    public Optional<Guest> findById(Long id) { return repo.findById(id); }
    public Guest save(Guest g) { return repo.save(g); }
    public void deleteById(Long id) { repo.deleteById(id); }
}
