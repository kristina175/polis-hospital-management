package com.example.polis_hospital_management.dto;

import com.example.polis_hospital_management.entity.DischargeReason;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DischargeDTO {
    private Long id;
    private Long admissionId; // ID e pranimit që është liruar
    private LocalDate dischargeDate;
    private DischargeReason reason; // Arsyeja e lirimit
}
