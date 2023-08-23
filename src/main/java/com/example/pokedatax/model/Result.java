package com.example.pokedatax.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Result {
    private int id;
    private String name;
    private double height;
    private double weight;
    private List<String> type;
    private List<String> stat;

    public static class ResultBuilder{
        @Override
        public String toString() {
            return "Pokedex \n" +
                    " \n name='" + name + '\'' +
                    " \n height=" + height +
                    " \n weight=" + weight +
                    "\n type=" + type +
                    "\n stat=" + stat +
                    '}';
        }
    }
}
