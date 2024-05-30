package ra.model;

import java.sql.Date;

public class Book {
    private Integer bookId;
    private Integer categoryId;
    private String bookName;
    private Double bookPrice;
    private Integer stock;
    private Integer totalPages;
    private java.sql.Date yearCreated;
    private String author;
    private boolean bookStatus;

    public Book() {
    }

    public Book(Integer bookId, Integer categoryId, String bookName, Double bookPrice, Integer stock, Integer totalPages, Date yearCreated, String author, boolean bookStatus) {
        this.bookId = bookId;
        this.categoryId = categoryId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.stock = stock;
        this.totalPages = totalPages;
        this.yearCreated = yearCreated;
        this.author = author;
        this.bookStatus = bookStatus;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Date getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(Date yearCreated) {
        this.yearCreated = yearCreated;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }
}
