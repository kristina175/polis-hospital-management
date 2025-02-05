package com.example.polis_hospital_management.repository;

import com.example.polis_hospital_management.entity.ClinicalData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Long> {
    List<ClinicalData> findByPatientId(Long patientId);
}
