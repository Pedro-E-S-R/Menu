package com.example.Menu.confgTest;

import com.example.Menu.Entity.Category;
import com.example.Menu.Entity.Login;
import com.example.Menu.Repository.CategoryRepository;
import com.example.Menu.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        Login user = new Login(null,"pedro","teste@teste","senha");
        loginRepository.save(user);
        Category c1 = new Category(null,"pizza",user);
        Category c2 = new Category(null,"doces",user);
        categoryRepository.saveAll(Arrays.asList(c1,c2));

    }
}
