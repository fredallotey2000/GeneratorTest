/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.generatortest.generatortest.data;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Bsystems4
 */
@Entity
@Table(name = "plants")
public class Plant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sequence_number")
    private long sequenceNumber;
    
    @Column(name = "year")
    private String year;
    
    @Column(name = "plant_location_code")
    private String plantLocationCode;
    
    @Column(name = "plant_name")
    private String plantName;
    
    @Column(name = "generator_id")
    private String generatorId;
    
    @Column(name = "generator_status")
    private String generatorStatus;
    
    @Column(name = "generator_annual_net_generation")
    private BigDecimal  generatorAnnualNetGeneration;
    
    @Transient
    private String percentageGenerationPerLocation;

    public long getSequenceNumber() {
        return sequenceNumber;
    }

    public String getPercentageGenerationPerLocation() {
        return percentageGenerationPerLocation;
    }

    public void setPercentageGenerationPerLocation(String percentageGenerationPerLocation) {
        this.percentageGenerationPerLocation = percentageGenerationPerLocation;
    }

  

    public void setSequenceNumber(long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPlantLocationCode() {
        return plantLocationCode;
    }

    public void setPlantLocationCode(String plantLocationCode) {
        this.plantLocationCode = plantLocationCode;
        
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getGeneratorId() {
        return generatorId;
    }

    public void setGeneratorId(String generatorId) {
        this.generatorId = generatorId;
    }

    public String getGeneratorStatus() {
        return generatorStatus;
    }

    public void setGeneratorStatus(String generatorStatus) {
        this.generatorStatus = generatorStatus;
    }

    public BigDecimal getGeneratorAnnualNetGeneration() {
        return generatorAnnualNetGeneration;
    }

    public void setGeneratorAnnualNetGeneration(BigDecimal generatorAnnualNetGeneration) {
        this.generatorAnnualNetGeneration = generatorAnnualNetGeneration;
    } 



}
