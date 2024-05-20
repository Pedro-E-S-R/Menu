package com.example.Menu.Resource;

import com.example.Menu.Entity.Category;
import com.example.Menu.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categoria")
public class CategoryResource {
    @Autowired
    private CategoryService service;

    @GetMapping(value = "/{name}")
    public ResponseEntity<Category> findByName(@PathVariable String name){
        Category obj = service.findByName(name);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping(value = "/")
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody Category obj){
        service.create(obj);
        return ResponseEntity.ok(obj);
    }
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteByName(@PathVariable String name) {
        service.deleteByName(name);
        return ResponseEntity.noContent().build();
    }
}
