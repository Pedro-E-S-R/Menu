package com.example.Menu.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "menu")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @OneToOne
    @JoinColumn(name = "categoria_uuid", nullable = false)
    @NotNull
    @JsonIgnore
    private Category categoria;
    @Column(name = "name")
    @NotBlank
    private String name;
    @Column(name = "price")
    @NotBlank
    private BigDecimal price;
    @Column(name = "amount")
    @NotBlank
    private Long amount;
}
