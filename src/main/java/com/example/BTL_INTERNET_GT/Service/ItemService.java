package com.example.BTL_INTERNET_GT.Service;

import com.example.BTL_INTERNET_GT.DTO.CategoryDTO;
import com.example.BTL_INTERNET_GT.DTO.ItemDTO;
import com.example.BTL_INTERNET_GT.Entity.Item;

import java.util.List;

public interface ItemService {
    void create(ItemDTO itemDTO);
    void update(ItemDTO itemDTO);
    void delete(Long id);

    List<Item> items();

    Item getItem(Long id);
}
