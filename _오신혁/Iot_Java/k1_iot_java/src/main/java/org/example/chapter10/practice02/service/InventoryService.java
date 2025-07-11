package org.example.chapter10.practice02.service;

import org.example.chapter10.practice02.entity.Item;

import java.util.List;

public interface InventoryService {
    void addItem(Item item);
    List<Item> getItemByCategory(String category);
    boolean updateItemPrice(String itemId, int newPrice);
    void deleteItem(String itemId);
}
