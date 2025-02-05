package com.example.polis_hospital_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admissions")
public class Admission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;


    @Column(nullable = false)
    private LocalDate admissionDate;

    @OneToOne(mappedBy = "admission", cascade = CascadeType.ALL, orphanRemoval = true)
    private Discharge discharge;
}
