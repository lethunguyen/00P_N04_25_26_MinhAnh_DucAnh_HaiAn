package com.library.management.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;

    @Column(name = "publish_year")
    private Integer publishYear;

    private Integer quantity = 0;

    @Column(name = "borrowed_count")
    private Integer borrowedCount = 0;

    @OneToMany(mappedBy = "book")
    private List<BorrowRequest> borrowRequests;

    public Book() {}

    // getters & setters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public Integer getPublishYear() { return publishYear; }
    public Integer getQuantity() { return quantity; }
    public Integer getBorrowedCount() { return borrowedCount; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setPublishYear(Integer publishYear) { this.publishYear = publishYear; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public void setBorrowedCount(Integer borrowedCount) { this.borrowedCount = borrowedCount; }

    @Override
    public String toString() {
        return title + " by " + author + " (" + publishYear + ")";
    }
}
