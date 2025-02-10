package com.example.polis_hospital_management;

import com.example.polis_hospital_management.entity.Department;
import com.example.polis_hospital_management.entity.Patient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @Test
    void testPatientCreation() {
        // Krijo një objekt Department për të lidhur me pacientin
        Department department = new Department();
        department.setId(1L);
        department.setName("Kardiologji");

        // Krijo një objekt Patient dhe vendos vlerat me setter
        Patient patient = new Patient();
        patient.setId(1L);
        patient.setName("John");
        patient.setSurname("Doe");
        patient.setDepartment(department);

        // Verifiko që vlerat janë vendosur saktë
        assertEquals(1L, patient.getId());
        assertEquals("John", patient.getName());
        assertEquals("Doe", patient.getSurname());
        assertEquals(department, patient.getDepartment());
    }

    @Test
    void testSetNameAndSurname() {
        Patient patient = new Patient();
        patient.setName("Alice");
        patient.setSurname("Smith");

        assertEquals("Alice", patient.getName());
        assertEquals("Smith", patient.getSurname());
    }

    @Test
    void testDepartmentAssignment() {
        Department department = new Department();
        department.setId(2L);
        department.setName("Neurologji");

        Patient patient = new Patient();
        patient.setId(2L);
        patient.setName("Bob");
        patient.setSurname("Jones");
        patient.setDepartment(department);

        assertEquals("Neurologji", patient.getDepartment().getName());
        assertEquals(2L, patient.getDepartment().getId());
    }

    @Test
    void testPatientWithNullDepartment() {
        Patient patient = new Patient();
        patient.setId(3L);
        patient.setName("Charlie");
        patient.setSurname("Brown");
        patient.setDepartment(null);

        assertNull(patient.getDepartment());
    }

    @Test
    void testPatientNotEquals() {
        Department department = new Department();
        department.setId(1L);
        department.setName("Onkologji");

        Patient patient1 = new Patient();
        patient1.setId(1L);
        patient1.setName("Daniel");
        patient1.setSurname("Green");
        patient1.setDepartment(department);

        Patient patient2 = new Patient();
        patient2.setId(2L);
        patient2.setName("Daniel");
        patient2.setSurname("Green");
        patient2.setDepartment(department);

        assertNotEquals(patient1, patient2);  // Different IDs should make them not equal
    }
}
