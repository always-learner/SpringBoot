package com.sscodes.Services;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

/**
 * Jokes service
 *
 * Created by sam on 12/6/18.
 */
@Service
public class JokesService {

    private final ChuckNorrisQuotes chuckNorrisQuotes;

    public JokesService(){
        this.chuckNorrisQuotes =  new ChuckNorrisQuotes();
    }

    public String getNewJoke(){
        return chuckNorrisQuotes.getRandomQuote();
    }
}
