package com.example.demo.Model.Contract;

import com.example.demo.Model.API.*;
import com.example.demo.Model.Contract.*;
import com.example.demo.Model.Person.*;
import com.example.demo.Model.Contract.Enums.*;

import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.Date;

public class HouseholdInsurance extends Insurance {

    private TypeOfProperty typeOfProperty;
    private String addressOfProperty;
    @Min(0)
    private double valueOfProperty;
    @Min(0)
    private double valueOfEquipment;


    public HouseholdInsurance() {
    }

    public HouseholdInsurance(Person insured, int ID, LocalDate dateOfConclusion, LocalDate startOfInsurance, LocalDate endOfInsurance, double maxSumOfInsurance, double monthlyPayment, TypeOfProperty typeOfProperty, String addressOfProperty, double valueOfProperty, double valueOfEquipment) {
        super(insured, ID, dateOfConclusion, startOfInsurance, endOfInsurance, maxSumOfInsurance, monthlyPayment);
        this.typeOfProperty = typeOfProperty;
        this.addressOfProperty = addressOfProperty;
        this.valueOfProperty = valueOfProperty;
        this.valueOfEquipment = valueOfEquipment;
    }

    public double getValueOfEquipment() {
        return valueOfEquipment;
    }

    public void setValueOfEquipment(double valueOfEquipment) {
        this.valueOfEquipment = valueOfEquipment;
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
