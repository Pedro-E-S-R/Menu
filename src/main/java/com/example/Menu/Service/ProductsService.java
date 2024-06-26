package com.example.Menu.Service;

import com.example.Menu.Entity.Category;
import com.example.Menu.Entity.Products;
import com.example.Menu.Exceptions.ResourceNotFoundExeception;
import com.example.Menu.Repository.CategoryRepository;
import com.example.Menu.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class ProductsService {
    @Autowired
    private ProductsRepository repository;
    @Autowired
    private CategoryRepository categoryRepository;

    public Products create(Products product, String categoryName) {

        Optional<Category> categoryOptional = categoryRepository.findByName(categoryName);

        if (categoryOptional.isEmpty()) {
            throw new IllegalArgumentException("Categoria não encontrada: " + categoryName);
        }

        Category category = categoryOptional.get();

        product.setCategory(category);


        return repository.save(product);
    }


    public List<Products> findAll(){
        return repository.findAll();
    }
    public Products findByName(String name){
        Optional<Products> obj = repository.findByName(name);
        return obj.orElseThrow(() -> new ResourceNotFoundExeception(name));
    }
    public void deleteByName(String name){
        repository.deleteByName(name);
    }
    public Products updateProductCategory(String productName, String categoryName) {
        Optional<Products> productOptional = repository.findByName(productName);

        if (productOptional.isEmpty()) {
            throw new IllegalArgumentException("Produto não encontrado: nome " + productName);
        }
        Products product = productOptional.get();
        Optional<Category> categoryOptional = categoryRepository.findByName(categoryName);
        if (categoryOptional.isEmpty()) {
            throw new IllegalArgumentException("Categoria não encontrada: " + categoryName);
        }
        Category newCategory = categoryOptional.get();
        product.setCategory(newCategory);
        return repository.save(product);
    }
    public Products updateProducts(String name, Products product){
        Optional<Products> obj = repository.findByName(name);
        Products entity = obj.get();
        updateData(entity,product);
        return repository.save(entity);
    }

    private void updateData(Products entity, Products product) {
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
    }


}
