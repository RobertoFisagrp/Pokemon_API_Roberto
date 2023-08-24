package com.example.pokedatax.client;

import com.example.pokedatax.model.Pokemon;
import com.example.pokedatax.model.PokemonDescription;
import com.example.pokedatax.model.TypeDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pokemonApi",url="https://pokeapi.co/api/v2")
public interface PokemonClientApi {
    @GetMapping("/pokemon/{pokemon}")
    Pokemon getDataPokemon(@PathVariable String pokemon);
    @GetMapping("/pokemon-species/{name}/")
    PokemonDescription getPokemonDescription(@PathVariable String name);
    @GetMapping("/type/{typeId}")
    TypeDetails getTypeDetails(@PathVariable("typeId") String typeId);
}
