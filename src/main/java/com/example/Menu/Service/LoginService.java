package com.example.Menu.Service;

import com.example.Menu.Entity.Login;
import com.example.Menu.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginService {

    @Autowired
    private LoginRepository repository;

    public Login findByEmail(String email){
        Optional<Login> obj = repository.findByEmail(email);
        return obj.orElse(null);
    }
    public Login create(Login obj){
        return repository.save(obj);
    }
}
