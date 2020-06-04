package com.example.demo.Model.Contract;

import com.example.demo.Model.API.*;
import com.example.demo.Model.Contract.*;
import com.example.demo.Model.Person.*;
import com.example.demo.Model.Contract.Enums.*;

import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.Date;

public class AccidentInsurance extends  Insurance{

    @Min(0)
    private double sumPermCons;
    @Min(0)
    private double sumDeath;
    @Min(0)
    private double dailyComp;
    private Region region;


    public AccidentInsurance() {
    }

    public AccidentInsurance(Person insured, int ID, LocalDate dateOfConclusion, LocalDate startOfInsurance, LocalDate endOfInsurance, double maxSumOfInsurance, double monthlyPayment, double sumPermCons, double sumDeath, double dailyComp, Region region) {
        super(insured, ID, dateOfConclusion,  startOfInsurance, endOfInsurance, maxSumOfInsurance, monthlyPayment);
        this.sumPermCons = sumPermCons;
        this.sumDeath = sumDeath;
        this.dailyComp = dailyComp;
        this.region = region;
    }

    public double getSumPermCons() {
        return sumPermCons;
    }

    public void setSumPermCons(double sumPermCons) {
        this.sumPermCons = sumPermCons;
    }

    public double getSumDeath() {
        return sumDeath;
    }

    public void setSumDeath(double sumDeath) {
        this.sumDeath = sumDeath;
    }

    public double getDailyComp() {
        return dailyComp;
    }

    public void setDailyComp(double dailyComp) {
        this.dailyComp = dailyComp;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}

