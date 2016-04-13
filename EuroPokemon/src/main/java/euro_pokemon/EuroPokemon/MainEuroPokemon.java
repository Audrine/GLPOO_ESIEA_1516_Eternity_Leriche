package euro_pokemon.EuroPokemon;

import javax.swing.JFrame;

import Affichage.Fenetre;

public class MainEuroPokemon {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Fenetre fenetre = new Fenetre();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);

	}

}
