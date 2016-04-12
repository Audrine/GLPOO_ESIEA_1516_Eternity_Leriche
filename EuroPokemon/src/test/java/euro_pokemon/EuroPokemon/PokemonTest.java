package euro_pokemon.EuroPokemon;

import java.io.IOException;
import java.util.List;

import Pokemon.Pokemon;
import junit.framework.TestCase;

public class PokemonTest extends TestCase{
	
	public void testImportPokemon() throws IOException{
		List<Pokemon> list = Pokemon.ImportPokemon();
		assertEquals(list.size(), 11);
	}
	public void testSelectPokemon() throws IOException{
		List<Pokemon> list = Pokemon.ImportPokemon();
		Pokemon test = Pokemon.selectPokemon(2, list);
		assertNotNull(test);
	}

}
