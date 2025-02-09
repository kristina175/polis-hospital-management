package com.example.polis_hospital_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
public class Patient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Admission> admissions;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClinicalData> clinicalData;

    // Getter për 'id'
    public Long getId() {
        return id;
    }

    // Setter për 'id'
    public void setId(Long id) {
        this.id = id;
    }

    // Getter për 'name'
    public String getName() {
        return name;
    }

    // Setter për 'name'
    public void setName(String name) {
        this.name = name;
    }

    // Getter për 'surname'
    public String getSurname() {
        return surname;
    }

    // Setter për 'surname'
    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Getter dhe Setter për 'department'
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
