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
                        @RequestParam(required = false) String search) {

        var name = Strings.isNotBlank(search) ? search : null;
        var dName = Strings.isNotBlank(search) ? search : null;

        var movies = backendConsumer.findMovies(name, dName);
        model.addAttribute("movies", movies);

        return "index";
    }


}
