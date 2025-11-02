package com.library.management.service;

import com.library.management.model.BorrowRequest;
import com.library.management.repository.BorrowRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BorrowRequestService {

    @Autowired
    private BorrowRequestRepository borrowRequestRepository;

    public List<BorrowRequest> getAllRequests() {
        return borrowRequestRepository.findAll();
    }

    public void saveRequest(BorrowRequest request) {
        borrowRequestRepository.save(request);
    }

    public void deleteRequest(int id) {
        borrowRequestRepository.deleteById((long) id);
    }
}
