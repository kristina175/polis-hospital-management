package com.example.polis_hospital_management.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClinicalDataDTO {
    private Long id;
    private Long patientId; // ID e pacientit që ka të dhëna klinike
    private LocalDateTime entryTime;
    private String notes; // Përshkrimi klinik

//    @Override
//    public String toString() {
//        return "ClinicalDataDTO{" +
//                "id=" + id +
//                ", patientId=" + patientId +
//                ", entryTime=" + entryTime +
//                ", notes='" + notes + '\'' +
//                '}';
//    }
}

