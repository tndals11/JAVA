package org.example.chapter13.practice.model;

import lombok.Getter;

@Getter
public class Fiction extends Book {
    private String genre; // 추리, 미스터리, 로맨스, 판타지 등등

    public Fiction(String id, String title, String author, String genre) {
        super(id, title, author); // 추상 클래스를 사용했기 때문에 재정의해서 사용해야한다
        this.genre = genre;
    }

    @Override
    public String toString() {
        return super.toString() + ", Genre: " + genre;
    }
}
