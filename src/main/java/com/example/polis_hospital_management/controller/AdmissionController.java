package com.example.polis_hospital_management.controller;

import com.example.polis_hospital_management.entity.Admission;
import com.example.polis_hospital_management.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admissions")
public class AdmissionController {
    @Autowired
    private AdmissionService admissionService;

    @PostMapping("/{patientId}")
    public Admission admitPatient(@PathVariable Long patientId, @RequestBody String reason) {
        return admissionService.admitPatient(patientId, reason);
    }
}

