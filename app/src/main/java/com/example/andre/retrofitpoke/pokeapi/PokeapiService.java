package com.example.andre.retrofitpoke.pokeapi;

import com.example.andre.retrofitpoke.models.Pokemon;
import com.example.andre.retrofitpoke.models.PokemonRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by andre on 19/05/2017.
 */

public interface PokeapiService {

    @GET("pokemon")
    Call<PokemonRespuesta> obtenerListaPokemon(@Query("limit")int limit, @Query("offset") int offset);

    @GET("pokemon/{id}/")
    Call<Pokemon> obtenerDatosPokemon(@Path("id") int id);
}
