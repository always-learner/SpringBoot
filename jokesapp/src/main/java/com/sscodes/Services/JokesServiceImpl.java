package com.sscodes.Services;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

/**
 * Jokes service
 *
 * Created by sam on 12/6/18.
 */
@Service
public class JokesServiceImpl implements JokesService{

    private final ChuckNorrisQuotes chuckNorrisQuotes;

    public JokesServiceImpl(){
        this.chuckNorrisQuotes =  new ChuckNorrisQuotes();
    }

    @Override
    public String getJoke() {
        return chuckNorrisQuotes.getRandomQuote();
    }
}
