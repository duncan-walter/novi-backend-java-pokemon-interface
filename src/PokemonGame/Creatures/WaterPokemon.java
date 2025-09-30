package PokemonGame.Creatures;

import java.util.Arrays;
import java.util.List;

public class WaterPokemon extends Pokemon {
    private final static String type = "water";
    private final static List<String> attacks = Arrays.asList("surf", "hydroPump", "hydroCanon", "rainDance");

    public WaterPokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound);
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public List<String> getAttacks() {
        return attacks;
    }

    public void surf(Pokemon attacker, Pokemon recipient) {
        // TODO: Implement.
    }

    public void hydroPump(Pokemon attacker, Pokemon recipient) {
        // TODO: Implement.
    }

    public void hydroCanon(Pokemon attacker, Pokemon recipient) {
        // TODO: Implement.
    }

    public void rainDance(Pokemon attacker, Pokemon recipient) {
        // TODO: Implement.
    }
}