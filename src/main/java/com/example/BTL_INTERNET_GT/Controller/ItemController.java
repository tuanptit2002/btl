package com.example.BTL_INTERNET_GT.Controller;

import com.example.BTL_INTERNET_GT.DTO.ItemDTO;
import com.example.BTL_INTERNET_GT.Entity.Item;
import com.example.BTL_INTERNET_GT.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping("/create")
    public void create(@RequestBody ItemDTO itemDTO){

        itemService.create(itemDTO);
    }

    @PostMapping("/update")
    public void update(@RequestBody ItemDTO itemDTO){

        itemService.update(itemDTO);
    }

    @GetMapping("/find/all")
    public List<Item> getAll(){
        return
                itemService.items();
    }

    @DeleteMapping("/delete")
    public void deleteItem(@RequestParam Long id) {
        itemService.delete(id);
    }

    @GetMapping("get/{id}")
    public Item getItem(@PathVariable("id") Long id){
       return itemService.getItem(id);
    }
}
