package com.example.polis_hospital_management.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdmissionDTO {
    private Long id;
    private Long patientId; // ID e pacientit që është pranuar
    private LocalDate admissionDate;
    private Long dischargeId; // ID e lirimit nëse është liruar
}
