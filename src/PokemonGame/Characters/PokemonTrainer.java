package PokemonGame.Characters;

import PokemonGame.Creatures.Pokemon;

import java.util.List;

public class PokemonTrainer {
    private final String name;
    private final List<Pokemon> pokemons;

    public PokemonTrainer(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.pokemons = pokemons;
    }

    public String getName() {
        return this.name;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }
}