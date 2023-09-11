package com.example.BTL_INTERNET_GT.Repo;

import com.example.BTL_INTERNET_GT.Entity.Bill;
import com.example.BTL_INTERNET_GT.Entity.DataUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepo extends JpaRepository<Bill, Long> {
//    List<Bill> fi
}
