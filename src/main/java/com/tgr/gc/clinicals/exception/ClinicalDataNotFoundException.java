package com.tgr.gc.clinicals.exception;

public class ClinicalDataNotFoundException extends RuntimeException {
    public ClinicalDataNotFoundException(String message) {
        super(message);
    }
}