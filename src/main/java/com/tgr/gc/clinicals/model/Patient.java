package com.tgr.gc.clinicals.model;

import jakarta.persistence.*;


import java.util.List;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private int age;
    // establishing a one-to-many relationship with ClinicalData
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     private List<ClinicalData> clinicalDataList;

    // Getters and Setters for clinicalDataList
    public List<ClinicalData> getClinicalDataList() {
        return clinicalDataList;
    }
    public void setClinicalDataList(List<ClinicalData> clinicalDataList) {
        this.clinicalDataList = clinicalDataList;
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}