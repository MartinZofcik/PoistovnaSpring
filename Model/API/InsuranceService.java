package com.example.demo.Model.API;

import com.example.demo.Model.API.*;
import com.example.demo.Model.Contract.*;
import com.example.demo.Model.Person.*;
import com.example.demo.Model.Contract.Enums.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class InsuranceService {

    public TravelInsurance addTravelInsurance(Person insured, int ID, LocalDate dateOfConclusion, LocalDate startOfInsurance, LocalDate endOfInsurance, double maxSumOfInsurance, double monthlyPayment, boolean inEU, PurposeOfTrip purpose, ArrayList<Insurance> listOfAllContracts){
        TravelInsurance insurance = new TravelInsurance(insured, ID, dateOfConclusion, startOfInsurance, endOfInsurance, maxSumOfInsurance, monthlyPayment,  inEU, purpose);
        insured.getListOfOwnInsurances().add(insurance);
        listOfAllContracts.add(insurance);
        return insurance;
    }

    public AccidentInsurance addAccidentInsurance(Person insured, int ID, LocalDate dateOfConclusion, LocalDate startOfInsurance, LocalDate endOfInsurance, double maxSumOfInsurance, double monthlyPayment, double sumPermCons, double sumDeath, double dailyComp, Region region, ArrayList<Insurance> listOfAllContracts) {
        AccidentInsurance insurance = new AccidentInsurance(insured, ID, dateOfConclusion,  startOfInsurance, endOfInsurance, maxSumOfInsurance, monthlyPayment, sumPermCons, sumDeath, dailyComp, region);
        insured.getListOfOwnInsurances().add(insurance);
        listOfAllContracts.add(insurance);
        return insurance;
    }

    public HouseholdInsurance addHouseholdInsurance(Person insured, int ID, LocalDate dateOfConclusion, LocalDate startOfInsurance, LocalDate endOfInsurance, double maxSumOfInsurance, double monthlyPayment, TypeOfProperty typeOfProperty, String addressOfProperty, double valueOfProperty, double valueOfEquipment, ArrayList<Insurance> listOfAllContracts) {
        HouseholdInsurance insurance = new HouseholdInsurance(insured, ID, dateOfConclusion, startOfInsurance, endOfInsurance, maxSumOfInsurance, monthlyPayment, typeOfProperty, addressOfProperty, valueOfProperty, valueOfEquipment);
        insured.getListOfOwnInsurances().add(insurance);
        listOfAllContracts.add(insurance);
        return insurance;
    }

    public FlatHouseInsurance addFlatHouseInsurance(Person insured, int ID, LocalDate dateOfConclusion, LocalDate startOfInsurance, LocalDate endOfInsurance, double maxSumOfInsurance, double monthlyPayment, TypeOfProperty typeOfProperty, String addressOfProperty, double valueOfProperty, boolean garageInsurance, ArrayList<Insurance> listOfAllContracts) {
        FlatHouseInsurance insurance = new FlatHouseInsurance( insured, ID, dateOfConclusion, startOfInsurance, endOfInsurance, maxSumOfInsurance, monthlyPayment, typeOfProperty, addressOfProperty, valueOfProperty, garageInsurance);
        insured.getListOfOwnInsurances().add(insurance);
        listOfAllContracts.add(insurance);
        return insurance;
    }

    public Insurance changeDateOfConclusion(Insurance insurance, LocalDate date){
        insurance.setDateOfConclusion(date);
        return insurance;
    }

    public Insurance changeMonthlyPayment(Insurance insurance, double sum){
        insurance.setMonthlyPayment(sum);
        return insurance;
    }

    public void printAllContracts(ArrayList<Insurance> listOfInsurances){
        for (int i = 0 ; i < listOfInsurances.size(); i++){
            System.out.println(listOfInsurances.get(i).toString());
        }
    }

}
