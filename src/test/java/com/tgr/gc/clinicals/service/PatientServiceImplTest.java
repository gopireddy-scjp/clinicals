package com.tgr.gc.clinicals.service;

import com.tgr.gc.clinicals.exception.PatientNotFoundException;
import com.tgr.gc.clinicals.model.Patient;
import com.tgr.gc.clinicals.repository.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PatientServiceImplTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientServiceImpl patientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void savePatientShouldSaveSuccessfully() {
        // given
        Patient patient = new Patient();
        patient.setId(1L);
        patient.setFirstName("John");
        patient.setLastName("Doe");

        when(patientRepository.save(patient)).thenReturn(patient);

        // when
        Patient result = patientService.savePatient(patient);

        // then
        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
        verify(patientRepository, times(1)).save(patient);
    }

    @Test
    void getAllPatientsShouldReturnListOfPatients() {
        // given
        Patient patient1 = new Patient();
        patient1.setId(1L);
        patient1.setFirstName("John");
        patient1.setLastName("Doe");

        Patient patient2 = new Patient();
        patient2.setId(2L);
        patient2.setFirstName("Jane");
        patient2.setLastName("Doe");

        when(patientRepository.findAll()).thenReturn(Arrays.asList(patient1, patient2));

        // when
        List<Patient> result = patientService.getAllPatients();

        // then
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(patientRepository, times(1)).findAll();
    }

    @Test
    void getPatientByIdShouldReturnPatientWhenExists() {
        // given
        Patient patient = new Patient();
        patient.setId(1L);
        patient.setFirstName("John");
        patient.setLastName("Doe");

        when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));

        // when
        Patient result = patientService.getPatientById(1L);

        // then
        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
        verify(patientRepository, times(1)).findById(1L);
    }

    @Test
    void getPatientByIdShouldThrowExceptionWhenNotFound() {
        // given
        when(patientRepository.findById(1L)).thenReturn(Optional.empty());

        // when // then
        assertThrows(PatientNotFoundException.class, () -> patientService.getPatientById(1L));
        verify(patientRepository, times(1)).findById(1L);
    }

    @Test
    void updatePatientShouldUpdateSuccessfully() {
        // given
        Patient patient = new Patient();
        patient.setId(1L);
        patient.setFirstName("John");
        patient.setLastName("Doe");

        when(patientRepository.existsById(1L)).thenReturn(true);
        when(patientRepository.save(patient)).thenReturn(patient);

        // when
        Patient result = patientService.updatePatient(1L, patient);

        // then
        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
        verify(patientRepository, times(1)).existsById(1L);
        verify(patientRepository, times(1)).save(patient);
    }

    @Test
    void updatePatientShouldThrowExceptionWhenNotFound() {
        // given
        Patient patient = new Patient();
        patient.setId(1L);

        when(patientRepository.existsById(1L)).thenReturn(false);

        // when // then
        assertThrows(PatientNotFoundException.class, () -> patientService.updatePatient(1L, patient));
        verify(patientRepository, times(1)).existsById(1L);
    }

    @Test
    void deletePatientShouldDeleteSuccessfully() {
        // given
        doNothing().when(patientRepository).deleteById(1L);

        // when
        patientService.deletePatient(1L);

        // then
        verify(patientRepository, times(1)).deleteById(1L);
    }
}