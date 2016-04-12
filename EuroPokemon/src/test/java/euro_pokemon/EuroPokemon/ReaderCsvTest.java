package euro_pokemon.EuroPokemon;

import java.io.File;
import java.io.IOException;
import java.util.List;

import ReaderCSV.ReaderCsv;
import junit.framework.Assert;
import junit.framework.TestCase;

public class ReaderCsvTest extends TestCase{
private final static String FILE_NAME = "resources/csv/euromillions_3.csv";
	
	public void testGetResourceCsv(){
		final String fileName = FILE_NAME;
		File file = ReaderCsv.getResource(fileName);
		assertTrue(file.exists());
	}
	
	public void testReaderCsv() throws IOException{
		final String fileName = FILE_NAME;
		final File file = ReaderCsv.getResource(fileName);
		int nombreDeLigne = 229; 
	    List<String> lines = ReaderCsv.readFile(file);
	    Assert.assertEquals(nombreDeLigne, lines.size());
	}

}
