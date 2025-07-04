package com.tgr.gc.clinicals.repository;

import com.tgr.gc.clinicals.model.ClinicalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Long> {
}