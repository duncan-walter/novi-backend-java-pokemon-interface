package PokemonGame.Creatures;

import java.util.ArrayList;
import java.util.List;

public class FirePokemon extends Pokemon {
    public FirePokemon(String name, int level, int hp, String food, String sound) {
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