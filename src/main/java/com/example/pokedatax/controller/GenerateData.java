package com.example.pokedatax.controller;

import com.example.pokedatax.client.PokemonClientApi;
import com.example.pokedatax.model.*;

import java.util.ArrayList;
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
            double height = pokemon.getHeight()/10;

            resultBuilder.height(height);
            double weight = pokemon.getWeight()/10;
            resultBuilder.weight(weight);
            List<String> types = pokemon.getTypes()
                    .stream()
                    .map(Pokemon.Types::getType)
                    .map(Pokemon.TypeDetails::getName)
                    .collect(Collectors.toList());

            String typesAsString = String.join(", ", types);
            resultBuilder.type(typesAsString);


            List<String> stats = pokemon.getStats().stream().map(Pokemon.Stats::getBase_stat).collect(Collectors.toList());
            resultBuilder.stat(stats);
           /* String description = pokemon.getDescription().stream()
                    .filter(desc -> "fr".equals(desc.getName()))
                    .findFirst()
                    .map(Pokemon.FlavorTextEntries::getFlavorText)
                    .orElse("Description not found");
            resultBuilder.description(description);

            */


            List<String> typesWeek = new ArrayList<>();
            /*
            pokemon.getWeaknesses().forEach(p-> {TypeDetails typeDetails = pokemonClientApi.getTypeDetails(p.getName());
            typesWeek.add(typeDetails.getDoubleDamageFromNames().toString());});
            resultBuilder.weaknesses(typesWeek);
*/
            System.out.println(resultBuilder);
            return Optional.of(resultBuilder.build());

        }
        return Optional.empty();

    }
}
