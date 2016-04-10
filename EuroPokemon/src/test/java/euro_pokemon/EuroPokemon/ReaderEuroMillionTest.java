package euro_pokemon.EuroPokemon;

import java.io.File;

import ReaderCSV.ReaderEuroMillion;
import junit.framework.TestCase;

public class ReaderEuroMillionTest extends TestCase{
	private final static String FILE_NAME = "resources/csv/euromillions_3.csv";
	
	public void testGetResourceCsvEuroMillion(){
	   final String fileName = FILE_NAME;
	   final File file = ReaderEuroMillion.getResource(fileName);
	   assertTrue(file.exists());
	}

}
