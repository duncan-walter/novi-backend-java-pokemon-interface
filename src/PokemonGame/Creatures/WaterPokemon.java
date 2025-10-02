package PokemonGame.Creatures;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class WaterPokemon extends Pokemon {
    private final static String type = "water";
    private final static List<String> attacks = Arrays.asList("surf", "hydroPump", "hydroCanon", "rainDance");
    private final static Map<String, Double> attackMultiplierByType = Map.ofEntries(
            Map.entry("electric", 1.0),
            Map.entry("fire", 1.5),
            Map.entry("grass", .75),
            Map.entry("water", .5)
    );

    public WaterPokemon(String name, int level, int hp, String food, String sound) {
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

    public void surf(Pokemon attacker, Pokemon recipient) {
        attack("surf", 10, attacker, recipient);
    }

    public void hydroPump(Pokemon attacker, Pokemon recipient) {
        attack("hydro pump", 15, attacker, recipient);
    }

    public void hydroCanon(Pokemon attacker, Pokemon recipient) {
        attack("hydro canon", 20, attacker, recipient);
    }

    public void rainDance(Pokemon attacker, Pokemon recipient) {
        switch (recipient.getType()) {
            case "electric":
                System.out.printf("Rain dance has no effect on %s%n", recipient.getName());
                return;
            case "grass":
                System.out.printf("Rain dance healed %s for 25 hp!%n", recipient.getName());
                recipient.setHp(recipient.getHp() + 25);
                return;
        }

        attack("rain dance", 25, attacker, recipient);
    }
}