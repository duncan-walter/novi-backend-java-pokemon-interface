package PokemonGame.Creatures;

import java.util.Arrays;
import java.util.List;

public class GrassPokemon extends Pokemon {
    private final static String type = "grass";
    private final static List<String> attacks = Arrays.asList("leafStorm", "solarBeam", "leechSeed", "leaveBlade");

    public GrassPokemon(String name, int level, int hp, String food, String sound) {
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

    public void leafStorm(Pokemon attacker, Pokemon recipient) {
        // TODO: Implement.
    }

    public void solarBeam(Pokemon attacker, Pokemon recipient) {
        // TODO: Implement.
    }

    public void leechSeed(Pokemon attacker, Pokemon recipient) {
        // TODO: Implement.
    }

    public void leaveBlade(Pokemon attacker, Pokemon recipient) {
        // TODO: Implement.
    }
}