package Pokemon;

import java.util.List;

import Tirage.Tirage;

public abstract class  Pokemon {
	int id;
	int attaque;
	int defense;
	int effet;
	String nom; 
	String type; 
	String image; 
	
	
	public Pokemon() {
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
	
	abstract void effet(); 
	
	public void attaquer(Pokemon pokemon){
		pokemon.setDefense(pokemon.getDefense()-this.getAttaque());	
	}
	
	public void setCapacite(Tirage tirage){
		List<Integer> numeros = tirage.getNumeros();	
		this.setDefense(numeros.get(0)+numeros.get(1));
		this.setAttaque(numeros.get(2)+numeros.get(3));
		this.setEffet(numeros.get(4));	
	}
}


