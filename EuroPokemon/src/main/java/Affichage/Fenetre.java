package Affichage;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame{
	final static String NameMenuPrincipal = "menu_principal"; 
	 
	JPanel cardLayout;
	JPanel menuPrincipale; 
	
	JButton jeu = new JButton("Jouer");
	JButton aide = new JButton("Aide");
	JButton quitter = new JButton("Quitter");
	
	public Fenetre() {
		
		 
		// Initialisation de la page
		this.setTitle("EuroPokemon");
		setSize(750, 500);
	    this.setLayout(new FlowLayout()); 
		//Definition du CardLayout
		cardLayout = new JPanel();
		cardLayout.setLayout(new CardLayout());
		
		
		///////////////////Panel Menu Principal ///////////////
		JPanel menuPrinciaple = new ImagePanel();
		JPanel pan = new JPanel(null); 
		jeu.setBounds(10, 11, 20, 20);
		pan.add(jeu);
		
		//pan.add(aide);
		//pan.add(quitter);
		
		cardLayout.add(NameMenuPrincipal, pan);
		
		////////////////////FIN////////////////////////////////
		setContentPane(menuPrinciaple);
		add(cardLayout); 
		
	    
	    //////////////// Menu Principal ///////////////////
	    
	    //JPanel menuPrincipal = JFrame.setBackgroundImage(this, new File("C:/test.png"));;
	    
	    
	    
	    
	}

}
