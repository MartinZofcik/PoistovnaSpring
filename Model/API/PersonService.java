package com.example.demo.Model.API;

import com.example.demo.Model.API.*;
import com.example.demo.Model.Contract.*;
import com.example.demo.Model.Person.*;
import com.example.demo.Model.Contract.Enums.*;

import java.util.ArrayList;

public class PersonService {

    public Person addPerson(int ID, String name, String surname, String IN, String email, String homeAddress, String corrAddress,  ArrayList<Person> listOfAllPersons){
        Person person = new Person(ID, name, surname, IN, email, homeAddress, corrAddress);
        listOfAllPersons.add(person);
        return person;
    }


    public Person modifyPersName(Person person, String name){
        person.setName(name);
        return person;
    }

    public Person modifyPersSurame(Person person, String surname){
        person.setSurname(surname);
        return person;
    }

    public Person modifyPersIN(Person person, String IN){
        person.setIN(IN);
        return person;
    }

    public Person modifyPersEmail(Person person, String email){
        person.setEmail(email);
        return person;
    }

    public Person modifyPersHomeAddress(Person person, String address){
        person.setHomeAddress(address);
        return person;
    }

    public Person modifyPersCorrAddress(Person person, String address){
        person.setCorrAddress(address);
        return person;
    }

    public Person changePersListOfOwnInsurances(Person person, ArrayList<Insurance> listOfOwnInsurances){
        person.setListOfOwnInsurances(listOfOwnInsurances);
        return person;
    }

    public void printAllPers(ArrayList<Person> listOfPersons){
        for (int i = 0; i < listOfPersons.size(); i++)
                System.out.println(listOfPersons.get(i).toString());
    }

    public void printPersByID(ArrayList<Person> listOfPersons, int ID){
        for (int i = 0; i < listOfPersons.size(); i++) {
            if(listOfPersons.get(i).getID() == ID)
                System.out.println(listOfPersons.get(i).toString());
        }
    }

}


