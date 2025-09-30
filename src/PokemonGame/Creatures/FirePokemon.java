package PokemonGame.Creatures;

import java.util.Arrays;
import java.util.List;

public class FirePokemon extends Pokemon {
    private final static String type = "fire";
    private final static List<String> attacks = Arrays.asList("inferno", "pyroBall", "fireLash", "flameThrower");

    public FirePokemon(String name, int level, int hp, String food, String sound) {
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

    public void inferno(Pokemon attacker, Pokemon recipient) {
        // TODO: Implement.
    }

    public void pyroBall(Pokemon attacker, Pokemon recipient) {
        // TODO: Implement.
    }

    public void fireLash(Pokemon attacker, Pokemon recipient) {
        // TODO: Implement.
    }

    public void flameThrower(Pokemon attacker, Pokemon recipient) {
        // TODO: Implement.
    }
}