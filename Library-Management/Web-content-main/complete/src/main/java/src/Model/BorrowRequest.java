package src.Model;

import java.time.LocalDate;

public class BorrowRequest {
    private int id;
    private int customerId;
    private int bookId;
    private String status; // Pending, Approved, Rejected
    private LocalDate requestDate;
    private LocalDate returnDate;

    public BorrowRequest() {}

    public BorrowRequest(int id, int customerId, int bookId, String status,
                         LocalDate requestDate, LocalDate returnDate) {
        this.id = id;
        this.customerId = customerId;
        this.bookId = bookId;
        this.status = status;
        this.requestDate = requestDate;
        this.returnDate = returnDate;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getRequestDate() { return requestDate; }
    public void setRequestDate(LocalDate requestDate) { this.requestDate = requestDate; }

    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }

    @Override
    public String toString() {
        return "BorrowRequest{" +
                "bookId=" + bookId +
                ", status='" + status + '\'' +
                ", returnDate=" + returnDate +
                '}';
    }
}
