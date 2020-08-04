package com.herokuapp.movieratingsystem.frontend.controller;

import com.herokuapp.movieratingsystem.frontend.integration.BackendConsumer;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    private final BackendConsumer backendConsumer;

    public IndexController(BackendConsumer backendConsumer) {
        this.backendConsumer = backendConsumer;
    }

    @GetMapping({"", "/home", "/index", "index.hmtl"})
    public String index(Model model,
                        @RequestParam(required = false) String name,
                        @RequestParam(required = false) String dName) {

        name = Strings.isNotBlank(name) ? name : null;
        dName = Strings.isNotBlank(dName) ? dName : null;

        var movies = backendConsumer.findMovies(name, dName);
        model.addAttribute("movies", movies);

        return "index";
    }


}
