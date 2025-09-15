package com.ecom.catalogproduct.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  name;
    private String  description;
    private String  imageUrl;
    private Double  price;
    @ManyToOne
    @JoinColumn(name="category_id",nullable = false)
    @JsonIgnoreProperties("products")
    private Category category;
}
