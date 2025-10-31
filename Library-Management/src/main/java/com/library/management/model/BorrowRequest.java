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

    @ManyToOne @JoinColumn(name = "approved_by", nullable = true)
    private Employee approvedBy; // use Employee entity

    private String status;
    private LocalDate requestDate;
    private LocalDate returnDate;

    public BorrowRequest() {
        this.requestDate = LocalDate.now();
        this.status = "PENDING";
    }

    // getters & setters
    public Long getId() { return id; }
    public Customer getCustomer() { return customer; }
    public Book getBook() { return book; }
    public Employee getApprovedBy() { return approvedBy; }
    public String getStatus() { return status; }
    public LocalDate getRequestDate() { return requestDate; }
    public LocalDate getReturnDate() { return returnDate; }

    public void setCustomer(Customer customer) { this.customer = customer; }
    public void setBook(Book book) { this.book = book; }
    public void setApprovedBy(Employee approvedBy) { this.approvedBy = approvedBy; }
    public void setStatus(String status) { this.status = status; }
    public void setRequestDate(LocalDate requestDate) { this.requestDate = requestDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
}
