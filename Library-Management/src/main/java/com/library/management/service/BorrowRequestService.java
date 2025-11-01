package com.library.management.service;

import com.library.management.model.BorrowRequest;
import com.library.management.model.Book;
import com.library.management.repository.BorrowRequestRepository;
import com.library.management.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowRequestService {
    private final BorrowRequestRepository reqRepo;
    private final BookRepository bookRepo;

    public BorrowRequestService(BorrowRequestRepository reqRepo, BookRepository bookRepo) {
        this.reqRepo = reqRepo;
        this.bookRepo = bookRepo;
    }

    public BorrowRequest create(BorrowRequest r) {
        r.setStatus("PENDING");
        return reqRepo.save(r);
    }

    public List<BorrowRequest> findAll() {
        return reqRepo.findAll();
    }

    @Transactional
    public BorrowRequest approve(Long requestId) {
        BorrowRequest r = reqRepo.findById(requestId).orElseThrow(() -> new RuntimeException("Request not found"));
        if (!"PENDING".equals(r.getStatus())) throw new RuntimeException("Request not pending");
        Book book = r.getBook();
        book.setBorrowedCount(book.getBorrowedCount() + 1);
        bookRepo.save(book);
        r.setStatus("APPROVED");
        return reqRepo.save(r);
    }

    @Transactional
    public BorrowRequest markReturned(Long requestId) {
        BorrowRequest r = reqRepo.findById(requestId).orElseThrow(() -> new RuntimeException("Request not found"));
        if (!"APPROVED".equals(r.getStatus())) throw new RuntimeException("Request not approved");
        Book book = r.getBook();
        book.setBorrowedCount(Math.max(0, book.getBorrowedCount() - 1));
        bookRepo.save(book);
        r.setStatus("RETURNED");
        return reqRepo.save(r);
    }

    public void delete(Long id) {
        reqRepo.deleteById(id);
    }

    public Optional<BorrowRequest> findById(Long id) {
        return reqRepo.findById(id);
    }
}
