package fr.adrienfdupont.demo.controllers;

import fr.adrienfdupont.demo.dto.CreateCategoryDto;
import fr.adrienfdupont.demo.dto.UpdateCategoryDto;
import fr.adrienfdupont.demo.pojo.Category;
import fr.adrienfdupont.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping
    public void create(@RequestBody CreateCategoryDto createCategoryDto) {
        Category category = new Category();
        category.setName(createCategoryDto.getName());
        categoryService.create(category);
    }

    @GetMapping
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findOne(@PathVariable Long id) {
        return categoryService.findOne(id);
    }

    @PutMapping
    public void update (@RequestBody UpdateCategoryDto updateCategoryDto) {
        Category category = categoryService.findOne(updateCategoryDto.getId());
        category.setName(updateCategoryDto.getName());
        categoryService.update(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
