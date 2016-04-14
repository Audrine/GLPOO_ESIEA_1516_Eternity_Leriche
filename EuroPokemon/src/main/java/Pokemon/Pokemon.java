package Pokemon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ReaderCSV.ReaderCsv;
import Tirage.Tirage;


public abstract class  Pokemon {
	private int id;
	private int attaque;
	private int defense;
	private int effet;
	private String nom; 
	private String type; 
	private String image; 
	private final static String CSV_POKEMON = "resources/csv/pokemon.csv";
	
	
	public Pokemon() {
		// TODO Auto-generated constructor stub
	}
	
	public Pokemon(int id, String nom, String type, String image) {
		this.id = id; 
		this.nom = nom; 
		this.type = type; 
		this.image = image; 
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAttaque() {
		return attaque;
	}
	
	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	public int getEffet() {
		return effet;
	}
	
	public void setEffet(int effet) {
		this.effet = effet;
	}
	public String getImage() {
		return image;
	}
	public String getNom() {
		return nom;
	}
	public String getType() {
		return type;
	}
	public abstract void effet(); 
	
	public void attaquer(Pokemon pokemon1){
		pokemon1.setDefense(pokemon1.getDefense()-this.getAttaque());	
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public void setCapacite(Tirage tirage){
		List<Integer> numeros = tirage.getNumeros();	
		this.setDefense(numeros.get(0)+numeros.get(1));
		this.setAttaque(numeros.get(2)+numeros.get(3));
		this.setEffet(numeros.get(4));	
	}
	public static List<Pokemon> ImportPokemon() throws IOException{
		List<Pokemon> resultat = new ArrayList<Pokemon>();
		List<String> listCsvPokemon= ReaderCsv.readFile(ReaderCsv.getResource(CSV_POKEMON));
		
		while(listCsvPokemon.size() != 1){
			String[] line = listCsvPokemon.get(1).split(";");
			Type tmp1 = Type.valueOf(line[2]); 
			switch(tmp1){
				case ELECTRIK:
					resultat.add(new Electrik(Integer.parseInt(line[0]), line[1], line[2], line[3])); 
					break;
				case EAU:
					resultat.add(new Eau(Integer.parseInt(line[0]), line[1], line[2], line[3])); 
					break;
				case FEU:
					resultat.add(new Feu(Integer.parseInt(line[0]), line[1], line[2], line[3])); 
					break;
				case GLACE:
					resultat.add(new Glace(Integer.parseInt(line[0]), line[1], line[2], line[3])); 
					break;
			}
			listCsvPokemon.remove(1); 
		}
		
		return resultat; 
		
	}
	public static Pokemon selectPokemon(int id, List<Pokemon> listPokemon){
		return listPokemon.get(id-1); 
	}
	public enum Type {

		ELECTRIK,
		EAU,
		FEU,
	    GLACE
	  }
}


