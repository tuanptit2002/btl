package com.example.BTL_INTERNET_GT.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @CreatedDate
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date create_At;
    private double totalPrice;
    private String street;
    private String number;
    @ManyToMany
    @JoinTable(name = "user_bill", joinColumns = @JoinColumn(name = "bill_id"),inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

}
