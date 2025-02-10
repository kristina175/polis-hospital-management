package com.example.polis_hospital_management;
import static org.junit.jupiter.api.Assertions.*;
import com.example.polis_hospital_management.entity.DischargeReason;
import com.example.polis_hospital_management.entity.Admission;
import com.example.polis_hospital_management.entity.Discharge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

class DischargeTest {

    private Discharge discharge;
    private Admission admissionMock;

    @BeforeEach
    void setUp() {
        // Krijimi i një mock të Admission
        admissionMock = Mockito.mock(Admission.class);

        // Krijimi i objektit të Discharge
        discharge = new Discharge();
    }

    @Test
    void testSetAndGet() {
        // Vendosja e të dhënave
        discharge.setId(1L);
        discharge.setAdmission(admissionMock);
        discharge.setDischargeDate(LocalDate.now());
        discharge.setReason(DischargeReason.PATIENT_REQUEST);  // Shembull për një arsye

        // Verifikimi i të dhënave
        assertEquals(1L, discharge.getId());
        assertEquals(admissionMock, discharge.getAdmission());
        assertEquals(LocalDate.now(), discharge.getDischargeDate());
        assertEquals(DischargeReason.PATIENT_REQUEST, discharge.getReason());
    }

    @Test
    void testDischargeReason() {
        // Vendosja e një arsye për discharge
        discharge.setReason(DischargeReason.MEDICAL);

        // Verifikimi i arsyeve të discharge
        assertEquals(DischargeReason.MEDICAL, discharge.getReason());
    }
    @Test
    void testDischargeWithNullAdmission() {
        // Krijimi i një discharge pa lidhje me një admission
        discharge.setId(2L);
        discharge.setAdmission(null);
        discharge.setDischargeDate(LocalDate.now());
        discharge.setReason(DischargeReason.MEDICAL);

        // Verifikimi që discharge është ruajtur edhe pa një admission
        assertEquals(2L, discharge.getId());
        assertNull(discharge.getAdmission(), "Admission should be null");
        assertEquals(LocalDate.now(), discharge.getDischargeDate());
        assertEquals(DischargeReason.MEDICAL, discharge.getReason());
    }

    @Test
    void testDischargeDate() {
        // Testimi me datë të ndryshme
        LocalDate dischargeDate = LocalDate.of(2025, 2, 10);
        discharge.setDischargeDate(dischargeDate);

        // Verifikimi që data e discharge është e saktë
        assertEquals(dischargeDate, discharge.getDischargeDate());
    }

    @Test
    void testSetAdmission() {
        // Testimi i vendosjes së admission në discharge
        Admission admission = new Admission();
        admission.setId(1L);
        discharge.setAdmission(admission);

        // Verifikimi që admission është setuar siç duhet
        assertEquals(admission, discharge.getAdmission());
    }

    @Test
    void testReasonSetter() {
        // Vendosja e arsyeve të discharge
        discharge.setReason(DischargeReason.PATIENT_REQUEST);

        // Verifikimi i arsyeve
        assertEquals(DischargeReason.PATIENT_REQUEST, discharge.getReason());
    }

}

