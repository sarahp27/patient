package com.capstone.patient.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.patient.entity.Patients;
import com.capstone.patient.repository.PatientRepo;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private PatientRepo repo;

    PatientController(PatientRepo repo) {
        this.repo = repo;
    }

    @PostMapping("/add")
    private ResponseEntity addPatient(@RequestBody Patients data) {
        Patients patient = repo.save(data);
        return ResponseEntity.ok().body(patient);

    }

    @PostMapping("/update")
    private ResponseEntity updatePatient(@RequestBody Patients data) {
        return ResponseEntity.ok().body(repo.save(data));
    }

    @GetMapping("/list")
    private ResponseEntity getpatient(@RequestParam Integer id) {
        if (id != 0) {
            Patients patient = repo.findById(id).orElse(null);
            if(patient == null){
                return ResponseEntity.ok().body("Patient not found");
            }
            return ResponseEntity.ok().body(patient);
        }


        List list = new ArrayList<Patients>();
            list = repo.findAll();
            if (list.size() == 0) {
                return ResponseEntity.ok("Patients not found");
            }
            System.out.println("adfsd");
            return ResponseEntity.ok().body(list);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity deletePatient(@PathVariable Integer id) {
        Patients patient = repo.findById(id).orElse(null);
        if(patient == null){
        return ResponseEntity.ok("Patient not found");
        }
        repo.deleteById(id);
        return ResponseEntity.ok("Patient has been deleted");
    }

}
