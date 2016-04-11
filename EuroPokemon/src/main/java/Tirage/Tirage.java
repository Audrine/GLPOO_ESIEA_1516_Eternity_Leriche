package Tirage;

import java.util.ArrayList;
import java.util.List;

public class Tirage {
	private List<Integer> numeros;
	private List<Integer> complementaire;
	
	
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
	public List<Integer> CreatListNumero(List<Integer> listTirage){
		List<Integer> resultat = new ArrayList<Integer>();
		resultat.add(listTirage.get(0));
		resultat.add(listTirage.get(1));
		resultat.add(listTirage.get(2));
		resultat.add(listTirage.get(3));
		resultat.add(listTirage.get(4));
		return resultat;	
	}
	public List<Integer> CreatListComplementaire(List<Integer> listTirage){
		List<Integer> resultat = new ArrayList<Integer>();
		resultat.add(listTirage.get(5));
		resultat.add(listTirage.get(6));
		return resultat;	
	}
}
