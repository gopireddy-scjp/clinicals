package com.tgr.gc.clinicals.service;

import com.tgr.gc.clinicals.exception.ClinicalDataNotFoundException;
import com.tgr.gc.clinicals.model.ClinicalData;
import com.tgr.gc.clinicals.repository.ClinicalDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClinicalDataServiceImplTest {

    @Mock
    private ClinicalDataRepository clinicalDataRepository;

    @InjectMocks
    private ClinicalDataServiceImpl clinicalDataService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveClinicalDataSavesSuccessfully() {
        ClinicalData clinicalData = new ClinicalData();
        clinicalData.setId(1L);
        clinicalData.setComponentName("Blood Pressure");
        clinicalData.setComponentValue("120/80");

        when(clinicalDataRepository.save(clinicalData)).thenReturn(clinicalData);

        ClinicalData result = clinicalDataService.saveClinicalData(clinicalData);

        assertNotNull(result);
        assertEquals("Blood Pressure", result.getComponentName());
        verify(clinicalDataRepository, times(1)).save(clinicalData);
    }

    @Test
    void getClinicalDataByIdReturnsDataWhenExists() {
        ClinicalData clinicalData = new ClinicalData();
        clinicalData.setId(1L);
        clinicalData.setComponentName("Blood Pressure");
        clinicalData.setComponentValue("120/80");

        when(clinicalDataRepository.findById(1L)).thenReturn(Optional.of(clinicalData));

        ClinicalData result = clinicalDataService.getClinicalDataById(1L);

        assertNotNull(result);
        assertEquals("Blood Pressure", result.getComponentName());
        verify(clinicalDataRepository, times(1)).findById(1L);
    }

    @Test
    void getClinicalDataByIdThrowsExceptionWhenNotFound() {
        when(clinicalDataRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(ClinicalDataNotFoundException.class, () -> clinicalDataService.getClinicalDataById(1L));
        verify(clinicalDataRepository, times(1)).findById(1L);
    }

    @Test
    void updateClinicalDataUpdatesSuccessfully() {
        ClinicalData existingClinicalData = new ClinicalData();
        existingClinicalData.setId(1L);
        existingClinicalData.setComponentName("Blood Pressure");
        existingClinicalData.setComponentValue("120/80");

        ClinicalData updatedClinicalData = new ClinicalData();
        updatedClinicalData.setId(1L);
        updatedClinicalData.setComponentName("Heart Rate");
        updatedClinicalData.setComponentValue("75 bpm");

        when(clinicalDataRepository.findById(1L)).thenReturn(Optional.of(existingClinicalData));
        when(clinicalDataRepository.save(updatedClinicalData)).thenReturn(updatedClinicalData);

        ClinicalData result = clinicalDataService.updateClinicalData(1L, updatedClinicalData);

        assertNotNull(result);
        assertEquals("Heart Rate", result.getComponentName());
        verify(clinicalDataRepository, times(1)).findById(1L);
        verify(clinicalDataRepository, times(1)).save(updatedClinicalData);
    }



}