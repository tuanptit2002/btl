package com.example.BTL_INTERNET_GT.Service;
import com.example.BTL_INTERNET_GT.DTO.BillDTO;
import com.example.BTL_INTERNET_GT.DTO.RespondDTO;
import com.example.BTL_INTERNET_GT.DTO.UserDTO;
import com.example.BTL_INTERNET_GT.Entity.Bill;
import com.example.BTL_INTERNET_GT.Entity.Item;
import com.example.BTL_INTERNET_GT.Entity.Report;
import com.example.BTL_INTERNET_GT.Entity.User;
import com.example.BTL_INTERNET_GT.Repo.BillRepo;
import com.example.BTL_INTERNET_GT.Repo.ItemRepo;
import com.example.BTL_INTERNET_GT.Repo.ReportRepo;
import com.example.BTL_INTERNET_GT.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BillServiceImpl implements   BillService{

    @Autowired
    BillRepo billRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    ItemRepo itemRepo;

    @Autowired
    ReportRepo reportRepo;
    public void create(BillDTO billDTO) throws ParseException {
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
        Bill bill = new Bill();
        bill.setTitle(billDTO.getTitle());
        bill.setCreate_At(formatter1.parse(billDTO.getCreate_At()));
        List<User> users = new ArrayList<>();
        for (UserDTO userDTO : billDTO.getUserDTOS()) {
            User user = new User();
            user.setFullName(userDTO.getUser_name());
            user.setPhoneNumber(userDTO.getMobile_number());
            users.add(user);
        }
        bill.setUsers(users);
        bill.setStreet(billDTO.getStreet());
        bill.setNumber(billDTO.getNumber());
        Item item = itemRepo.findById(billDTO.getItemDTOS()).orElseThrow(() -> new RuntimeException("Item Validate"));
        bill.setItem(item);
        bill.setTotalPrice(billDTO.getTotalPrice());
        billRepo.save(bill);
    }
     public void totalData(){
        reportRepo.deleteAll();
        List<Bill> bills = billRepo.findAll();
        for(Bill bill : bills){
            Report report = new Report();
            report.setDate(bill.getCreate_At());
            report.setCount_date(bill.getTotalPrice());
            reportRepo.save(report);
        }
     }
     public List<RespondDTO> reportPrice() throws ParseException {
        List<Date> dates = reportRepo.dates();
        List<RespondDTO> respondDTOS = new ArrayList<>();
        for (Date date : dates){
            List<Double> prices = reportRepo.totalPrice(date);
            double total = 0;
            for(double price : prices){
                total += price;
            }
            RespondDTO dto = new RespondDTO();
            String dateRespond = date.toString();
            dto.setDate(dateRespond.substring(0,10));
            dto.setPrice_data(total);
            respondDTOS.add(dto);
        }
        return  respondDTOS;
     }
}
