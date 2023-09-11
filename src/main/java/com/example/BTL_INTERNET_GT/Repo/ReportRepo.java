package com.example.BTL_INTERNET_GT.Repo;

import com.example.BTL_INTERNET_GT.Entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ReportRepo extends JpaRepository<Report, Long> {
    @Query("select distinct rp.date from Report rp")
    List<Date> dates();

    @Query("SELECT rp.count_date from Report as rp where rp.date = :date" )
    List<Double> totalPrice(@Param("date") Date date);
}
