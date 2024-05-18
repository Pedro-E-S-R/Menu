package com.example.Menu.Resource;



import com.example.Menu.Entity.Products;
import com.example.Menu.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductsResource {
    @Autowired
    private ProductsService service;

    @GetMapping(value = "/{name}")
    public ResponseEntity<Products> findByName(@PathVariable String name){
        Products obj = service.findByName(name);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping(value = "/")
    public ResponseEntity<List<Products>> findAll(){
        List<Products> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @PostMapping
    public ResponseEntity<Products> insert(@RequestBody Products obj, @RequestParam String categoryName) {
        Products createdProduct = service.create(obj, categoryName);
        return ResponseEntity.ok(createdProduct);
    }
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteByName(@PathVariable String name) {
        service.deleteByName(name);
        return ResponseEntity.ok().build();
    }
}
