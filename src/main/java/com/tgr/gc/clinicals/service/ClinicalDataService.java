package com.tgr.gc.clinicals.service;

import com.tgr.gc.clinicals.model.ClinicalData;
import java.util.List;

public interface ClinicalDataService {
    ClinicalData saveClinicalData(ClinicalData clinicalData);
    List<ClinicalData> getAllClinicalData();
    ClinicalData getClinicalDataById(Long id);
    ClinicalData updateClinicalData(Long id, ClinicalData clinicalData);
    void deleteClinicalData(Long id);
}