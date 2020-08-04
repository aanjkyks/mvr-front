package com.herokuapp.movieratingsystem.frontend.controller;

import com.herokuapp.movieratingsystem.frontend.model.MovieWithFile;
import com.herokuapp.movieratingsystem.frontend.integration.BackendConsumer;
import com.herokuapp.movieratingsystem.frontend.integration.model.MovieDto;
import com.herokuapp.movieratingsystem.frontend.service.MovieMapper;
import com.herokuapp.movieratingsystem.frontend.service.PersonToMovieBindingService;
import com.herokuapp.movieratingsystem.frontend.service.RatingCreator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/movie")
public class MovieController {
    private final BackendConsumer backendConsumer;
    private final PersonToMovieBindingService bindingService;
    private final RatingCreator ratingCreator;

    public MovieController(BackendConsumer backendConsumer, MovieMapper movieMapper, PersonToMovieBindingService bindingService, RatingCreator ratingCreator) {
        this.backendConsumer = backendConsumer;
        this.bindingService = bindingService;
        this.ratingCreator = ratingCreator;
    }

    @GetMapping("{id}")
    public String showMovie(Model model, @PathVariable Long id) {
        var movie = backendConsumer.findMovieById(id);
        model.addAttribute("movie", movie);
        return "movie";
    }

    @GetMapping("{id}/edit")
    public String editMovie(Model model, @PathVariable Long id) {
        var movie = backendConsumer.findMovieById(id);
        var people = backendConsumer.findPeople(null);
        model.addAttribute("movie", movie);
        model.addAttribute("people", people);
        return "editMovie";
    }

    @PostMapping
    public String saveMovie(@ModelAttribute("movie") MovieWithFile movieWF){
        var movie = bindingService.resolvePeople(movieWF);
        MovieDto movieDto;
        if (movie.getId() == null) {
            movieDto = backendConsumer.createMovie(movie);
        } else {
            movieDto = backendConsumer.updateMovie(movie);
        }
        return "redirect:/movie/" + movieDto.getId();
    }

    @PostMapping("{id}/rate")
    public String sendRating(@PathVariable Long id, @RequestParam Integer rating){
        backendConsumer.createRating(ratingCreator.createRating(id, rating));
        return "redirect:/movie/" + id;
    }

    @GetMapping("create")
    public String createMovie(Model model){
        var people = backendConsumer.findPeople(null);

        model.addAttribute("people", people);
        model.addAttribute("movie", new MovieDto());
        return "editMovie";
    }
}
