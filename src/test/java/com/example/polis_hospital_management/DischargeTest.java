package com.example.polis_hospital_management;

import static org.junit.jupiter.api.Assertions.*;
import com.example.polis_hospital_management.entity.DischargeReason;
import com.example.polis_hospital_management.entity.Admission;
import com.example.polis_hospital_management.entity.Discharge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDate;

// Klasa që përmban testet për entitetin Discharge
class DischargeTest {

    private Discharge discharge;
    private Admission admissionMock;

    @BeforeEach
    void setUp() {
        // Krijon një mock objekt të Admission
        admissionMock = Mockito.mock(Admission.class);

        // Krijon një objekt të ri Discharge për testim
        discharge = new Discharge();
    }

    // Teston metodat set dhe get të klasës Discharge
    @Test
    void testSetAndGet() {
        discharge.setId(1L);
        discharge.setAdmission(admissionMock);
        discharge.setDischargeDate(LocalDate.now());
        discharge.setReason(DischargeReason.PATIENT_REQUEST);

        assertEquals(1L, discharge.getId());
        assertEquals(admissionMock, discharge.getAdmission());
        assertEquals(LocalDate.now(), discharge.getDischargeDate());
        assertEquals(DischargeReason.PATIENT_REQUEST, discharge.getReason());
    }

    // Teston vendosjen dhe marrjen e arsyeve të discharge
    @Test
    void testDischargeReason() {
        // Vendos arsyen e discharge si MEDICAL
        discharge.setReason(DischargeReason.MEDICAL);

        // Verifikon që arsya është vendosur siç duhet
        assertEquals(DischargeReason.MEDICAL, discharge.getReason());
    }

    // Teston rastin kur discharge nuk ka lidhje me një admission
    @Test
    void testDischargeWithNullAdmission() {
        // Vendos ID-në e discharge
        discharge.setId(2L);
        discharge.setAdmission(null);
        discharge.setDischargeDate(LocalDate.now());
        discharge.setReason(DischargeReason.MEDICAL);

        assertEquals(2L, discharge.getId());
        assertNull(discharge.getAdmission(), "Admission should be null");
        assertEquals(LocalDate.now(), discharge.getDischargeDate());
        assertEquals(DischargeReason.MEDICAL, discharge.getReason());
    }

    // Teston vendosjen dhe marrjen e datës së discharge
    @Test
    void testDischargeDate() {
        // Vendos një datë specifike për discharge
        LocalDate dischargeDate = LocalDate.of(2025, 2, 10);
        discharge.setDischargeDate(dischargeDate);

        // Verifikon që data e discharge është vendosur siç duhet
        assertEquals(dischargeDate, discharge.getDischargeDate());
    }

    // Teston vendosjen e admission në discharge
    @Test
    void testSetAdmission() {
        Admission admission = new Admission();
        admission.setId(1L);
        discharge.setAdmission(admission);

        assertEquals(admission, discharge.getAdmission());
    }

    // Teston vendosjen e arsyeve të discharge
    @Test
    void testReasonSetter() {
        // Vendos arsyen e discharge si PATIENT_REQUEST
        discharge.setReason(DischargeReason.PATIENT_REQUEST);

        // Verifikon që arsya është vendosur siç duhet
        assertEquals(DischargeReason.PATIENT_REQUEST, discharge.getReason());
    }
}