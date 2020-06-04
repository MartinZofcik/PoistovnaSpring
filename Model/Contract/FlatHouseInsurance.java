package com.example.demo.Model.Contract;

import com.example.demo.Model.API.*;
import com.example.demo.Model.Contract.*;
import com.example.demo.Model.Person.*;
import com.example.demo.Model.Contract.Enums.*;

import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.Date;

public class FlatHouseInsurance extends Insurance{

    private TypeOfProperty typeOfProperty;
    private String addressOfProperty;
    @Min(0)
    private double valueOfProperty;
    private boolean garageInsurance;


    public FlatHouseInsurance() {
    }

    public FlatHouseInsurance(Person insured, int ID, LocalDate dateOfConclusion, LocalDate startOfInsurance, LocalDate endOfInsurance, double maxSumOfInsurance, double monthlyPayment, TypeOfProperty typeOfProperty, String addressOfProperty, double valueOfProperty, boolean garageInsurance) {
        super(insured, ID, dateOfConclusion, startOfInsurance, endOfInsurance, maxSumOfInsurance, monthlyPayment);
        this.typeOfProperty = typeOfProperty;
        this.addressOfProperty = addressOfProperty;
        this.valueOfProperty = valueOfProperty;
        this.garageInsurance = garageInsurance;
    }

    public boolean isGarageInsurance() {
        return garageInsurance;
    }

    public void setGarageInsurance(boolean garageInsurance) {
        this.garageInsurance = garageInsurance;
    }

    public TypeOfProperty getTypeOfProperty() {
        return typeOfProperty;
    }

    public void setTypeOfProperty(TypeOfProperty typeOfProperty) {
        this.typeOfProperty = typeOfProperty;
    }

    public String getAddressOfProperty() {
        return addressOfProperty;
    }

    public void setAddressOfProperty(String addressOfProperty) {
        this.addressOfProperty = addressOfProperty;
    }

    public double getValueOfProperty() {
        return valueOfProperty;
    }

    public void setValueOfProperty(double valueOfProperty) {
        this.valueOfProperty = valueOfProperty;
    }
}
