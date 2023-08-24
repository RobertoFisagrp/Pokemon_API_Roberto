package com.example.pokedatax.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class TypeDetails {
    private String name;
    private int id;
    private List<TypeDetail> doubleDamageFrom;
    private List<String> doubleDamageFromNames;

    @Override
    public String toString() {
        return " doubleDamageFrom=" + doubleDamageFrom +
                '}';
    }
}
