package com.example.polis_hospital_management.controller;

import com.example.polis_hospital_management.entity.Patient;
import com.example.polis_hospital_management.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Optional<Patient> getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Patient> getPatientsByDepartment(@PathVariable Long departmentId) {
        return patientService.getPatientsByDepartment(departmentId);
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }

    @Override
    public String toString() {
        return "PatientController{" +
                "patientService=" + patientService +
                '}';
    }
}
