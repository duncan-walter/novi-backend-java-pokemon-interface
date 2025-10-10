import PokemonGame.Competitions.PokemonGymImpl;
import PokemonGame.Creatures.*;
import PokemonGame.Characters.PokemonTrainer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Dit zijn de Pokemons die je tot je beschikking hebt
    private static final FirePokemon charizard = new FirePokemon("Charizard", 76, 150, "firenougats", "GRRRRRRRRRRRRRRR");
    private static final WaterPokemon blastoise = new WaterPokemon("Blastoise", 40, 110, "Pokeflakes", "Blaaaaasssssstooooiiiiissss");
    private static final GrassPokemon venusaur = new GrassPokemon("Venusaur", 50, 135, "Pokeleafs", "Veeeeeeeeennnnnuuuuuusaur");
    private static final GrassPokemon ditto = new GrassPokemon("Ditto", 60, 140, "Everything", "Dittto diiiito ");
    private static final ElectricPokemon raichu = new ElectricPokemon("Raichu", 80, 160, "Pokebrocks", "Raaaaiiiiicccchhhhuuuuuuu!!!!");
    private static final WaterPokemon gyarados = new WaterPokemon("Gyarados", 90, 180, "Pokeflakes", "Gyaaaaaaaaarrrraaaadoooos");

    private static final List<Pokemon> pokemons = Arrays.asList(charizard, blastoise, venusaur, ditto, raichu, gyarados);

    public static void main(String[] args) {
        Scanner speler_A = new Scanner(System.in);
        PokemonGymImpl pokemonGym = new PokemonGymImpl(pokemons);

        System.out.println("First player please enter your name: ");
        String userA = speler_A.nextLine();
        PokemonTrainer player1 = new PokemonTrainer(userA, pokemons);

        System.out.println("To start your game, we have given you 6 Pokemons to use");
        System.out.println("these are the Pokemons you get:");
        pokemonGym.printPokemons(pokemons);

        System.out.println("Would you like to enter a gym looking for a fight?");
        System.out.println("Please enter yes or no");

        if (speler_A.nextLine().equals("yes")) {
            pokemonGym.enteredTheGym(player1);
        }
    }
}