package com.example.polis_hospital_management.controller;

import com.example.polis_hospital_management.entity.ClinicalData;
import com.example.polis_hospital_management.service.ClinicalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clinical-data")
public class ClinicalDataController {

    @Autowired
    private ClinicalDataService clinicalDataService;

    @GetMapping
    public List<ClinicalData> getAllClinicalData() {
        return clinicalDataService.getAllClinicalData();
    }

    @GetMapping("/{id}")
    public Optional<ClinicalData> getClinicalDataById(@PathVariable Long id) {
        return clinicalDataService.getClinicalDataById(id);
    }

    @GetMapping("/patient/{patientId}")
    public List<ClinicalData> getClinicalDataByPatient(@PathVariable Long patientId) {
        return clinicalDataService.getClinicalDataByPatient(patientId);
    }

    @PostMapping
    public ClinicalData createClinicalData(@RequestBody ClinicalData clinicalData) {
        return clinicalDataService.saveClinicalData(clinicalData);
    }

    @DeleteMapping("/{id}")
    public void deleteClinicalData(@PathVariable Long id) {
        clinicalDataService.deleteClinicalData(id);
    }

    @Override
    public String toString() {
        return "ClinicalDataController{" +
                "clinicalDataService=" + clinicalDataService +
                '}';
    }
}
