package Joueur;

import Pokemon.Pokemon;

public class Joueur {
	private int id; 
	private Pokemon pokemon; 
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public Pokemon getPokemon() {
		return pokemon;
	}
	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
}
