package com.example.polis_hospital_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    // Getter manual nëse nuk po funksionon
    @Getter
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Patient> patients;

    public void setId(Long id) {
        this.id = id;
    }
    // Setter për 'name'
    public void setName(String name) {
        this.name = name;
    }
    // Getter për 'id'
    public Long getId() {
        return id;
    }
    // Getter për 'name'
    public String getName() {
        return name;
    }
}

