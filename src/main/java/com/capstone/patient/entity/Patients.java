package com.capstone.patient.entity;

import java.sql.Date;

import jakarta.persistence.Column;
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
public class Patients {
    
    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO, generator = "Patient_generator")
    // @OneToMany(mappedBy = "Reports")    
    // private long report_id;


    //USER
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private long user_id;
    // private String first_name;
    // private String last_name;
    // private Date birth_date;
    // private String gender;
    // private String cnic;
    // private String address;
    // private String preferred_language;
    // private String occupation;
    private Date created; 
    private Date updated; 
    // @ManyToOne
    // @JoinColumn(name= "report_id")

    //FOR PATIENT ONLY 
    // private String blood_group;
    //  private enum  marital_status{
    //    Single, Married, Divorced, Widow 
       
    // };
    // private String phone_number;
    //private  isActive;  //for checking the approval of patient 
    private String guardian_phone_number;

}
