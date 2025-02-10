package com.example.polis_hospital_management;

import com.example.polis_hospital_management.entity.ClinicalData;
import com.example.polis_hospital_management.repository.ClinicalDataRepository;
import com.example.polis_hospital_management.service.ClinicalDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClinicalDataServiceTest {

    @Mock
    private ClinicalDataRepository clinicalDataRepository;

    @InjectMocks
    private ClinicalDataService clinicalDataService;

    private ClinicalData clinicalData;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Hap mock-imet para çdo testi
        clinicalData = new ClinicalData();
        clinicalData.setId(1L);
        clinicalData.setPatientId(123L);
        clinicalData.setEntryTime(java.time.LocalDateTime.now());
        clinicalData.setNotes("Some clinical notes");
    }

    @Test
    public void testGetAllClinicalData() {
        List<ClinicalData> clinicalDataList = new ArrayList<>();
        clinicalDataList.add(clinicalData);

        when(clinicalDataRepository.findAll()).thenReturn(clinicalDataList);

        List<ClinicalData> result = clinicalDataService.getAllClinicalData();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(clinicalData.getId(), result.get(0).getId());
    }

    @Test
    public void testGetClinicalDataById() {
        when(clinicalDataRepository.findById(1L)).thenReturn(Optional.of(clinicalData));

        Optional<ClinicalData> result = clinicalDataService.getClinicalDataById(1L);

        assertTrue(result.isPresent());
        assertEquals(clinicalData.getId(), result.get().getId());
    }

    @Test
    public void testGetClinicalDataByPatient() {
        List<ClinicalData> clinicalDataList = new ArrayList<>();
        clinicalDataList.add(clinicalData);

        when(clinicalDataRepository.findByPatientId(123L)).thenReturn(clinicalDataList);

        List<ClinicalData> result = clinicalDataService.getClinicalDataByPatient(123L);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(clinicalData.getPatientId(), result.get(0).getPatientId());
    }

    @Test
    public void testSaveClinicalData() {
        when(clinicalDataRepository.save(clinicalData)).thenReturn(clinicalData);

        ClinicalData result = clinicalDataService.saveClinicalData(clinicalData);

        assertNotNull(result);
        assertEquals(clinicalData.getId(), result.getId());
    }

    @Test
    public void testDeleteClinicalData() {
        doNothing().when(clinicalDataRepository).deleteById(1L);

        clinicalDataService.deleteClinicalData(1L);

        verify(clinicalDataRepository, times(1)).deleteById(1L);
    }
}
