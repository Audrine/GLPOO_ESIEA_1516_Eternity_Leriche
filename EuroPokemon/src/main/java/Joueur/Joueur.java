package Joueur;

import java.util.ArrayList;
import java.util.List;

import Pokemon.Pokemon;

public class Joueur {
	private int id; 
	private Pokemon pokemon;
	private int nbrManche; 
	
	public Joueur(int id) {
		this.id = id; 
	}
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
	public int getNbrManche() {
		return nbrManche;
	}
	public void setNbrManche(int nbrManche) {
		this.nbrManche = nbrManche;
	}
	public static List<Pokemon> getPokemons(List<Integer> complementaires, List<Pokemon> listPokemons){
		List<Pokemon> resultat = new ArrayList<Pokemon>();
		resultat.add(Pokemon.selectPokemon(complementaires.get(0), listPokemons)); 
		resultat.add(Pokemon.selectPokemon(complementaires.get(1), listPokemons));
		return resultat;
		
	}
}
