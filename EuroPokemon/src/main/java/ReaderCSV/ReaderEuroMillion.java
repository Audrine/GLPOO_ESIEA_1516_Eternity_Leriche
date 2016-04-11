package ReaderCSV;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReaderEuroMillion {
	public static String getResourcePath(String fileName){
		final File f = new File("");
	    final String dossierPath = f.getAbsolutePath() + File.separator + fileName;
	    return dossierPath;
	}
	public static File getResource(String fileName) {
			/**
			 * Cette classe permet de récuperer le flux d'un fichier
			 */
	       final String completeFileName = getResourcePath(fileName);
	       File file = new File(completeFileName);
	       return file;
	}
	
	public static List<String> readFile(File file) throws IOException {
		/**
		 * Class permetant de récupérer chaque ligne du fichier csv
		 */
        List<String> result = new ArrayList<String>();
        FileReader fr = null;
		try {
			// lecture du fichier
			fr = new FileReader(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        BufferedReader br = new BufferedReader(fr);// lecture du flux du fichier
        for (String line = br.readLine(); line != null; line = br.readLine()) {
        	// récupération ligne par ligne
            result.add(line);
        }
        try {
        	// fermeture des fichiers 
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return result;
    }
	
	public static List<Integer> randTirage(List<String> listeLigneEuroMillion){
		/**
		 * Cette classe aura pour but de répurer les 5 numéros et 
		 * les 2 numéros complémentaires au hasard
		 * 
		 */
		 Random rand = new Random(); 
		 int randLigne = rand.nextInt(229 - 2 + 1) + 2;
		 List<Integer> resultat = new ArrayList<Integer>(); 
		 // On prend un ligne au hasard
		 String ligne = listeLigneEuroMillion.get(randLigne);
		 
		 // On découpe le ligne avec le séparateur ";"
		 String[] splitLigne = ligne.split(";"); 
		 
		 for(int i = 4; i < 11; i++){
			 //On récupère les 6 numéros
			 resultat.add(Integer.parseInt(splitLigne[i])); 
		 }
		
		return resultat;
		
	}
	
	
}