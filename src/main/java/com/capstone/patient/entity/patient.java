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
public class patient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    //USER
    private String first_name;
    private String last_name;
    private Date birth_date;
    private String gender;
    private String cnic;
    private String city;
    private String country;
    private String preferred_language;
    private String occupation;
    private String created_on; 
    private String updated_on; 


    //FOR PATIENT ONLY 
    private String blood_group;
    private String marital_status;
    private String phone_number;
    private String isActive;  //for checking the approval of patient 
    private String guardian_pshone_number;

}
