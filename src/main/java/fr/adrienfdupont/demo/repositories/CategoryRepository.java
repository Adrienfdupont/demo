package fr.adrienfdupont.demo.repositories;

import fr.adrienfdupont.demo.POJO.Category;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
