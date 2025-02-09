package com.example.polis_hospital_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    public void setPatientId(long l) {
    }

    public void setNotes(String admittedWithFever) {
    }
    // Getter dhe Setter për id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    // Getter dhe Setter për patientId
//    public Long getPatientId() {
//        return patientId;
//    }
//
//    public void setPatientId(Long patientId) {
//        this.patientId = patientId;
//    }

    // Getter dhe Setter për admissionDate
    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

}
