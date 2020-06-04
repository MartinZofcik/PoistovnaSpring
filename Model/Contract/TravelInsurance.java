package com.example.demo.Model.Contract;

import com.example.demo.Model.API.*;
import com.example.demo.Model.Contract.*;
import com.example.demo.Model.Person.*;
import com.example.demo.Model.Contract.Enums.*;

import java.time.LocalDate;
import java.util.Date;

public class TravelInsurance extends Insurance{

    private Person insured;
    private boolean inEU;
    private PurposeOfTrip purpose;


    public TravelInsurance() {
    }

    public TravelInsurance(Person insured, int ID, LocalDate dateOfConclusion, LocalDate startOfInsurance, LocalDate endOfInsurance, double maxSumOfInsurance, double monthlyPayment, boolean inEU, PurposeOfTrip purpose) {
        super(insured, ID, dateOfConclusion, startOfInsurance, endOfInsurance, maxSumOfInsurance, monthlyPayment);
        this.insured = insured;
        this.inEU = inEU;
        this.purpose = purpose;
    }

    public Person getInsured() {
        return insured;
    }

    public void setInsured(Person insured) {
        this.insured = insured;
    }

    public boolean isInEU() {
        return inEU;
    }

    public void setInEU(boolean inEU) {
        this.inEU = inEU;
    }

    public PurposeOfTrip getPurpose() {
        return purpose;
    }

    public void setPurpose(PurposeOfTrip purpose) {
        this.purpose = purpose;
    }
}
