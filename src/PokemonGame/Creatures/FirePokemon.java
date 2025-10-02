package PokemonGame.Creatures;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FirePokemon extends Pokemon {
    private final static String type = "fire";
    private final static List<String> attacks = Arrays.asList("inferno", "pyroBall", "fireLash", "flameThrower");
    private final static Map<String, Double> attackMultiplierByType = Map.ofEntries(
            Map.entry("electric", .75),
            Map.entry("fire", .5),
            Map.entry("grass", 1.5),
            Map.entry("water", 1.0)
    );

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

    @Override
    public Double getAttackMultiplier(Pokemon recipient) {
        return attackMultiplierByType.getOrDefault(recipient.getType(), 1.0);
    }

    public void inferno(Pokemon attacker, Pokemon recipient) {
        attack("inferno", 10, attacker, recipient);
    }

    public void pyroBall(Pokemon attacker, Pokemon recipient) {
        attack("pyro ball", 15, attacker, recipient);
    }

    public void fireLash(Pokemon attacker, Pokemon recipient) {
        attack("fire lash", 20, attacker, recipient);
    }

    public void flameThrower(Pokemon attacker, Pokemon recipient) {
        attack("flame thrower", 25, attacker, recipient);
    }
}