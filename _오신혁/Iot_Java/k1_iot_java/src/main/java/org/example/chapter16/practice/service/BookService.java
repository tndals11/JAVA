package org.example.chapter16.practice.service;


import org.example.chapter16.practice.entity.Category;
import org.example.chapter16.practice.entity.Item;

import java.util.List;

public interface BookService {
    // 생성
    List<Item> searchByCategory(Category category); // Category 클래스를 받아서 List로 처리

    

}
