package com.example.polis_hospital_management;
import com.example.polis_hospital_management.controller.PatientController;
import com.example.polis_hospital_management.entity.Patient;
import com.example.polis_hospital_management.service.PatientService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PatientControllerTest {

    @Mock
    private PatientService patientService;

    @InjectMocks
    private PatientController patientController;

    public PatientControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllPatients() {
        Patient patient = new Patient();
        patient.setId(1L);
        patient.setName("John");
        patient.setSurname("Doe");

        when(patientService.getAllPatients()).thenReturn(Collections.singletonList(patient));

        List<Patient> result = patientController.getAllPatients();
        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getName());
        assertEquals("Doe", result.get(0).getSurname());
    }

    @Override
    public String toString() {
        return "PatientControllerTest{" +
                "patientService=" + patientService +
                ", patientController=" + patientController +
                '}';
    }
}
