package org.example.chapter13.practice.service;

import java.util.List;

public interface BookManger<T>  {
    // T: 타입변수
    // - 해당 인터페이스로 실질적인 비즈니스 로직 구현 시 타입을 명시
    void addBook(T book); 
    T findBookById(String id); // 단건 조회
    List<T> listAllBooks(); // 전체 조회
    void updateBook(String id, T updateBook);
    void deleteBook(String id);
}
