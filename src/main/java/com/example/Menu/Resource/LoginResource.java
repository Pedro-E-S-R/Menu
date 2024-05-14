package com.example.Menu.Resource;

import com.example.Menu.Entity.Login;
import com.example.Menu.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/users")
public class LoginResource {

    @Autowired
    private LoginService service;

    @GetMapping(value = "/{email}")
    public ResponseEntity<Login> findByEmail(@PathVariable String email){
        Login obj = service.findByEmail(email);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<Login> insert(@RequestBody Login obj){
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{uuid}")
                .buildAndExpand(obj.getUuid()).toUri();
        return ResponseEntity.created(uri).body(obj);

    }

}
