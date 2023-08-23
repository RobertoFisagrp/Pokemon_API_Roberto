package com.example.pokedatax.model;

import lombok.Builder;
import lombok.Getter;

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


    @Builder
    @Getter
    public static class Types{
        private TypeDetails type;
    }


    @Builder
    @Getter
    public static class TypeDetails{
        private String name;

    }
    @Builder
    @Getter
    public static class Stats{
        private String base_stat;
        private String name;
        private String url;
    }

}
//https://pokeapi.co/api/v2/pokemon-species/257