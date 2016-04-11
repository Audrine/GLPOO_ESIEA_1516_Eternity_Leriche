package euro_pokemon.EuroPokemon;

import java.io.File;
import java.io.IOException;
import java.util.List;

import ReaderCSV.ReaderEuroMillion;
import Tirage.Tirage;
import junit.framework.Assert;
import junit.framework.TestCase;

public class TirageTest extends TestCase{
	private final static String FILE_NAME = "resources/csv/euromillions_3.csv";
	public void testTirage() throws IOException{
		final String fileName = FILE_NAME;
		final File file = ReaderEuroMillion.getResource(fileName);
	    List<String> lines = ReaderEuroMillion.readFile(file);
	    List<Integer> listTirage = ReaderEuroMillion.randTirage(lines);
	    Tirage tirage = new Tirage();
	    tirage.setNumeros(tirage.CreatListNumero(listTirage));
	    tirage.setComplementaire(tirage.CreatListComplementaire(listTirage));
	    Assert.assertEquals(tirage.getNumeros().size(), 5);
	    Assert.assertEquals(tirage.getComplementaire().size(), 2);
	}
	

}
