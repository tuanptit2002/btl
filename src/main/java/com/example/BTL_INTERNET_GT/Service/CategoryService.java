package com.example.BTL_INTERNET_GT.Service;

import com.example.BTL_INTERNET_GT.DTO.CategoryDTO;
import com.example.BTL_INTERNET_GT.DTO.PageDTO;
import com.example.BTL_INTERNET_GT.Entity.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {

    void create(CategoryDTO categoryDTO);
    void update(CategoryDTO categoryDTO);

    void delete(Long id);
    CategoryDTO detail(Long id);
    Page<Category> categories(PageDTO pageDTO);
    List<Category> findCategories();
}
