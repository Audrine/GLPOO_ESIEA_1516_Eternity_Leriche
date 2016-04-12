package euro_pokemon.EuroPokemon;

import java.io.IOException;
import java.util.List;

import Pokemon.Pokemon;

public class MainEuroPokemon {

	public static void main(String[] args) {
		try {
			List<Pokemon> list = Pokemon.ImportPokemon();
			Pokemon test = Pokemon.selectPokemon(1, list);
			System.out.println("Le pokemon choisi est "+test.getNom());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
