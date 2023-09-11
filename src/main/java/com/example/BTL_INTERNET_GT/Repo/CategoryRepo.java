package com.example.BTL_INTERNET_GT.Repo;

import com.example.BTL_INTERNET_GT.Entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
  @Query("SELECT category from Category  category")
    Page<Category> findCategory(Pageable pageable);

  @Query("SELECT category from Category  category where category.describeItem = :describeItem")
  Category findCategoryByDescribeItem(@Param("describeItem") String describeItem);
}
