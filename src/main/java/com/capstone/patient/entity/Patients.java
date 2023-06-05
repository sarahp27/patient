package com.capstone.patient.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Patients {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private long user_id;
    private Date created; 
    private Date updated; 
    private String guardian_phone_number;

    public Patients(long user_id, Date created, Date updated, String guardian_phone_number){
        this.user_id = user_id;
        this.created = created;
        this.updated = updated;
        this.guardian_phone_number = guardian_phone_number;
    }

}
