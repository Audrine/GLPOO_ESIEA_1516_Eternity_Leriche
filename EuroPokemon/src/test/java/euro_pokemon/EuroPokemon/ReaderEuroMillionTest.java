package euro_pokemon.EuroPokemon;

import java.io.File;

import ReaderCSV.ReaderEuroMillion;
import junit.framework.TestCase;

public class ReaderEuroMillionTest extends TestCase{
	private final static String FILE_NAME = "src/test/resources/csv/euromillions_3.csv";
	
	public void testGetResourceCsvEuroMillion(){
		// Param
	    final String fileName = FILE_NAME;

	    // Result
	    // ...

	    // Appel
	    final File file = ReaderEuroMillion.getResource(fileName);

	    // Test
	    // On sait que le fichier existe bien puisque c'est avec lui qu'on travaille depuis le début.
	    assertTrue(file.exists());
		
	}

}
