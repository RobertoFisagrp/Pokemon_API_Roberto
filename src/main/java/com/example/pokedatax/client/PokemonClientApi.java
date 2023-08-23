package com.example.pokedatax.client;

import com.example.pokedatax.model.Pokemon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pokemonApi",url="https://pokeapi.co/api/v2")
public interface PokemonClientApi {
    @GetMapping("/pokemon/{pokemon}")
    Pokemon getDataPokemon(@PathVariable String pokemon);
}
