package Affichage;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Fenetre extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	final static String NameMenuPrincipal = "menu_principal";
	final static String NameMenuAide = "menu_aide";
	
	JPanel cardLayout; 
	JButton jeu = new JButton("Jouer");
	JButton aide = new JButton("Aide");
	JButton quitter = new JButton("Quitter");
	JButton retourAide = new JButton("Retour");
	JTextArea regle= new JTextArea(5,20);
	JScrollPane scrollPaneRegle = new JScrollPane(regle, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	JPanel panelAide = new ImagePanel("resources/images/background_aide.jpeg");
	JPanel menuPrinciaple = new ImagePanel("resources/images/background.jpeg");
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
		aide.addActionListener(new GoAide()); 
		//Boutton aide 
		size = scrollPaneRegle.getPreferredSize();
		quitter.setBounds(300 + insets.left, 310 +insets.top, size.width, size.height);
		quitter.setBackground(Color.WHITE);
		quitter.setSize(150, 25);
		
		size = titre.getPreferredSize();
		titre.setBounds(85 + insets.left, 60 +insets.top, size.width, size.height);
		cardLayout.add(NameMenuPrincipal, menuPrinciaple);
		////////////////////FIN////////////////////////////////
		
		////////////////Panel Aide ///////////////////
		
		regle.setEditable(false);
		panelAide.add(retourAide); 
		panelAide.add(scrollPaneRegle);
		size = retourAide.getPreferredSize();
		retourAide.setBounds(300 + insets.left, 400 +insets.top, size.width, size.height);
		retourAide.setSize(150, 25);
		retourAide.addActionListener(new GoMenuPrincipale());
		size = scrollPaneRegle.getPreferredSize();
		scrollPaneRegle.setBounds(125 + insets.left, 60 +insets.top, size.width, size.height);
		scrollPaneRegle.setSize(500, 300);
		cardLayout.add(NameMenuAide, panelAide);
		///////////////FIN //////////////////////////
		
		add(cardLayout);   
	}
	public  class   GoAide implements   ActionListener
    {
        public  void    actionPerformed(ActionEvent e)
        {
        	((CardLayout) cardLayout.getLayout()).show(cardLayout, NameMenuAide);
        }
    }
	public  class   GoMenuPrincipale implements   ActionListener
    {
        public  void    actionPerformed(ActionEvent e)
        {
        	((CardLayout) cardLayout.getLayout()).show(cardLayout, NameMenuPrincipal);
        }
    }

}
