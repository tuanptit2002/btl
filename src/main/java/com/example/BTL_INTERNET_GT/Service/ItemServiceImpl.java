package com.example.BTL_INTERNET_GT.Service;

import com.example.BTL_INTERNET_GT.DTO.ItemDTO;
import com.example.BTL_INTERNET_GT.Entity.Category;
import com.example.BTL_INTERNET_GT.Entity.Item;
import com.example.BTL_INTERNET_GT.Repo.CategoryRepo;
import com.example.BTL_INTERNET_GT.Repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepo itemRepo;

    @Autowired
    CategoryRepo categoryRepo;

    public void create(ItemDTO itemDTO) {
        Item item = new Item();
        item.setPrice(itemDTO.getPrice());
        item.setName(itemDTO.getName());
        item.setImage(itemDTO.getImage());
        Category category = categoryRepo.findCategoryByDescribeItem(itemDTO.getCategoryDTO().getDescribe());
//        Category category = categoryRepo.findById(itemDTO.getCategoryDTO().getId()).orElseThrow(() -> new RuntimeException("Category validate"));
//        Category category = categoryRepo.findCategoryById(itemDTO.getCategoryDTO().getId());
        item.setCategory(category);
        itemRepo.save(item);
    }

    public void update(ItemDTO itemDTO) {
        Item item = itemRepo.findById(itemDTO.getId()).orElseThrow(() -> new RuntimeException("Item Valid"));
        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());
        item.setImage(itemDTO.getImage());
        Category category  = categoryRepo.findCategoryByDescribeItem(itemDTO.getCategoryDTO().getDescribe());
        item.setCategory(category);
        itemRepo.save(item);
    }

    public void delete(Long id) {
        itemRepo.deleteById(id);
    }
    public List<Item> items (){
        List<Item> items =  itemRepo.findAll();
        return items;
    }

    public Item getItem(Long id){
        Item item =  itemRepo.findById(id).orElseThrow(() -> new RuntimeException("item validate"));
        return item;
    }
}
