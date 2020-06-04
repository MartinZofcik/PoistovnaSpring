package com.example.demo.Controller;

import com.example.demo.Model.API.*;
import com.example.demo.Model.Contract.*;
import com.example.demo.Model.Person.*;
import com.example.demo.Model.Contract.Enums.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;


@Controller
@SpringBootApplication

public class ControlService implements CommandLineRunner {

    InsuranceService insuranceService = new InsuranceService();
    PersonService personService = new PersonService();

    LocalDate date1 = LocalDate.of(2020, 10, 20);
    LocalDate date2 = LocalDate.of(2019, 1, 25);

    private final ArrayList<Person> allPerson = new ArrayList();
    private final ArrayList<Insurance> allContracts = new ArrayList();

    @Override
    public void run(String... args) throws Exception {

        personService.addPerson(allPerson.size(), "Peter", "Peter", "990202/3698", "peter@gmail.com", " 91111 Bratislava Ulica1 10", "92222 Kosice Ulica2 20", allPerson);
        personService.addPerson(allPerson.size(), "Jakub", "Jakub", "850230/3812", "jakub@gmail.com", "92222 Kosice Ulica2 20", "91111 Bratislava Ulica1 10", allPerson);
        personService.addPerson(allPerson.size(), "Jano", "Jano", "850225/2580", "jano@gmail.com", "93333 Nitra Ulica3 30", "92222 Kosice Ulica2 20", allPerson);

        insuranceService.addAccidentInsurance(allPerson.get(0), allContracts.size(), date1, date2, date1, 1111, 111, 10, 10000, 100, Region.SLOVAKIAWORLD, allContracts);
        insuranceService.addTravelInsurance(allPerson.get(0), allContracts.size(), date2, date2, date1, 2222, 222, true, PurposeOfTrip.SPORT, allContracts);
        insuranceService.addFlatHouseInsurance(allPerson.get(1), allContracts.size(), date2, date2, date1, 3333, 333, TypeOfProperty.FAMILYHOUSEBRICK, "91111 Bratislava Ulica1 10", 1000, true, allContracts);
        insuranceService.addHouseholdInsurance(allPerson.get(1), allContracts.size(), date2, date1, date2, 4444, 444, TypeOfProperty.FLAT, "91111 Bratislava Ulica1 10", 100, 100, allContracts);
        }

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    ////////////////////////////////////////////////////////////////////////////////////person
    @GetMapping("/person/show/all")
    public String showAllPerson(Model model) {
        model.addAttribute("people", allPerson);
        return "showAllPerson";
    }

    @GetMapping("/person/show/{id}")
    public String showOnePerson(@PathVariable int id, Model model) {
        model.addAttribute("person", allPerson.get(id));
        model.addAttribute("allContract", allContracts);
        return "showOnePerson";
    }

    @GetMapping("/person/add")
    public String addOnePerson(Model model) {
        model.addAttribute("person", new Person());
        return "addOnePerson";
    }

    @PostMapping("/person/add")
    public String addOnePerson(@ModelAttribute @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addOnePerson";
        }
        person.setID(allPerson.size());
        allPerson.add(person);
        return "redirect:/person/show/all";
    }

    @GetMapping("/person/modify/{id}")
    public String modifyOnePerson(@PathVariable int id, Model model) {
        model.addAttribute("person", allPerson.get(id));
        return "modifyPerson";
    }

    @PostMapping("/person/modify")
    public String modifyOnePerson(@ModelAttribute @Valid Person person,  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "modifyPerson";
        }
        person.setListOfOwnInsurances(allPerson.get(person.getID()).getListOfOwnInsurances());
        allPerson.set(person.getID(), person);
        return "redirect:/person/show/all";
    }

    ////////////////////////////////////////////////////////////////////////////////////contract

    @GetMapping("/contract/show/all")
    public String showAllContracts(Model model) {
        model.addAttribute("contracts", allContracts);
        return "showAllContracts";
    }

    @GetMapping("/contract/show/{id}")
    public String showContract(@PathVariable int id, Model model) {
        for (Insurance insurance : allContracts) {
            if (insurance.getID() == id) {

                if (insurance instanceof AccidentInsurance) {
                    AccidentInsurance temp = (AccidentInsurance) insurance;
                    model.addAttribute("contract", temp);
                    model.addAttribute("insuredID",insurance.getInsuredID());
                    return "showAccident";
                }

                if (insurance instanceof TravelInsurance) {
                    TravelInsurance temp = (TravelInsurance) insurance;
                    model.addAttribute("contract", temp);
                    model.addAttribute("insuredID",insurance.getInsuredID());
                    return "showTravel";
                }

                if (insurance instanceof FlatHouseInsurance) {
                    FlatHouseInsurance temp = (FlatHouseInsurance) insurance;
                    model.addAttribute("contract", temp);
                    model.addAttribute("insuredID",insurance.getInsuredID());
                    return "showFlatHouse";
                }

                if (insurance instanceof HouseholdInsurance) {
                    HouseholdInsurance temp = (HouseholdInsurance) insurance;
                    model.addAttribute("contract", temp);
                    model.addAttribute("insuredID",insurance.getInsuredID());
                    return "showHousehold";
                }
                else{
                    model.addAttribute("contract", insurance);
                    return "showInsurance";
                }
            }
        }
        return null;
    }

    @GetMapping("/person/addContract/{id}")
    public String addContract(@PathVariable int id, Model model) {
        model.addAttribute("contract", new Insurance());
        model.addAttribute("personID", id);
        return "addContract";
    }

    @PostMapping("/person/addContract/{id}")
    public String addContract(@PathVariable int id, @ModelAttribute Insurance contract) {
        contract.setID(allContracts.size());
        allContracts.add(contract);
        allPerson.get(id).getListOfOwnInsurances().add(contract);
        return "redirect:/person/show/{id}";
    }


    @GetMapping("/contract/modify/{idP}/{idC}")
    public String modifyContract(@PathVariable int idC, @PathVariable int idP, Model model) {
        for (Insurance insurance : allContracts) {
            if (insurance.getID() == idC) {

                if (insurance instanceof AccidentInsurance) {
                    AccidentInsurance temp = (AccidentInsurance) insurance;
                    model.addAttribute("contract", temp);
                    model.addAttribute("person", allPerson.get(idP));
                    return "modifyAccident";
                }
                if (insurance instanceof TravelInsurance) {
                    TravelInsurance temp = (TravelInsurance) insurance;
                    model.addAttribute("contract", temp);
                    model.addAttribute("person", allPerson.get(idP));
                    return "modifyTravel";
                }
                if (insurance instanceof FlatHouseInsurance) {
                    FlatHouseInsurance temp = (FlatHouseInsurance) insurance;
                    model.addAttribute("contract", temp);
                    model.addAttribute("person", allPerson.get(idP));
                    return "modifyFlatHouse";
                }
                if (insurance instanceof HouseholdInsurance) {
                    HouseholdInsurance temp = (HouseholdInsurance) insurance;
                    model.addAttribute("contract", temp);
                    model.addAttribute("person", allPerson.get(idP));
                    return "modifyHousehold";
                }
                else {
                    model.addAttribute("contract", insurance);
                    model.addAttribute("person", allPerson.get(idP));
                    return "modifyInsurance";
                }
            }
        }
        return null;
    }

    @PostMapping("/contract/modify/{idP}/{idC}")
    public String modifyContract(@ModelAttribute Insurance insurance, @PathVariable int idP, @PathVariable int idC) {
        insurance.setID(idC);
        allPerson.get(idP).getListOfOwnInsurances().set(idC, insurance);
        allContracts.set(idC, insurance);
        return "redirect:/person/show/{idP}";
    }
}
