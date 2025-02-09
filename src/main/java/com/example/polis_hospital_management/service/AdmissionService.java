package com.example.polis_hospital_management.service;

import com.example.polis_hospital_management.entity.Admission;
import com.example.polis_hospital_management.repository.AdmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdmissionService {

    @Autowired
    private AdmissionRepository admissionRepository;

    public List<Admission> getAllAdmissions() {
        return admissionRepository.findAll();
    }

    public Optional<Admission> getAdmissionById(Long id) {
        return admissionRepository.findById(id);
    }

    public List<Admission> getAdmissionsByPatient(Long patientId) {
        return admissionRepository.findByPatient_Id(patientId);
    }

    public Admission saveAdmission(Admission admission) {
        return admissionRepository.save(admission);
    }

    public void deleteAdmission(Long id) {
        admissionRepository.deleteById(id);
    }

    public Admission admitPatient(Long patientId, String reason) {
        return null;
    }

}