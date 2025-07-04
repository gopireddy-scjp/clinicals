package com.tgr.gc.clinicals.service;

import com.tgr.gc.clinicals.model.Patient;
import java.util.List;

public interface PatientService {
    Patient savePatient(Patient patient);
    List<Patient> getAllPatients();
    Patient getPatientById(Long id);
    Patient updatePatient(Long id, Patient patient);
    void deletePatient(Long id);
    // implementation of method to save list of patients
    List<Patient> savePatients(List<Patient> patients);
}