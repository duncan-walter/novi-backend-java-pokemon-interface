package PokemonGame.Creatures;

import java.util.ArrayList;
import java.util.List;

public class ElectricPokemon extends Pokemon {
    public ElectricPokemon(String name, int level, int hp, String food, String sound) {
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