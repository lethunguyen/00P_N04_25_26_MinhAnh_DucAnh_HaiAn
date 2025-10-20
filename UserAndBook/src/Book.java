//package UserAndBook.src;

public class Book {
    private String id;        // Mã sách
    private String title;     // Tên sách
    private String author;    // Tác giả
    private int year;         // Năm xuất bản
    private int quantity;     // Số lượng

    // Constructor
    public Book(String id, String title, String author, int year, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.quantity = quantity;
    }

    // Getter & Setter
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getYear() {
        return year;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book[ID=" + id + ", Title=" + title + ", Author=" + author +
               ", Year=" + year + ", Quantity=" + quantity + "]";
    }
}
