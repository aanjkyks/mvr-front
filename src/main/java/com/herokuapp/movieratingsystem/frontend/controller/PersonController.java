package com.herokuapp.movieratingsystem.frontend.controller;

import com.herokuapp.movieratingsystem.frontend.integration.BackendConsumer;
import com.herokuapp.movieratingsystem.frontend.integration.model.PersonDto;
import com.herokuapp.movieratingsystem.frontend.model.PersonWithFile;
import com.herokuapp.movieratingsystem.frontend.service.PersonMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {
    private final BackendConsumer backendConsumer;
    private final PersonMapper personMapper;

    public PersonController(BackendConsumer backendConsumer, PersonMapper personMapper) {
        this.backendConsumer = backendConsumer;
        this.personMapper = personMapper;
    }

    @GetMapping("{id}")
    public String personView(@PathVariable Long id, Model model){
        var person = backendConsumer.getActorById(id);
        model.addAttribute("person", person);
        return "person";
    }

    @GetMapping("people")
    public String peopleView(Model model){
        var people = backendConsumer.findPeople(null);
        model.addAttribute("people", people);
        return "people";
    }

    @GetMapping("create")
    public String createPersonView(Model model){
        model.addAttribute("person", new PersonDto());
        return "editPerson";
    }

    @GetMapping("{id}/edit")
    public String editPersonView(@PathVariable Long id, Model model){
        var person = backendConsumer.findPersonById(id);
        model.addAttribute("person", person);
        return "editPerson";
    }

    @PostMapping
    public String savePerson(@ModelAttribute("person") PersonWithFile personWF){
        PersonDto person;
        var request = personMapper.toBackendPerson(personWF);
        if (request.getId() == null){
            person = backendConsumer.createPerson(request);
        } else {
            person = backendConsumer.updatePerson(request);
        }
        return "redirect:/person/" + person.getId();
    }
}
