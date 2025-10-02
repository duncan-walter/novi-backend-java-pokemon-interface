package PokemonGame.Creatures;

import java.util.List;

public abstract class Pokemon {
    private final String name;
    private final int level;
    private final String food;
    private final String sound;
    private int hp;

    public Pokemon(String name, int level, int hp, String food, String sound) {
        this.name = name;
        this.level = level;
        this.food = food;
        this.sound = sound;
        setHp(hp);
    }

    public abstract String getType();
    public abstract List<String> getAttacks();
    public abstract Double getAttackMultiplier(Pokemon recipient);

    public String getName() {
        return this.name;
    }

    public int getHp() {
        return this.hp;
    }

    public int getLevel() {
        return this.level;
    }

    public String getFood() {
        return this.food;
    }

    public String getSound() {
        return this.sound;
    }

    public void setHp(int hp) {
        this.hp = Math.max(hp, 0);
    }

    public int attack(String name, int baseDamage, Pokemon attacker, Pokemon recipient) {
        System.out.printf("%s attacks %s with %s!%n", attacker.getName(), recipient.getName(), name);
        int damage = (int)(getAttackMultiplier(recipient) * baseDamage);
        recipient.setHp(recipient.getHp() - damage);
        System.out.printf("%s loses %d hp!%n", recipient.getName(), damage);
        System.out.printf("%s now has %d hp!%n", recipient.getName(), recipient.getHp());
        return damage;
    }
}