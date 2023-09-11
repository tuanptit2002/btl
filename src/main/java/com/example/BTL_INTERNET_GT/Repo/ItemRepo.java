package com.example.BTL_INTERNET_GT.Repo;

import com.example.BTL_INTERNET_GT.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {
    @Query("select item from Item item")
    List<Item> getallItems();
}
