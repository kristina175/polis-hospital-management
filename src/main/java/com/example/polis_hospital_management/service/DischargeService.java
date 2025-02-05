package com.example.polis_hospital_management.service;

import com.example.polis_hospital_management.entity.Discharge;
import com.example.polis_hospital_management.repository.DischargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DischargeService {

    @Autowired
    private DischargeRepository dischargeRepository;

    public List<Discharge> getAllDischarges() {
        return dischargeRepository.findAll();
    }

    public Optional<Discharge> getDischargeById(Long id) {
        return dischargeRepository.findById(id);
    }

    public Discharge saveDischarge(Discharge discharge) {
        return dischargeRepository.save(discharge);
    }

    public void deleteDischarge(Long id) {
        dischargeRepository.deleteById(id);
    }
}
