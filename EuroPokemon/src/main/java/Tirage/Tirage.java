package Tirage;

import java.util.ArrayList;

public class Tirage {
	ArrayList<Integer> numeros;
	ArrayList<Integer> complementaire;
	
	public Tirage() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Integer> getComplementaire() {
		return complementaire;
	}
	public ArrayList<Integer> getNumeros() {
		return numeros;
	}
	public void setComplémentaire(ArrayList<Integer> complémentaire) {
		this.complementaire = complementaire;
	}
	public void setNumeros(ArrayList<Integer> numeros) {
		this.numeros = numeros;
	}
}
