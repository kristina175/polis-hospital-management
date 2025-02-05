package com.example.polis_hospital_management.repository;

import com.example.polis_hospital_management.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

