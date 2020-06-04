package com.example.demo.Model.Person;

import com.example.demo.Model.API.*;
import com.example.demo.Model.Contract.*;
import com.example.demo.Model.Person.*;
import com.example.demo.Model.Contract.Enums.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

public class Person{
    @Min(0)
    private int ID;
    @Size(min = 1)
    private String name;
    @Size(min = 1)
    private String surname;
    @Size(min = 1)
    private String IN;
    @Size(min = 2)
    private String email;
    @Size(min = 10)
    private String homeAddress;
    @Size(min = 10)
    private String corrAddress;

    private ArrayList<Insurance> listOfOwnInsurances = new ArrayList<Insurance>();

    public Person() {
    }

    public Person(int ID, String name, String surname, String IN, String email, String homeAddress, String corrAddress) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.IN = IN;
        this.email = email;
        this.homeAddress = homeAddress;
        this.corrAddress = corrAddress;
    }

    @Override
    public String toString() {
        return  name + ' ' + surname;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIN() {
        return IN;
    }

    public void setIN(String IN) {
        this.IN = IN;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getCorrAddress() {
        return corrAddress;
    }

    public void setCorrAddress(String corrAddress) {
        this.corrAddress = corrAddress;
    }

    public ArrayList<Insurance> getListOfOwnInsurances() {
        return listOfOwnInsurances;
    }

    public void setListOfOwnInsurances(ArrayList<Insurance> listOfOwnInsurances) {
        this.listOfOwnInsurances = listOfOwnInsurances;
    }


}
