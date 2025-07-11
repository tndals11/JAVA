package org.example.chapter10.practice01;

// 제품이 가져야 할 필수 구성을 상속받은 Book 클래스
public class Book extends Item {
    // Book에 사용될 필드 선언
    // id, name
    private String isbn;
    private String author;
    private String publisher;
    private int publishYear;
    private int price;
    private int stock;
    private String category;
    
    // 매개변수를 입력할 생성자 생성
    // super을 이용해서 Item의 id, name 상속
    public Book(String id, String name, String isbn, String author,
                String publisher, int publishYear, int price, int stock, String category
    ) {
        super(id, name);
        this.isbn = isbn;
        this.author = author;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    // getter 생성
    public String getIsbn() { return isbn; }
    public String getAuthor() { return author; }
    public String getPublisher() { return publisher; }
    public String getCategory() { return category; }
    public int getPublishYear() { return publishYear; }
    public int getPrice() { return price; }
    public int getStock() { return stock; }

    public void updateStock(int quantity) {
        this.stock = quantity;
    }

    @Override
    public void display() {
        System.out.println("ID: " + getId() + ", Name: " + getName() + ", ISBN: " + isbn);
    }
}