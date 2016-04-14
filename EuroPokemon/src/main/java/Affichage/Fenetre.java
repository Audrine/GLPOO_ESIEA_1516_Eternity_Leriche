package Affichage;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import Joueur.Joueur;
import Pokemon.Eau;
import Pokemon.Pokemon;
import Tirage.Tirage;

public class Fenetre extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	final static String NameMenuPrincipal = "menu_principal";
	final static String NameMenuAide = "menu_aide";
	final static String NameTirage = "tirage";
	private boolean joueur = false; 
	private Joueur j1 = new Joueur(1);
	private Joueur j2 = new Joueur(2);
	private JPanel cardLayout; 
	private JButton jeu = new JButton("Jouer");
	private JButton aide = new JButton("Aide");
	private JButton quitter = new JButton("Quitter");
	private JButton retourAide = new JButton("Retour");
	private JButton pokemon1 = new JButton();
	private JButton pokemon2 = new JButton(); 
	private JTextArea regle= new JTextArea(5,20);
	private JLabel numeros = new JLabel();
	private JLabel complementaire = new JLabel();

	private JLabel labelValDefense = new JLabel();
	private JLabel labelValAttaque = new JLabel();
	private JLabel labelValEffet = new JLabel();
	
	private JScrollPane scrollPaneRegle = new JScrollPane(regle, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	private JPanel panelAide = new ImagePanel("resources/images/background_1.jpeg");
	private JPanel panelTirage = new ImagePanel("resources/images/background_1.jpeg");
	private JPanel menuPrinciaple = new ImagePanel("resources/images/background.jpeg");
	private JLabel titre = new JLabel(new ImageIcon("resources/images/titre.png"));
	private JLabel imgPokemon1 = new JLabel();
	private JLabel imgPokemon2 = new JLabel();
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
		jeu.addActionListener(new GoTirage1());
		
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
		
		panelTirage.add(labelValAttaque);
		panelTirage.add(labelValDefense);
		panelTirage.add(labelValEffet);
		panelTirage.add(numeros);
		panelTirage.add(complementaire);
		panelTirage.add(pokemon1); 
		panelTirage.add(pokemon2);
		panelTirage.add(imgPokemon1); 
		panelTirage.add(imgPokemon2);
		
		cardLayout.add(NameTirage, panelTirage);
		//////////////// Panel Tirage ////////////////////$*
		
		//////////////////FIN/////////////////////////////
		
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
	public  class   GoTirage1 implements   ActionListener
    {
		
        public  void    actionPerformed(ActionEvent e)
        {
        	SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                	Tirage tirage = new Tirage();
                	Pokemon tmp = new Eau(); 
                	try {
        				List<Integer> listTirage= Tirage.randTirage();
        				tirage.setNumeros(Tirage.CreatListNumero(listTirage));
        				tirage.setComplementaire(Tirage.CreatListComplementaire(listTirage));
        				tmp.setCapacite(tirage);
        				
        				//Affichage du tirage
        				List<String> numerosListString = new ArrayList<String>(tirage.getNumeros().size()); 
        				for (Integer myInt : tirage.getNumeros()) { 
        					numerosListString.add(String.valueOf(myInt)); 
        				}
        				
        				List<String> complementaireListString = new ArrayList<String>(tirage.getComplementaire().size()); 
        				for (Integer myInt : tirage.getComplementaire()) { 
        					complementaireListString.add(String.valueOf(myInt)); 
        				}
        				String numerosString = String.join("  ", numerosListString);
        				String complementaireString = String.join("  ", complementaireListString);
        				
        				numeros.setText("Numeros : "+numerosString);
        				complementaire.setText("Complementaire : "+complementaireString);
        				Insets insets = panelTirage.getInsets(); 
        				Dimension size = numeros.getPreferredSize();
        				numeros.setBounds(250 + insets.left, 380 +insets.top, size.width, size.height);
        				size = complementaire.getPreferredSize();
        				complementaire.setBounds(430 + insets.left, 380 +insets.top, size.width, size.height);
        				
        				//Set des valeurs 
        				labelValAttaque.setText("Att : "+String.valueOf(tmp.getAttaque()));
        				labelValDefense.setText("Def : "+String.valueOf(tmp.getDefense()));
        				labelValEffet.setText("Eff : "+String.valueOf(tmp.getEffet()));
        				
        				//Positionnement des valeur
        				size = labelValAttaque.getPreferredSize();
        				labelValAttaque.setBounds(290 + insets.left, 100 +insets.top, size.width, size.height);
        				size = labelValDefense.getPreferredSize();
        				labelValDefense.setBounds(360 + insets.left, 100 +insets.top, size.width, size.height);
        				size = labelValEffet.getPreferredSize();
        				labelValEffet.setBounds(430 + insets.left, 100 +insets.top, size.width, size.height);
        				
        				
        				List<Pokemon> choix = new ArrayList<Pokemon>(); 
        				choix = Joueur.getPokemons(tirage.getComplementaire(), Pokemon.ImportPokemon());
        				pokemon1.setText(choix.get(0).getNom());
        				pokemon1.setActionCommand(choix.get(0).getNom()); 
        				pokemon1.addActionListener(new GoTirage2(choix.get(0), tirage));
        				pokemon2.setText(choix.get(1).getNom());
        				pokemon2.setActionCommand(choix.get(1).getNom()); 
        				pokemon2.addActionListener(new GoTirage2(choix.get(1), tirage));
        				size = pokemon1.getPreferredSize();
        				pokemon1.setBounds(250 + insets.left, 170 +insets.top, size.width, size.height);
        				size = pokemon2.getPreferredSize();
        				pokemon2.setBounds(430 + insets.left, 170 +insets.top, size.width, size.height);
        				//Affichage Pokemon
        				imgPokemon1.setIcon(new ImageIcon(choix.get(0).getImage()));
        				size = imgPokemon1.getPreferredSize();
        				imgPokemon1.setBounds(250 + insets.left, 230 +insets.top, size.width, size.height);
        				imgPokemon2.setIcon(new ImageIcon(choix.get(1).getImage()));
        				size = imgPokemon2.getPreferredSize();
        				imgPokemon2.setBounds(430 + insets.left, 230 +insets.top, size.width, size.height);
        				((CardLayout) cardLayout.getLayout()).show(cardLayout, NameTirage);
        				Thread.sleep(200);
        			} catch (IOException | InterruptedException e1) {
        				// TODO Auto-generated catch block
        				e1.printStackTrace();
        			}
                }
        	}); 	        	
        }
    }
	public  class   GoTirage2 implements   ActionListener
    {
		private Pokemon pokemon;
		private Tirage tirage;
		public GoTirage2(Pokemon pokemon, Tirage tirage) {
			this.pokemon = pokemon; 
			this.tirage = tirage;
		}
        public  void    actionPerformed(ActionEvent e)
        {
        	if(e.getActionCommand() == pokemon.getNom()){
				pokemon.setCapacite(tirage);
				j2.setPokemon(pokemon);
				System.out.println("Pokemon Joueur 1 : "+pokemon.getNom());
			}
        	SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                	Tirage tirage = new Tirage();
                	Pokemon tmp = new Eau(); 
                	try {
        				List<Integer> listTirage= Tirage.randTirage();
        				tirage.setNumeros(Tirage.CreatListNumero(listTirage));
        				tirage.setComplementaire(Tirage.CreatListComplementaire(listTirage));
        				tmp.setCapacite(tirage);
        				
        				//Affichage du tirage
        				List<String> numerosListString = new ArrayList<String>(tirage.getNumeros().size()); 
        				for (Integer myInt : tirage.getNumeros()) { 
        					numerosListString.add(String.valueOf(myInt)); 
        				}
        				
        				List<String> complementaireListString = new ArrayList<String>(tirage.getComplementaire().size()); 
        				for (Integer myInt : tirage.getComplementaire()) { 
        					complementaireListString.add(String.valueOf(myInt)); 
        				}
        				String numerosString = String.join("  ", numerosListString);
        				String complementaireString = String.join("  ", complementaireListString);
        				
        				numeros.setText("Numeros : "+numerosString);
        				complementaire.setText("Complementaire : "+complementaireString);
        				Insets insets = panelTirage.getInsets(); 
        				Dimension size = numeros.getPreferredSize();
        				numeros.setBounds(250 + insets.left, 380 +insets.top, size.width, size.height);
        				size = complementaire.getPreferredSize();
        				complementaire.setBounds(430 + insets.left, 380 +insets.top, size.width, size.height);
        				
        				//Set des valeurs 
        				labelValAttaque.setText("Att : "+String.valueOf(tmp.getAttaque()));
        				labelValDefense.setText("Def : "+String.valueOf(tmp.getDefense()));
        				labelValEffet.setText("Eff : "+String.valueOf(tmp.getEffet()));
        				
        				//Positionnement des valeur
        				size = labelValAttaque.getPreferredSize();
        				labelValAttaque.setBounds(290 + insets.left, 100 +insets.top, size.width, size.height);
        				size = labelValDefense.getPreferredSize();
        				labelValDefense.setBounds(360 + insets.left, 100 +insets.top, size.width, size.height);
        				size = labelValEffet.getPreferredSize();
        				labelValEffet.setBounds(430 + insets.left, 100 +insets.top, size.width, size.height);
        				List<Pokemon> choix = new ArrayList<Pokemon>(); 
        				choix = Joueur.getPokemons(tirage.getComplementaire(), Pokemon.ImportPokemon());
        				pokemon1.setText(choix.get(0).getNom());
        				pokemon1.setActionCommand(choix.get(0).getNom()); 
        				pokemon1.addActionListener(new GoGame(choix.get(0), tirage));
        				pokemon2.setText(choix.get(1).getNom());
        				pokemon2.setActionCommand(choix.get(1).getNom()); 
        				pokemon2.addActionListener(new GoGame(choix.get(1), tirage));
        				size = pokemon1.getPreferredSize();
        				pokemon1.setBounds(250 + insets.left, 170 +insets.top, size.width, size.height);
        				size = pokemon2.getPreferredSize();
        				pokemon2.setBounds(430 + insets.left, 170 +insets.top, size.width, size.height);
        				//Affichage Pokemon
        				imgPokemon1.setIcon(new ImageIcon(choix.get(0).getImage()));
        				size = imgPokemon1.getPreferredSize();
        				imgPokemon1.setBounds(250 + insets.left, 230 +insets.top, size.width, size.height);
        				imgPokemon2.setIcon(new ImageIcon(choix.get(1).getImage()));
        				size = imgPokemon2.getPreferredSize();
        				imgPokemon2.setBounds(430 + insets.left, 230 +insets.top, size.width, size.height);
        				Thread.sleep(200);
        			} catch (IOException | InterruptedException e1) {
        				// TODO Auto-generated catch block
        				e1.printStackTrace();
        			}
                }
        	}); 	         	
        }
    }
	
	public  class   GoGame implements   ActionListener
    {
		private Pokemon pokemon;
		private Tirage tirage;
		
		public GoGame(Pokemon pokemon, Tirage tirage) {
			this.pokemon = pokemon; 
			this.tirage = tirage;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand() == pokemon.getNom()){
				pokemon.setCapacite(tirage);
				j2.setPokemon(pokemon);
				System.out.println("Pokemon Joueur 2 : "+pokemon.getNom());
			}
			// TODO Auto-generated method stub
			((CardLayout) cardLayout.getLayout()).show(cardLayout, NameMenuPrincipal);
		}
		
    }
	

}
