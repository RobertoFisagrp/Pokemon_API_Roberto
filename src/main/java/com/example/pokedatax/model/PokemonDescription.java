package com.example.pokedatax.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PokemonDescription {
    private String flavor_text;
    private String name;
    private String version;
}
