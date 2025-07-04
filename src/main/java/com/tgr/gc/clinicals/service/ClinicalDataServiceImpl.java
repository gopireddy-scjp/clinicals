package com.tgr.gc.clinicals.service;

import com.tgr.gc.clinicals.exception.ClinicalDataNotFoundException;
import com.tgr.gc.clinicals.model.ClinicalData;
import com.tgr.gc.clinicals.repository.ClinicalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicalDataServiceImpl implements ClinicalDataService {

    private final ClinicalDataRepository clinicalDataRepository;

    @Autowired
    public ClinicalDataServiceImpl(ClinicalDataRepository clinicalDataRepository) {
        this.clinicalDataRepository = clinicalDataRepository;
    }

    @Override
    public ClinicalData saveClinicalData(ClinicalData clinicalData) {
        return clinicalDataRepository.save(clinicalData);
    }

    @Override
    public List<ClinicalData> getAllClinicalData() {
        return clinicalDataRepository.findAll();
    }

    @Override
    public ClinicalData getClinicalDataById(Long id) {
        return clinicalDataRepository.findById(id)
                .orElseThrow(() -> new ClinicalDataNotFoundException("Clinical data not found with id: " + id));
    }

    @Override
    public ClinicalData updateClinicalData(Long id, ClinicalData clinicalData) {
        if (!clinicalDataRepository.existsById(id)) {
            throw new ClinicalDataNotFoundException("Clinical data not found with id: " + id);
        }
        clinicalData.setId(id);
        return clinicalDataRepository.save(clinicalData);
    }

    @Override
    public void deleteClinicalData(Long id) {
        clinicalDataRepository.deleteById(id);
    }
}