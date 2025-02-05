package com.example.polis_hospital_management.service;

import com.example.polis_hospital_management.entity.ClinicalData;
import com.example.polis_hospital_management.repository.ClinicalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicalDataService {

    @Autowired
    private ClinicalDataRepository clinicalDataRepository;

    public List<ClinicalData> getAllClinicalData() {
        return clinicalDataRepository.findAll();
    }

    public Optional<ClinicalData> getClinicalDataById(Long id) {
        return clinicalDataRepository.findById(id);
    }

    public List<ClinicalData> getClinicalDataByPatient(Long patientId) {
        return clinicalDataRepository.findByPatientId(patientId);
    }

    public ClinicalData saveClinicalData(ClinicalData clinicalData) {
        return clinicalDataRepository.save(clinicalData);
    }

    public void deleteClinicalData(Long id) {
        clinicalDataRepository.deleteById(id);
    }
}
