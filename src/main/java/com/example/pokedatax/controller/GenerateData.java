package com.example.pokedatax.controller;

import com.example.pokedatax.client.PokemonClientApi;
import com.example.pokedatax.model.Pokemon;
import com.example.pokedatax.model.Result;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GenerateData {
    private Pokemon pokemon;
    private PokemonClientApi pokemonClientApi;

    public GenerateData(Pokemon pokemon, PokemonClientApi pokemonClientApi) {
        this.pokemon = pokemon;
        this.pokemonClientApi = pokemonClientApi;
    }
    public Optional<Result> getInformation(){
        if (pokemon != null){
            Result.ResultBuilder resultBuilder = Result.builder();
            resultBuilder.name(pokemon.getName());
            resultBuilder.height(pokemon.getHeight());
            resultBuilder.weight(pokemon.getWeight());
            List<String> types = pokemon.getTypes()
                    .stream()
                    .map(Pokemon.Types::getType)
                    .map(Pokemon.TypeDetails::getName)
                    .collect(Collectors.toList());
            resultBuilder.type(types);


            List<String> stats = pokemon.getStats().stream().map(Pokemon.Stats::getBase_stat).collect(Collectors.toList());
            resultBuilder.stat(stats);
            System.out.println(resultBuilder);
            return Optional.of(resultBuilder.build());

        }
        return Optional.empty();

    }
}
