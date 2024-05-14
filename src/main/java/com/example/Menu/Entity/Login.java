package com.example.Menu.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotNull
    private UUID uuid;
    @Column(name = "name")
    @NotBlank
    private String name;
    @Column(name = "email")
    @NotBlank
    private String email;
    @Column(name = "password")
    @NotBlank
    private String password;


}
