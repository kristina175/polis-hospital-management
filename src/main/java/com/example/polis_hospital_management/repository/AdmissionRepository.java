package com.example.polis_hospital_management.repository;

import com.example.polis_hospital_management.entity.Admission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdmissionRepository extends JpaRepository<Admission, Long> {
    List<Admission> findByPatient_Id(Long patientId); // Kjo duhet të jetë metoda e saktë
}
