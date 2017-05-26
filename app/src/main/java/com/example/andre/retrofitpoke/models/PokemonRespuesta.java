package com.example.andre.retrofitpoke.models;

import java.util.ArrayList;

/**
 * Created by andre on 19/05/2017.
 */

public class PokemonRespuesta {

    private ArrayList<Pokemon>results;

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
