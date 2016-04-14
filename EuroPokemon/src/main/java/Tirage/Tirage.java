package Tirage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ReaderCSV.ReaderCsv;

public class Tirage {
	private List<Integer> numeros;
	private List<Integer> complementaire;
	private final static String FILE_EUROMILLION = "resources/csv/euromillions_3.csv";
	
	
	public Tirage() {
		// TODO Auto-generated constructor stub
	}
	public List<Integer> getComplementaire() {
		return complementaire;
	}
	public List<Integer> getNumeros() {
		return numeros;
	}
	public void setComplementaire(List<Integer> complementaire) {
		this.complementaire = complementaire;
	}
	
	public void setNumeros(List<Integer> numeros) {
		this.numeros = numeros;
	}
	public static List<Integer> CreatListNumero(List<Integer> listTirage){
		List<Integer> resultat = new ArrayList<Integer>();
		resultat.add(listTirage.get(0));
		resultat.add(listTirage.get(1));
		resultat.add(listTirage.get(2));
		resultat.add(listTirage.get(3));
		resultat.add(listTirage.get(4));
		return resultat;	
	}
	public static List<Integer> CreatListComplementaire(List<Integer> listTirage){
		List<Integer> resultat = new ArrayList<Integer>();
		resultat.add(listTirage.get(5));
		resultat.add(listTirage.get(6));
		return resultat;	
	}
	public static List<Integer> randTirage() throws IOException{
		/**
		 * Cette classe aura pour but de répurer les 5 numéros et 
		 * les 2 numéros complémentaires au hasard
		 * 
		 */
		 ReaderCsv readerCsv = new ReaderCsv();
		 File csvEuroMillion = ReaderCsv.getResource(FILE_EUROMILLION);  
		 List<String> listTirage = ReaderCsv.readFile(csvEuroMillion); 
				 
		 Random rand = new Random(); 
		 int randLigne = rand.nextInt(228 - 1 + 1) + 2;
		 List<Integer> resultat = new ArrayList<Integer>(); 
		 // On prend un ligne au hasard
		 String ligne = listTirage.get(randLigne);
		 
		 // On découpe le ligne avec le séparateur ";"
		 String[] splitLigne = ligne.split(";"); 
		 
		 for(int i = 4; i < 11; i++){
			 //On récupère les 6 numéros
			 resultat.add(Integer.parseInt(splitLigne[i])); 
		 }
		
		return resultat;
		
	}
}
