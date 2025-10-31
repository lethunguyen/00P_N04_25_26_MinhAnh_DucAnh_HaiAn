package com.library.management.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "borrow_requests")
public class BorrowRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne @JoinColumn(name = "approved_by")
    private Librarian approvedBy;

    private String status;
    private LocalDate requestDate;
    private LocalDate returnDate;

    public BorrowRequest() {
        this.requestDate = LocalDate.now();
        this.status = "Pending";
    }

    // getters and setters
    public Long getId() { return id; }
    public Customer getCustomer() { return customer; }
    public Book getBook() { return book; }
    public Librarian getApprovedBy() { return approvedBy; }
    public String getStatus() { return status; }
    public LocalDate getRequestDate() { return requestDate; }
    public LocalDate getReturnDate() { return returnDate; }

    public void setCustomer(Customer customer) { this.customer = customer; }
    public void setBook(Book book) { this.book = book; }
    public void setApprovedBy(Librarian approvedBy) { this.approvedBy = approvedBy; }
    public void setStatus(String status) { this.status = status; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
}
