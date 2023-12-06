package fr.adrienfdupont.demo.services;

import fr.adrienfdupont.demo.pojo.Category;
import fr.adrienfdupont.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void create(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findOne(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void update(Category newCategory) {
        Category category = this.findOne(newCategory.getId());

        if (category != null) {
            category.setName(newCategory.getName());
            categoryRepository.save(category);
        }
    }

    public void delete(Long id) {
        Category category = this.findOne(id);
        categoryRepository.delete(category);
    }
}
