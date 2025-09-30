package PokemonGame.Creatures;

import java.util.List;

public abstract class Pokemon {
    public Pokemon(String name, int level, int hp, String food, String sound) {
        // TODO: Assign variables, getters and setters.
    }

    public abstract String getType();
    public abstract List<String> getAttacks();

    public String getName() {
        // TODO: Implement.
        return "";
    }

    public int getHp() {
        // TODO: Implement.
        return 0;
    }

    public int getLevel() {
        // TODO: Implement.
        return 0;
    }

    public String getFood() {
        // TODO: Implement.
        return "";
    }

    public String getSound() {
        // TODO: Implement.
        return "";
    }
}