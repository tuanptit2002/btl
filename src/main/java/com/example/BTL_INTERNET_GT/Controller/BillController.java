package com.example.BTL_INTERNET_GT.Controller;

import com.example.BTL_INTERNET_GT.DTO.BillDTO;
import com.example.BTL_INTERNET_GT.DTO.RespondDTO;
import com.example.BTL_INTERNET_GT.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/bill")
public class BillController {
    @Autowired
    BillService billService;

    @PostMapping("/create")
    public void create(@RequestBody BillDTO billDTO) throws ParseException {
        billService.create(billDTO);
    }
    @PostMapping("/refresh/data")
    public void report(){
        billService.totalData();
    }
    @PostMapping("/report")
    public List<RespondDTO> dataPrice() throws ParseException {
       return billService.reportPrice();
    }
}
