package com.example.BTL_INTERNET_GT.Controller;

import com.example.BTL_INTERNET_GT.DTO.CategoryDTO;
import com.example.BTL_INTERNET_GT.DTO.PageDTO;
import com.example.BTL_INTERNET_GT.Entity.Category;
import com.example.BTL_INTERNET_GT.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public void createCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.create(categoryDTO);
    }

    @PostMapping("/update")
    public void updateCategory(@RequestBody CategoryDTO categoryDTO) {

        categoryService.update(categoryDTO);
    }

    @DeleteMapping("/delete")
    public void deleteCategory(@RequestParam Long id) {
        categoryService.delete(id);
    }

    @GetMapping("/category/{id}")
    public CategoryDTO getCategory(@PathVariable("id") Long id) {
        return categoryService.detail(id);
    }

    @PostMapping("/category/list")
    public Page<Category> categories(@RequestBody PageDTO pageDTO) {
        return categoryService.categories(pageDTO);
    }

    @GetMapping("/find/all")
    public List<Category> findCategories() {
        return categoryService.findCategories();
    }
}
