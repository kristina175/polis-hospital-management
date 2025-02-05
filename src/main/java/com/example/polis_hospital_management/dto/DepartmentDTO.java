package com.example.polis_hospital_management.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Long id;
    private String name;
    private List<Long> patientIds; // Lista e ID-ve të pacientëve për këtë departament
}
