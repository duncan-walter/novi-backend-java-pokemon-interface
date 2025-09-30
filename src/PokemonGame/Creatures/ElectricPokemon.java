package PokemonGame.Creatures;

import java.util.Arrays;
import java.util.List;

public class ElectricPokemon extends Pokemon {
    private final static String type = "electric";
    private final static List<String> attacks = Arrays.asList("thunderPunch", "electroBall", "thunder", "voltTackle");

    public ElectricPokemon(String name, int level, int hp, String food, String sound) {
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

    public void thunderPunch(Pokemon attacker, Pokemon recipient) {
        // TODO: Implement.
    }

    public void electroBall(Pokemon attacker, Pokemon recipient) {
        // TODO: Implement.
    }

    public void thunder(Pokemon attacker, Pokemon recipient) {
        // TODO: Implement.
    }

    public void voltTackle(Pokemon attacker, Pokemon recipient) {
        // TODO: Implement.
    }
}