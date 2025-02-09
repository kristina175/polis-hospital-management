package com.example.polis_hospital_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "discharges")
public class Discharge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "admission_id", nullable = false)
    private Admission admission;

    @Column(nullable = false)
    private LocalDate dischargeDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DischargeReason reason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setAdmission(Admission admission) {
        this.admission = admission;
    }
    public Admission getAdmission() {
        return this.admission;
    }
    public DischargeReason getReason() {
        return reason;
    }

    public void setReason(DischargeReason reason) {
        this.reason = reason;
    }


    // Getter dhe Setter për Discharge
    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate admissionDate) {
        this.dischargeDate = admissionDate;
    }

}
