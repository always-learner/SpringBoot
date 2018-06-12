package com.sscodes.Controllers;

import com.sscodes.Services.JokesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Jokes controller
 *
 * Created by sam on 12/6/18.
 */
@Controller
public class JokesController {

    private final JokesService jokesService;

    @Autowired
    public JokesController(final JokesService jokesService){
        this.jokesService = jokesService;
    }

    @RequestMapping("/")
    public String getNewJokes(final Model model){
        model.addAttribute("joke", jokesService.getNewJoke());
        return "chucknorris";
    }
}
