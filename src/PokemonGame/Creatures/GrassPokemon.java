package PokemonGame.Creatures;

import java.util.ArrayList;
import java.util.List;

public class GrassPokemon extends Pokemon {
    public GrassPokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound);
    }

    @Override
    public String getType() {
        return "";
        // TODO: Implement.
    }

    @Override
    public List<String> getAttacks() {
        return new ArrayList<>();
        // TODO: Implement.
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