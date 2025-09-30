package PokemonGame.Creatures;

import java.util.ArrayList;
import java.util.List;

public class WaterPokemon extends Pokemon {
    public WaterPokemon(String name, int level, int hp, String food, String sound) {
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