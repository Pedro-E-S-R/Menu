package com.example.Menu.Service;

import com.example.Menu.Entity.Category;
import com.example.Menu.Exceptions.ResourceNotFoundExeception;
import com.example.Menu.Repository.CategoryRepository;
import com.example.Menu.Repository.ProductsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryService {

    @Autowired
    private CategoryRepository repository;
    @Autowired
    private ProductsRepository productsRepository;

    public List<Category> findAll(){
        return repository.findAll();
    }
    public Category findByName(String name){
        Optional<Category> obj = repository.findByName(name);
        return obj.orElseThrow(() -> new ResourceNotFoundExeception(name));
    }
    @Transactional
    public void deleteByName(String name) {
        Category category = repository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        productsRepository.deleteByCategory(category);

        repository.deleteByName(name);
    }
    public Category create(Category obj){
        return repository.save(obj);
    }
}
