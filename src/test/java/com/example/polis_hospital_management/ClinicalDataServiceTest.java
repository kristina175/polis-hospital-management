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

    // Krijo një mock objekt të ClinicalDataRepository
    @Mock
    private ClinicalDataRepository clinicalDataRepository;

    // Injekto mock-imet në shërbimin që do të testohet
    @InjectMocks
    private ClinicalDataService clinicalDataService;

    // Variabël për të ruajtur të dhëna klinike testuese
    private ClinicalData clinicalData;

    // Metodë që ekzekutohet para çdo testi për të inicializuar variablat dhe mock-imet
    @BeforeEach
    public void setUp() {
        // Hap mock-imet për këtë klasë
        MockitoAnnotations.openMocks(this);
        // Krijo një objekt ClinicalData për testim
        clinicalData = new ClinicalData();
        clinicalData.setId(1L); // Vendos ID-në e të dhënave klinike
        clinicalData.setPatientId(123L); // Vendos ID-në e pacientit
        clinicalData.setEntryTime(java.time.LocalDateTime.now()); // Vendos kohën e hyrjes
        clinicalData.setNotes("Some clinical notes"); // Vendos shënimet klinike
    }

    // Teston metodën getAllClinicalData të shërbimit
    @Test
    public void testGetAllClinicalData() {
        // Krijo një listë të të dhënave klinike
        List<ClinicalData> clinicalDataList = new ArrayList<>();
        clinicalDataList.add(clinicalData);

        // Konfiguro mock-un për të kthyer listën e të dhënave kur thirret findAll()
        when(clinicalDataRepository.findAll()).thenReturn(clinicalDataList);

        // Thirr metodën që do të testohet
        List<ClinicalData> result = clinicalDataService.getAllClinicalData();
        assertNotNull(result);
        // Verifikoj që lista ka një element
        assertEquals(1, result.size());
        // Verifikoj që ID-ja e të dhënave klinike është e saktë
        assertEquals(clinicalData.getId(), result.get(0).getId());
    }

    // Teston metodën getClinicalDataById të shërbimit
    @Test
    public void testGetClinicalDataById() {
        // Konfiguro mock-un për të kthyer të dhënat klinike kur thirret findById() me ID-në 1
        when(clinicalDataRepository.findById(1L)).thenReturn(Optional.of(clinicalData));

        // Thirr metodën që do të testohet
        Optional<ClinicalData> result = clinicalDataService.getClinicalDataById(1L);
        assertTrue(result.isPresent());
        // Verifikoj që ID-ja e të dhënave klinike është e saktë
        assertEquals(clinicalData.getId(), result.get().getId());
    }

    // Teston metodën getClinicalDataByPatient të shërbimit
    @Test
    public void testGetClinicalDataByPatient() {
        // Krijo një listë të të dhënave klinike
        List<ClinicalData> clinicalDataList = new ArrayList<>();
        clinicalDataList.add(clinicalData);

        // Konfiguro mock-un për të kthyer listën e të dhënave kur thirret findByPatientId() me ID-në 123
        when(clinicalDataRepository.findByPatientId(123L)).thenReturn(clinicalDataList);

        // Thirr metodën që do të testohet
        List<ClinicalData> result = clinicalDataService.getClinicalDataByPatient(123L);
        assertNotNull(result);
        // Verifikoj që lista ka një element
        assertEquals(1, result.size());
        // Verifikoj që ID-ja e pacientit është e saktë
        assertEquals(clinicalData.getPatientId(), result.get(0).getPatientId());
    }

    // Teston metodën saveClinicalData të shërbimit
    @Test
    public void testSaveClinicalData() {
        // Konfiguro mock-un për të kthyer të dhënat klinike kur thirret save()
        when(clinicalDataRepository.save(clinicalData)).thenReturn(clinicalData);

        // Thirr metodën që do të testohet
        ClinicalData result = clinicalDataService.saveClinicalData(clinicalData);

        // Verifikoj që rezultati nuk është null
        assertNotNull(result);
        assertEquals(clinicalData.getId(), result.getId());
    }

    // Teston metodën deleteClinicalData të shërbimit
    @Test
    public void testDeleteClinicalData() {
        // Konfiguro mock-un për të mos bërë asgjë kur thirret deleteById() me ID-në 1
        doNothing().when(clinicalDataRepository).deleteById(1L);

        // Thirr metodën që do të testohet
        clinicalDataService.deleteClinicalData(1L);

        // Verifikoj që deleteById() është thirrur saktësisht një herë me ID-në 1
        verify(clinicalDataRepository, times(1)).deleteById(1L);
    }

    // Override metodën toString për të dhënë një paraqitje të lexueshme të objektit
//    @Override
//    public String toString() {
//        return "ClinicalDataServiceTest{" +
//                "clinicalDataRepository=" + clinicalDataRepository +
//                ", clinicalDataService=" + clinicalDataService +
//                ", clinicalData=" + clinicalData +
//                '}';
//    }
}