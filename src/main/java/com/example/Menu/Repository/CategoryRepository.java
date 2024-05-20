package com.example.Menu.Repository;

import com.example.Menu.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);


    @Modifying
    @Transactional
    @Query("DELETE FROM Category c WHERE c.name = :name")
    void deleteByName(@Param("name") String name);
}
