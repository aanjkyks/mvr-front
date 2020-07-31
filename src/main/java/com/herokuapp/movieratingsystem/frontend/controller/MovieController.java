package com.herokuapp.movieratingsystem.frontend.controller;

import com.herokuapp.movieratingsystem.frontend.MovieWithFile;
import com.herokuapp.movieratingsystem.frontend.integration.BackendConsumer;
import com.herokuapp.movieratingsystem.frontend.integration.model.MovieDto;
import com.herokuapp.movieratingsystem.frontend.service.MovieMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class MovieController {
    private final BackendConsumer backendConsumer;
    private final MovieMapper movieMapper;

    public MovieController(BackendConsumer backendConsumer, MovieMapper movieMapper) {
        this.backendConsumer = backendConsumer;
        this.movieMapper = movieMapper;
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
        model.addAttribute("movie", movie);
        model.addAttribute("movieWF", new MovieWithFile());
        return "editMovie";
    }

    @PostMapping
    public String saveMovie(@ModelAttribute("movie") MovieWithFile movieWF){
        var movie = movieMapper.toBase64Movie(movieWF);
        System.out.println(movie);
        MovieDto movieDto;
//        if (movie.getId() == null) {
//            movieDto = backendConsumer.createMovie(movie);
//        } else {
//            movieDto = backendConsumer.updateMovie(movie);
//        }
//        return "redirect:/movie/" + movieDto.getId();
        return "index";
    }
}
