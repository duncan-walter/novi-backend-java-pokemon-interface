package PokemonGame.Competitions;

import PokemonGame.Creatures.*;
import PokemonGame.Characters.*;
import PokemonGame.TerminalCodes;

import java.util.*;

public class PokemonGymImpl implements PokemonGym {
    List<Pokemon> pokemons;

    public PokemonGymImpl(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public void enteredTheGym(PokemonTrainer pokemonTrainer) {
        PokemonGymOwner gymOwner = new PokemonGymOwner("Brock", "Pewter City", pokemons);
        System.out.println("You have entered the " + gymOwner.getTown() + " gym");
        System.out.println("In front of you stands a Pokémon-trainer");
        System.out.println(TerminalCodes.ANSI_RED + gymOwner.getName() + TerminalCodes.ANSI_RESET +": Hello stranger, I'm " + gymOwner.getName() + ", the owner of this gym. Who are you?");
        System.out.println(TerminalCodes.ANSI_GREEN + pokemonTrainer.getName() + TerminalCodes.ANSI_RESET + ": I'm " + pokemonTrainer.getName() + " and i'm here to challenge you for a battle");
        System.out.println(TerminalCodes.ANSI_RED + gymOwner.getName() + TerminalCodes.ANSI_RESET +": So you're after my badge too, lets fight!!!");

        Pokemon gymPokemon = chooseGymPokemon(gymOwner);
        System.out.println(TerminalCodes.ANSI_RED + gymOwner.getName() + TerminalCodes.ANSI_RESET +": I'll choose you, " + gymPokemon.getName());
        Pokemon pokemon = choosePokemon(pokemonTrainer);
        System.out.println(TerminalCodes.ANSI_GREEN + pokemonTrainer.getName() + TerminalCodes.ANSI_RESET + ": I'll choose you, " + pokemon.getName());

        fightRound(pokemonTrainer, gymOwner, pokemon, gymPokemon);

    }

    @Override
    public void printPokemons(List<Pokemon> pokemons) {
        for (Pokemon p : pokemons) {
            System.out.println(p.getName());
        }
    }

    @Override
    public Pokemon selectPokemon(String pokemon, PokemonTrainer trainer) {
        List<Pokemon> pokemons = trainer.getPokemons();
        int number = 0;
        for (int i = 0; i < pokemons.size(); i++) {
            if (pokemons.get(i).getName().equalsIgnoreCase(pokemon)) {
                number = i;
            }
        }
        return pokemons.get(number);
    }

    @Override
    public void fightRound(PokemonTrainer trainer, PokemonGymOwner owner, Pokemon pokemon, Pokemon gymPokemon) {
        Scanner speler_A = new Scanner(System.in);
        while (pokemon.getHp() > 0 && gymPokemon.getHp() > 0) {

            System.out.println("Its " + owner.getName() + "'s turn to attack");
            gymOwnerAttacks(gymPokemon, pokemon);
            System.out.println("Its " + trainer.getName() + "'s turn to attack");
            performPlayerAction(pokemon, gymPokemon, trainer, owner);

        }
        if(pokemon.getHp() <= 0){
            System.out.println(gymPokemon.getName() + " has defeated " + pokemon.getName());
        } else if (gymPokemon.getHp() <= 0){
            System.out.println(pokemon.getName() + " has defeated " + gymPokemon.getName());
        }

        System.out.println("Would you like to keep playing? yes or no");
        String keepPlaying = speler_A.nextLine();
        if (keepPlaying.equals("yes")){
            enteredTheGym(trainer);
        } else {
            System.out.println("Thank you for playing");
        }
    }

    @Override
    public Pokemon chooseGymPokemon(PokemonGymOwner gymOwner) {
        Random rand = new Random();
        List<Pokemon> pokemons = new ArrayList<>();
        for (Pokemon p : gymOwner.getPokemons()) {
            if(p.getHp() > 0 ){
                pokemons.add(p);
            }
        }
        int amountOfPokemons = pokemons.size();
        int randomNumber = rand.nextInt(amountOfPokemons);
        return pokemons.get(randomNumber);
    }

    @Override
    public Pokemon choosePokemon(PokemonTrainer trainer) {
        Scanner speler_A = new Scanner(System.in);
        List<Pokemon> pokemons = new ArrayList<>();
        for (Pokemon p : trainer.getPokemons()) {
            if(p.getHp() > 0 ){
                pokemons.add(p);
            }
        }
        System.out.println("Please make your choice of pokemon to attack");
        for (Pokemon p : pokemons) {
            System.out.println(p.getName());
        }
        String pokemon = speler_A.nextLine();
        return selectPokemon(pokemon, trainer);
    }

    @Override
    public int randomAttackByGymOwner() {
        Random rand = new Random();
        int maxAttacks = 4;
        return rand.nextInt(maxAttacks);
    }

    @Override
    public String chooseAttackPlayer(Pokemon p) {
        Scanner speler_A = new Scanner(System.in);
        String type = p.getType();
        switch (type) {
            case "fire" -> {
                FirePokemon fp = (FirePokemon) p;
                System.out.println("Choose your attack");
                System.out.println(fp.getAttacks());
                return speler_A.nextLine();
            }
            case "water" -> {
                WaterPokemon wp = (WaterPokemon) p;
                System.out.println("Choose your attack");
                System.out.println(wp.getAttacks());
                return speler_A.nextLine();
            }
            case "electric" -> {
                ElectricPokemon ep = (ElectricPokemon) p;
                System.out.println("Choose your attack");
                System.out.println(ep.getAttacks());
                return speler_A.nextLine();
            }
            default -> {
                GrassPokemon gp = (GrassPokemon) p;
                System.out.println("Choose your attack");
                System.out.println(gp.getAttacks());
                return speler_A.nextLine();
            }
        }
    }

    @Override
    public void performAttackPlayer(Pokemon pokemon, Pokemon gymPokemon, String attack) {
        FirePokemon fire;
        ElectricPokemon electric;
        GrassPokemon grass;
        WaterPokemon water;

        String chosenAttack = attack.toLowerCase(Locale.ROOT);

        switch (pokemon.getType()) {
            case "fire" -> {
                fire = new FirePokemon(pokemon.getName(), pokemon.getLevel(), pokemon.getHp(), pokemon.getFood(), pokemon.getSound());
                switch (chosenAttack) {
                    case "inferno" -> fire.inferno(pokemon, gymPokemon);
                    case "pyroball" -> fire.pyroBall(pokemon, gymPokemon);
                    case "firelash" -> fire.fireLash(pokemon, gymPokemon);
                    default -> fire.flameThrower(pokemon, gymPokemon);
                }
            }
            case "water" -> {
                water = new WaterPokemon(pokemon.getName(), pokemon.getLevel(), pokemon.getHp(), pokemon.getFood(), pokemon.getSound());
                switch (chosenAttack) {
                    case "surf" -> water.surf(pokemon, gymPokemon);
                    case "hydropump" -> water.hydroPump(pokemon, gymPokemon);
                    case "hydrocanon" -> water.hydroCanon(pokemon, gymPokemon);
                    default -> water.rainDance(pokemon, gymPokemon);
                }
            }
            case "grass" -> {
                grass = new GrassPokemon(pokemon.getName(), pokemon.getLevel(), pokemon.getHp(), pokemon.getFood(), pokemon.getSound());
                switch (chosenAttack) {
                    case "leafstorm" -> grass.leafStorm(pokemon, gymPokemon);
                    case "solarbeam" -> grass.solarBeam(pokemon, gymPokemon);
                    case "leechseed" -> grass.leechSeed(pokemon, gymPokemon);
                    default -> grass.leaveBlade(pokemon, gymPokemon);
                }
            }
            default -> {
                electric = new ElectricPokemon(pokemon.getName(), pokemon.getLevel(), pokemon.getHp(), pokemon.getFood(), pokemon.getSound());
                switch (chosenAttack) {
                    case "thunderpunch" -> electric.thunderPunch(pokemon, gymPokemon);
                    case "electroball" -> electric.electroBall(pokemon, gymPokemon);
                    case "thunder" -> electric.thunder(pokemon, gymPokemon);
                    default -> electric.voltTackle(pokemon, gymPokemon);
                }
            }
        }
    }

    @Override
    public void gymOwnerAttacks(Pokemon gymPokemon, Pokemon pokemon) {
        FirePokemon fire;
        ElectricPokemon electric;
        GrassPokemon grass;
        WaterPokemon water;

        switch (gymPokemon.getType()) {
            case "fire" -> {
                fire = new FirePokemon(gymPokemon.getName(), gymPokemon.getLevel(), gymPokemon.getHp(), gymPokemon.getFood(), gymPokemon.getSound());
                String attack = fire.getAttacks().get(randomAttackByGymOwner());
                switch (attack) {
                    case "inferno" -> fire.inferno(gymPokemon, pokemon);
                    case "pyroBall" -> fire.pyroBall(gymPokemon, pokemon);
                    case "fireLash" -> fire.fireLash(gymPokemon, pokemon);
                    default -> fire.flameThrower(gymPokemon, pokemon);
                }
            }
            case "water" -> {
                water = new WaterPokemon(gymPokemon.getName(), gymPokemon.getLevel(), gymPokemon.getHp(), gymPokemon.getFood(), gymPokemon.getSound());
                String attack = water.getAttacks().get(randomAttackByGymOwner());
                switch (attack) {
                    case "surf" -> water.surf(gymPokemon, pokemon);
                    case "hydroPump" -> water.hydroPump(gymPokemon, pokemon);
                    case "hydroCanon" -> water.hydroCanon(gymPokemon, pokemon);
                    default -> water.rainDance(gymPokemon, pokemon);
                }
            }
            case "grass" -> {
                grass = new GrassPokemon(gymPokemon.getName(), gymPokemon.getLevel(), gymPokemon.getHp(), gymPokemon.getFood(), gymPokemon.getSound());
                String attack = grass.getAttacks().get(randomAttackByGymOwner());
                switch (attack) {
                    case "leafStorm" -> grass.leafStorm(gymPokemon, pokemon);
                    case "solarBeam" -> grass.solarBeam(gymPokemon, pokemon);
                    case "leechSeed" -> grass.leechSeed(gymPokemon, pokemon);
                    default -> grass.leaveBlade(gymPokemon, pokemon);
                }
            }
            default -> {
                electric = new ElectricPokemon(gymPokemon.getName(), gymPokemon.getLevel(), gymPokemon.getHp(), gymPokemon.getFood(), gymPokemon.getSound());
                String attack = electric.getAttacks().get(randomAttackByGymOwner());
                switch (attack) {
                    case "thunderPunch" -> electric.thunderPunch(gymPokemon, pokemon);
                    case "electroBall" -> electric.electroBall(gymPokemon, pokemon);
                    case "thunder" -> electric.thunder(gymPokemon, pokemon);
                    default -> electric.voltTackle(gymPokemon, pokemon);
                }
            }
        }
    }

    @Override
    public void performPlayerAction(Pokemon pokemon, Pokemon gymPokemon, PokemonTrainer trainer, PokemonGymOwner gym) {
        Scanner speler_A = new Scanner(System.in);

        System.out.println("Do you want to attack, change or feed your pokemon?");
        System.out.println("Type \"a\" for attack or \"c\" for change and \"f\" for feed.");
        String choice = speler_A.nextLine();

        switch (choice.toLowerCase()) {
            case "a":
            case "attack":
                String attack = chooseAttackPlayer(pokemon);
                performAttackPlayer(pokemon, gymPokemon, attack);
                break;
            case "c":
            case "change":
                pokemon = choosePokemon(trainer);
                performPlayerAction(pokemon, gymPokemon, trainer, gym);
                fightRound(trainer, gym, pokemon, gymPokemon);
                break;
            case "f":
            case "feed":
                System.out.printf("Please typ %s's favorite food:%n", pokemon.getName());
                pokemon.feed(speler_A.nextLine());
                break;
            default:
                System.out.printf("%s is not a valid choice! Please select a valid choice.%n", choice);
                performPlayerAction(pokemon, gymPokemon, trainer, gym);
        }
    }
}