package com.tgr.gc.clinicals.controller;

import com.tgr.gc.clinicals.dto.ClinicalDataDTO;
import com.tgr.gc.clinicals.model.ClinicalData;
import com.tgr.gc.clinicals.model.Patient;
import com.tgr.gc.clinicals.service.ClinicalDataService;
import com.tgr.gc.clinicals.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinical")
public class ClinicalDataController {

    private final ClinicalDataService clinicalDataService;
    private final PatientService patientService;


    @Autowired
    public ClinicalDataController(ClinicalDataService clinicalDataService, PatientService patientService) {
        this.clinicalDataService = clinicalDataService;
        this.patientService = patientService;
    }

  @PostMapping
  public ResponseEntity<ClinicalData> createClinicalData(@RequestBody ClinicalDataDTO clinicalDataDTO) {
        ClinicalData clinicalData = new ClinicalData();
        clinicalData.setComponentName(clinicalDataDTO.getComponentName());
        clinicalData.setComponentValue(clinicalDataDTO.getComponentValue());

        // Assuming patientService is used to fetch the patient by ID
        Patient patient = patientService.getPatientById(clinicalDataDTO.getPatientId());
        if (patient == null) {
            return ResponseEntity.notFound().build();
        }

        clinicalData.setPatient(patient);
        ClinicalData savedClinicalData = clinicalDataService.saveClinicalData(clinicalData);

        return ResponseEntity.status(201).body(savedClinicalData);
  }


    @GetMapping
    public ResponseEntity<List<ClinicalData>> getAllClinicalData() {
        List<ClinicalData> clinicalDataList = clinicalDataService.getAllClinicalData();
        return ResponseEntity.ok(clinicalDataList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicalData> getClinicalDataById(@PathVariable Long id) {
        ClinicalData clinicalData = clinicalDataService.getClinicalDataById(id);
        return ResponseEntity.ok(clinicalData);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClinicalData> updateClinicalData(@PathVariable Long id, @RequestBody ClinicalData clinicalData) {
        ClinicalData updatedClinicalData = clinicalDataService.updateClinicalData(id, clinicalData);
        return ResponseEntity.ok(updatedClinicalData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClinicalData(@PathVariable Long id) {
        clinicalDataService.deleteClinicalData(id);
        return ResponseEntity.noContent().build();
    }
}