package com.example.BTL_INTERNET_GT.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class BillDTO {
    private String title;
    private String create_At;
    private double totalPrice;
    private String street;
    private String number;
    private List<UserDTO> userDTOS = new ArrayList<>();
    private Long itemDTOS;
}
