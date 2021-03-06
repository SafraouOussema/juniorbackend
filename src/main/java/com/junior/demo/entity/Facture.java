package com.junior.demo.entity;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GenerationType; 
import javax.persistence.GeneratedValue; 
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date ;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
 
    private String numberOfFacture;
 

    @JsonFormat(pattern="yyyy-MM-dd") 
    private Date dateOfFacture;
  
}
