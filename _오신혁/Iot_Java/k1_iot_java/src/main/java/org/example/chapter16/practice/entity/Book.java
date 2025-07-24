package org.example.chapter16.practice.entity;


import lombok.Getter;

@Getter
public class Book extends Item {
    private String isbn; // 책의 고유값
    private String author;
    private String publisher;
    // private int publisher
    // private int price;
    // private int stock;
    private Category category;

    @Override
    public void display() { // 추상 메서드 abstract display() 메서드로 출력을 할거기 때문에 Item에 toString 명시를 안해도 된다.
        System.out.println("ID: " + getId() + ", Title: " + getName() + ", Categort" + category);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getId() {
        return super.getId();
    }

    public Book(String id, String name, String isbn, String author, String publisher, Category category) {
        super(id, name);
        this.isbn = isbn;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
    }
}
