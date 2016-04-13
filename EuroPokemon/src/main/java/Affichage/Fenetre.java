package Affichage;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Fenetre extends JFrame{
	final static String NameMenuPrincipal = "menu_principal"; 
	
	JPanel cardLayout;
	JPanel menuPrincipale; 
	
	JButton jeu = new JButton("Jouer");
	JButton aide = new JButton("Aide");
	JButton quitter = new JButton("Quitter");
	JPanel menuPrinciaple = new ImagePanel();
	JLabel titre = new JLabel(new ImageIcon("resources/images/titre.png"));
	public Fenetre() {
		
		 
		// Initialisation de la page
		this.setTitle("EuroPokemon");
		setSize(750, 500);
		setResizable(false);
		//Definition du CardLayout
		cardLayout = new JPanel();
		cardLayout.setLayout(new CardLayout());
		
		
		///////////////////Panel Menu Principal ///////////////
		menuPrinciaple.add(jeu);
		menuPrinciaple.add(aide);
		menuPrinciaple.add(quitter);
		titre.setOpaque(false);
		titre.setFont(new Font("Serif", Font.BOLD, 25));
		menuPrinciaple.add(titre);
		Insets insets = menuPrinciaple.getInsets();
		
		//Boutton jeu 
		Dimension size = jeu.getPreferredSize();
		jeu.setBounds(300 + insets.left, 250 +insets.top, size.width, size.height);
		jeu.setBackground(Color.WHITE);
		jeu.setSize(150, 25);
		
		
		//Boutton aide 
		size = aide.getPreferredSize();
		aide.setBounds(300 + insets.left, 280 +insets.top, size.width, size.height);
		aide.setBackground(Color.WHITE);
		aide.setSize(150, 25);
		//Boutton aide 
		size = quitter.getPreferredSize();
		quitter.setBounds(300 + insets.left, 310 +insets.top, size.width, size.height);
		quitter.setBackground(Color.WHITE);
		quitter.setSize(150, 25);
		
		size = titre.getPreferredSize();
		titre.setBounds(85 + insets.left, 60 +insets.top, size.width, size.height);
		cardLayout.add(NameMenuPrincipal, menuPrinciaple);
		////////////////////FIN////////////////////////////////
		
		////////////////Panel Aide ///////////////////
		add(cardLayout); 
		
	    
	    
	    
	    
	    
	    
	    
	    
	}

}
