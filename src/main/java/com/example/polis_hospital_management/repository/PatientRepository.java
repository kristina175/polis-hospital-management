package com.example.polis_hospital_management.repository;

import com.example.polis_hospital_management.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByDepartmentId(Long departmentId);
}


