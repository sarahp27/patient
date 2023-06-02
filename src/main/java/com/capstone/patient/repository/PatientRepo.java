package com.capstone.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.patient.entity.Patients;

public interface PatientRepo extends JpaRepository<Patients, Integer> {
    
}
