package PokemonGame.Creatures;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ElectricPokemon extends Pokemon {
    private final static String type = "electric";
    private final static List<String> attacks = Arrays.asList("thunderPunch", "electroBall", "thunder", "voltTackle");
    private final static Map<String, Double> attackMultiplierByType = Map.ofEntries(
            Map.entry("electric", .5),
            Map.entry("fire", .75),
            Map.entry("grass", 1.0),
            Map.entry("water", 1.5)
    );

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

    @Override
    public Double getAttackMultiplier(Pokemon recipient) {
        return attackMultiplierByType.getOrDefault(recipient.getType(), 1.0);
    }

    public void thunderPunch(Pokemon attacker, Pokemon recipient) {
        attack("thunder punch", 10, attacker, recipient);
    }

    public void electroBall(Pokemon attacker, Pokemon recipient) {
        attack("electro ball", 15, attacker, recipient);
    }

    public void thunder(Pokemon attacker, Pokemon recipient) {
        attack("thunder", 20, attacker, recipient);
    }

    public void voltTackle(Pokemon attacker, Pokemon recipient) {
        attack("volt tackle", 25, attacker, recipient);
    }
}