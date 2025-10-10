package PokemonGame.Creatures;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GrassPokemon extends Pokemon {
    private final static String type = "grass";
    private final static List<String> attacks = Arrays.asList("leafStorm", "solarBeam", "leechSeed", "leaveBlade");
    private final static Map<String, Double> attackMultiplierByType = Map.ofEntries(
            Map.entry("electric", 1.5),
            Map.entry("fire", 1.0),
            Map.entry("grass", .5),
            Map.entry("water", .75)
    );

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

    @Override
    public Double getAttackMultiplier(Pokemon recipient) {
        return attackMultiplierByType.getOrDefault(recipient.getType(), 1.0);
    }

    public void leafStorm(Pokemon attacker, Pokemon recipient) {
        attack("leaf storm", 10, attacker, recipient);
    }

    public void solarBeam(Pokemon attacker, Pokemon recipient) {
        attack("solar beam", 15, attacker, recipient);
    }

    public void leechSeed(Pokemon attacker, Pokemon recipient) {
        int damageDone = attack("leech seed", 20, attacker, recipient);
        attacker.setHp(attacker.getHp() + damageDone);
        System.out.printf("%s leeched %d hp!%n", attacker.getName(), damageDone);
    }

    public void leaveBlade(Pokemon attacker, Pokemon recipient) {
        attack("leave blade", 25, attacker, recipient);
    }
}