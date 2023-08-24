package com.example.pokedatax.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
public class Pokemon {
    private int id;
    private String name;
    private double height;
    private double weight;
    private List<Types> types;
    private List<Stats> stats;
    private List<TypeDetails> weaknesses;
    private List<flavor_text_entries> description;


    @Setter
    @Getter
    public static class Types{
        private TypeDetails type;
    }


    @Setter
    @Getter
    public static class TypeDetails{
        private String name;
        private List<TypeDetails> weaknesses;

    }
    @Setter
    @Getter
    public static class Stats{
        private String base_stat;
        private String name;
        private String url;
    }
    @Builder
    @Getter
    @Setter
    public static class flavor_text_entries{
        private String flavor_text;
        private String name;
        private String version;
    }


}
//https://pokeapi.co/api/v2/pokemon-species/257