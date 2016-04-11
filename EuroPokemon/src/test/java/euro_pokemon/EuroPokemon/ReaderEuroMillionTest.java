package euro_pokemon.EuroPokemon;

import java.io.File;
import java.io.IOException;
import java.util.List;

import ReaderCSV.ReaderEuroMillion;
import junit.framework.Assert;
import junit.framework.TestCase;

public class ReaderEuroMillionTest extends TestCase{
	private final static String FILE_NAME = "resources/csv/euromillions_3.csv";
	
	public void testGetResourceCsvEuroMillion(){
		final String fileName = FILE_NAME;
		File file = ReaderEuroMillion.getResource(fileName);
		assertTrue(file.exists());
	}
	
	public void testReaderCsvEuroMillion() throws IOException{
		final String fileName = FILE_NAME;
		final File file = ReaderEuroMillion.getResource(fileName);
		int nombreDeLigne = 228; 
	    List<String> lines = ReaderEuroMillion.readFile(file);
	    Assert.assertEquals(nombreDeLigne, lines.size());
	}
	
	public void testrandTirage() throws IOException{
		final String fileName = FILE_NAME;
		final File file = ReaderEuroMillion.getResource(fileName);
	    List<String> lines = ReaderEuroMillion.readFile(file);
	    List<Integer> tirage = ReaderEuroMillion.randTirage(lines);
	    assertTrue(!(tirage.isEmpty()));
	}
	
	

}
