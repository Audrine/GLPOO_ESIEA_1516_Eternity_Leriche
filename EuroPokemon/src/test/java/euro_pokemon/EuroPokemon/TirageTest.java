package euro_pokemon.EuroPokemon;

import java.io.File;
import java.io.IOException;
import java.util.List;

import Tirage.Tirage;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TirageTest extends TestCase{
	
	public void testrandTirage() throws IOException{
	    List<Integer> tirage = Tirage.randTirage();
	    assertTrue(!(tirage.isEmpty()));
	}
	public void testTirage() throws IOException{

	    Tirage tirage = new Tirage();
	    tirage.setNumeros(Tirage.CreatListNumero(Tirage.randTirage())); 
	    tirage.setComplementaire(tirage.CreatListComplementaire(Tirage.randTirage()));
	    Assert.assertEquals(tirage.getNumeros().size(), 5);
	    Assert.assertEquals(tirage.getComplementaire().size(), 2);
	}
	

}
