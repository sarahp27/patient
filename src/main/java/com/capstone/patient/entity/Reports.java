package com.capstone.patient.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter

public class Reports{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @ManyToOne
    @JoinColumn(name= "report_id")
    private Patients patient;

    private enum category {
    Antisocial,
    Avoidant,
    Borderline,
    Dependent,
    Histrionic,
    Narcissistic,
    Obsessive_compulsive,
    Paranoid}; 

    private String survey_form_link;



}
