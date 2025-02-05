package com.example.polis_hospital_management.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private Long id;
    private String name;
    private String surname;
    private Long departmentId; // ID e departamentit ku ndodhet pacienti
}
