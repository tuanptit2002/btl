package com.example.BTL_INTERNET_GT.Service;

import com.example.BTL_INTERNET_GT.DTO.BillDTO;
import com.example.BTL_INTERNET_GT.DTO.RespondDTO;

import java.text.ParseException;
import java.util.List;

public interface BillService {
    void create(BillDTO billDTO) throws ParseException;
    void totalData();
    List<RespondDTO> reportPrice() throws ParseException;
}
