package com.example.BTL_INTERNET_GT.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String describeItem;
    private Long totalItem;
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Item> items = new ArrayList<>();


}
