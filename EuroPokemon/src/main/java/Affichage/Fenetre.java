package Affichage;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
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
	JPanel menuPrinciaple = new ImagePanel();
	
	public Fenetre() {
		
		 
		// Initialisation de la page
		this.setTitle("EuroPokemon");
		setSize(750, 500);
		//Definition du CardLayout
		cardLayout = new JPanel();
		cardLayout.setLayout(new CardLayout());
		
		
		///////////////////Panel Menu Principal ///////////////
		menuPrinciaple.add(jeu); 
		Insets insets = menuPrinciaple.getInsets();
		Dimension size = jeu.getPreferredSize();
		jeu.setBounds(50 + insets.left, 11 +insets.top, size.width, size.height);
		
		
		cardLayout.add(NameMenuPrincipal, menuPrinciaple);
		////////////////////FIN////////////////////////////////
		add(cardLayout); 
		
	    
	    //////////////// Menu Principal ///////////////////
	    
	    //JPanel menuPrincipal = JFrame.setBackgroundImage(this, new File("C:/test.png"));;
	    
	    
	    
	    
	}

}
