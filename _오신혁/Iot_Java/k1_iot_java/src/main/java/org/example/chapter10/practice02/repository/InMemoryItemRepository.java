package org.example.chapter10.practice02.repository;

import org.example.chapter10.practice02.entity.Item;

import java.util.HashSet;
import java.util.Set;

public class InMemoryItemRepository implements ItemRepository {
    private Set<Item> items = new HashSet<Item>();

    // 데이터 입력
    @Override
    public void addItem(Item item) {
        items.add(item);
    }
    
    // 데이터 조회
    @Override
    public Set<Item> findAll() {
        return new HashSet<>(items);
    }
    
    // 회원 ID를 이용해서 조회하기
    @Override
    public Item findById(String itemId) {
        for (Item item:items) {
            if (item.getId().equals(itemId)) {
                return item;
            }
        }
        return null; // 객체 타입(참조 타입)의 기본 형태 null
    }
    
    // 회원 아이디를 이용해서 값을 삭제하기
    @Override
    public void removeItem(String itemId) {
        Item target = null;

        for (Item item: items) {
            if (item.getId().equals(itemId)) {
                target = item;
                break;
            }
        }

        if (target != null) {
            items.remove(target);
        }
    }
}
