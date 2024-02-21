package com.sce.dataset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/dataset")
public class PersonController {

    @Autowired
    private PersonService personService;

    /*@GetMapping
    public ArrayList<Person> getPerson(){
        return this.personService.getPerson();
    }*/
}
