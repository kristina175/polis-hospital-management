package com.example.polis_hospital_management.controller;

import com.example.polis_hospital_management.entity.Discharge;
import com.example.polis_hospital_management.service.DischargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/discharges")
public class DischargeController {

    @Autowired
    private DischargeService dischargeService;

    @GetMapping
    public List<Discharge> getAllDischarges() {
        return dischargeService.getAllDischarges();
    }

    @GetMapping("/{id}")
    public Optional<Discharge> getDischargeById(@PathVariable Long id) {
        return dischargeService.getDischargeById(id);
    }

    @PostMapping
    public Discharge createDischarge(@RequestBody Discharge discharge) {
        return dischargeService.saveDischarge(discharge);
    }

    @DeleteMapping("/{id}")
    public void deleteDischarge(@PathVariable Long id) {
        dischargeService.deleteDischarge(id);
    }

    @Override
    public String toString() {
        return "DischargeController{" +
                "dischargeService=" + dischargeService +
                '}';
    }
}
