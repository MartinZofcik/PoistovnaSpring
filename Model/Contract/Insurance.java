package com.example.demo.Model.Contract;

import com.example.demo.Model.API.*;
import com.example.demo.Model.Contract.*;
import com.example.demo.Model.Person.*;
import com.example.demo.Model.Contract.Enums.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

public class Insurance {

    private TypeOfInsurance typeOfInsurance;
    private Person insured;
    private int ID;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfConclusion;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startOfInsurance;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endOfInsurance;
    private double maxSumOfInsurance;
    private double monthlyPayment;


    public Insurance() {
    }

    public Insurance(Person insured) {
        this.insured = insured;
    }

    public Insurance(Person insured, int ID, LocalDate dateOfConclusion, LocalDate startOfInsurance, LocalDate endOfInsurance, double maxSumOfInsurance, double monthlyPayment) {
        this.insured = insured;
        this.ID = ID;
        this.dateOfConclusion = dateOfConclusion;
        this.startOfInsurance = startOfInsurance;
        this.endOfInsurance = endOfInsurance;
        this.maxSumOfInsurance = maxSumOfInsurance;
        this.monthlyPayment = monthlyPayment;
    }

    public Person getInsured() {
        return insured;
    }

    public TypeOfInsurance getTypeOfInsurance() {
        return typeOfInsurance;
    }

    public void setTypeOfInsurance(TypeOfInsurance typeOfInsurance) {
        this.typeOfInsurance = typeOfInsurance;
    }

    public int getInsuredID(){
        return insured.getID();
    }

    public int getID() {return ID; }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDate getDateOfConclusion() {
        return dateOfConclusion;
    }

    public void setDateOfConclusion(LocalDate dateOfConclusion) {
        this.dateOfConclusion = dateOfConclusion;
    }

    public LocalDate getStartOfInsurance() {
        return startOfInsurance;
    }

    public void setStartOfInsurance(LocalDate startOfInsurance) {
        this.startOfInsurance = startOfInsurance;
    }

    public LocalDate getEndOfInsurance() {
        return endOfInsurance;
    }

    public void setEndOfInsurance(LocalDate endOfInsurance) {
        this.endOfInsurance = endOfInsurance;
    }

    public double getMaxSumOfInsurance() {
        return maxSumOfInsurance;
    }

    public void setMaxSumOfInsurance(double maxSumOfInsurance) {
        this.maxSumOfInsurance = maxSumOfInsurance;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
}
