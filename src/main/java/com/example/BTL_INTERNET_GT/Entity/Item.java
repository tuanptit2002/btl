package com.example.BTL_INTERNET_GT.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private String name;
    private String image;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category ;
    @JsonIgnore
    @OneToMany(mappedBy = "item")
    private List<Bill> bills = new ArrayList<>();
}
