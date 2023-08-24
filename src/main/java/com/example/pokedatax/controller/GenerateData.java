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

            List<PokemonDescription> desc = new ArrayList<>();
            desc.add(pokemonClientApi.getPokemonDescription(pokemon.getName()));
            StringBuilder descriptionStr = new StringBuilder();
            for (int i = 0; i < desc.get(0).getFlavor_text_entries().size(); i++) {
                if(desc.get(0).getFlavor_text_entries().get(i).getLanguage().getName().equals("fr")){
                    String description = desc.get(0).getFlavor_text_entries().get(i).getFlavor_text();
                    descriptionStr.append(description);
                    break;
                }
            }

            resultBuilder.description(descriptionStr.toString());




            List<String> stats = pokemon.getStats().stream().map(Pokemon.Stats::getBase_stat).collect(Collectors.toList());
            resultBuilder.stat(stats);

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
