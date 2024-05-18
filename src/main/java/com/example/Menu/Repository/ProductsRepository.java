package com.example.Menu.Repository;

import com.example.Menu.Entity.Category;
import com.example.Menu.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Long> {

    Optional<Products> findByName(String name);
    void deleteByName(String name);
}
