package com.example.Menu.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@Data
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name_category", unique = true)
    @NotBlank
    private String name;
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Products> products = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "user_uuid", nullable = false)
    @NotNull
    private Login user;

    @Builder
    public Category(Long id, String name, Login user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }
}
