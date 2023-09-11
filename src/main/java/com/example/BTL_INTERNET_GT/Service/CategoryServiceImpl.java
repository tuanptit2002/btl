package com.example.BTL_INTERNET_GT.Service;

import com.example.BTL_INTERNET_GT.DTO.CategoryDTO;
import com.example.BTL_INTERNET_GT.DTO.PageDTO;
import com.example.BTL_INTERNET_GT.Entity.Category;
import com.example.BTL_INTERNET_GT.Repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepo categoryRepo;


    public void create(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setDescribeItem(categoryDTO.getDescribe());
        category.setTotalItem(categoryDTO.getTotal());
        categoryRepo.save(category);
    }

    @Transactional
    public void update(CategoryDTO categoryDTO) {

        Category category = categoryRepo.findById(categoryDTO.getId()).orElseThrow((() -> new RuntimeException("Category Valid")));
                category.setTotalItem(categoryDTO.getTotal());
                category.setDescribeItem(categoryDTO.getDescribe());
                categoryRepo.save(category);
    }
    public void delete(Long id){
        categoryRepo.deleteById(id);
    }
    public CategoryDTO detail(Long id){
        Category category = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category valid"));
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setDescribe(category.getDescribeItem());
        categoryDTO.setTotal(category.getTotalItem());
        return categoryDTO;
    }

    public Page<Category> categories(PageDTO pageDTO){
        Pageable pageable = PageRequest.of(pageDTO.getPage(), pageDTO.getPageSize());
        Page<Category> categories = categoryRepo.findCategory(pageable);
        System.out.println(categories.getContent());
        return categories;
    }

    public List<Category> findCategories(){
        List<Category> categories = categoryRepo.findAll();
        return categories;
    }
}
