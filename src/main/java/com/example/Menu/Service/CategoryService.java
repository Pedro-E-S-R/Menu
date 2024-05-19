package com.example.Menu.Service;

import com.example.Menu.Entity.Category;
import com.example.Menu.Exceptions.ResourceNotFoundExeception;
import com.example.Menu.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }
    public Category findByName(String name){
        Optional<Category> obj = repository.findByName(name);
        return obj.orElseThrow(() -> new ResourceNotFoundExeception(name));
    }
    public void deleteByName(String name){
        repository.deleteByName(name);
    }
    public Category create(Category obj){
        return repository.save(obj);
    }
}
