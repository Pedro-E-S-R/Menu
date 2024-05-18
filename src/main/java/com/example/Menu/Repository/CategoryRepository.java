package com.example.Menu.Repository;

import com.example.Menu.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);


    void deleteByName(String name);
}
