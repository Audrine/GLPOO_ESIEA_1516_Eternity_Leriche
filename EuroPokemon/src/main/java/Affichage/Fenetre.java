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

import javax.swing.DefaultBoundedRangeModel;
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
	final static String NameEntreJeu = "entre_jeu"; 
	final static String Game = "game";
	final static String Vainqueur = "game"; 
	private boolean joueur = false; 
	final private Joueur j1 = new Joueur(1);
	final private Joueur j2 = new Joueur(2);
	private JPanel cardLayout; 
	private JButton jeu = new JButton("Jouer");
	private JButton aide = new JButton("Aide");
	private JButton quitter = new JButton("Quitter");
	private JButton retourAide = new JButton("Retour");
	private JButton pokemon1 = new JButton();
	private JButton pokemon2 = new JButton();
	private JButton commencer = new JButton("Commencer"); 
	private JTextArea regle= new JTextArea(5,20);
	private JLabel numeros = new JLabel();
	private JLabel complementaire = new JLabel();
	private JLabel titreTour = new JLabel(); 
	private JLabel defJ1 = new JLabel(); 
	private JLabel attJ1 = new JLabel(); 
	private JLabel effJ1 = new JLabel(); 
	private JLabel manJ1 = new JLabel(); 
	private JLabel imgJ1 = new JLabel();
	private JLabel titreJ1 = new JLabel("Joueur 1");
	private JLabel defJ2 = new JLabel(); 
	private JLabel attJ2 = new JLabel(); 
	private JLabel effJ2 = new JLabel();
	private JLabel manJ2 = new JLabel();
	private JLabel imgJ2 = new JLabel();
	private JLabel titreJ2 = new JLabel("Joueur 2");
	
	private JButton attaquer = new JButton("Attaquer"); 
	private JButton passer = new JButton("Passer");; 
	private JButton effet = new JButton("Effet");; 
	
	private JLabel labelValDefense = new JLabel();
	private JLabel labelValAttaque = new JLabel();
	private JLabel labelValEffet = new JLabel();
	private JLabel affichageVainqueur = new JLabel();
	private JScrollPane scrollPaneRegle = new JScrollPane(regle, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	private JPanel panelAide = new ImagePanel("resources/images/background_1.jpeg");
	private JPanel panelTirage = new ImagePanel("resources/images/background_1.jpeg");
	private JPanel game = new ImagePanel("resources/images/background_1.jpeg");
	private JPanel entreJeu = new ImagePanel("resources/images/background.jpeg");
	private JPanel menuPrinciaple = new ImagePanel("resources/images/background.jpeg");
	private JPanel vainqueur = new ImagePanel("resources/images/background.jpeg");
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
		
		//////////////// Panel Tirage ////////////////////$*
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
		//////////////////FIN/////////////////////////////
		
		////////////////Game//////////////////////
		entreJeu.add(commencer);
		commencer.addActionListener(new Game());
		commencer.setActionCommand("Debut");
		size = commencer.getPreferredSize();
		commencer.setBounds(320 + insets.left, 250 +insets.top, size.width, size.height);
		
		cardLayout.add(NameEntreJeu, entreJeu);
		/////////////////FIN//////////////////////
		
		///////////// Real Game ////////////////////
		game.add(attJ1); 
		game.add(defJ1); 
		game.add(effJ1); 
		game.add(manJ1);
		game.add(imgJ1);
		titreJ1.setBackground(Color.GRAY);
		game.add(titreJ1);
		game.add(titreTour);
		size = titreJ1.getPreferredSize();
		titreJ1.setBounds(100 + insets.left, 120 +insets.top, size.width, size.height);
		
		game.add(attJ2); 
		game.add(defJ2); 
		game.add(effJ2); 
		game.add(manJ2);
		titreJ1.setBackground(Color.GRAY);
		game.add(imgJ2);
		game.add(titreJ2);
		size = titreJ2.getPreferredSize();
		titreJ2.setBounds(520 + insets.left, 120 +insets.top, size.width, size.height);
		
		
		game.add(attaquer);
		attaquer.setActionCommand("Attaquer");
		attaquer.addActionListener(new Game());
		size = attaquer.getPreferredSize();
		attaquer.setBounds(300 + insets.left, 120 +insets.top, size.width, size.height);
		game.add(passer);
		passer.setActionCommand("Passer");
		passer.addActionListener(new Game());
		size = passer.getPreferredSize();
		passer.setBounds(300 + insets.left, 160 +insets.top, size.width, size.height);
		game.add(effet);
		effet.setActionCommand("Effet");
		effet.addActionListener(new Game());
		size = effet.getPreferredSize();
		effet.setBounds(300 + insets.left, 190 +insets.top, size.width, size.height);
		
		game.add(affichageVainqueur); 
		;
		cardLayout.add(Game, game);
		///////////////////////////////////////////
		
		
		////////////////Vainqueur////////////////
		
		
		////////////////////////////////////////
		
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
        			} catch (IOException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
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
				j1.setPokemon(pokemon);
				j1.setNbrManche(0);
				System.out.println("Pokemon Joueur 1 : "+j1.getPokemon().getNom());
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

        			} catch (IOException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
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
				j2.setNbrManche(0);
				System.out.println("Pokemon Joueur 2 : "+pokemon.getNom());
			}
			// TODO Auto-generated method stub
			((CardLayout) cardLayout.getLayout()).show(cardLayout, NameEntreJeu);
		}
		
    }
	
	public  class   Game implements   ActionListener
    {
		public void actionPerformed(ActionEvent e) { 
			if(e.getActionCommand() == "Attaquer" && joueur == false ){
				j1.getPokemon().attaquer(j2.getPokemon());
				joueur = true;

			}
			else if(e.getActionCommand() == "Attaquer" && joueur == true){
				j2.getPokemon().attaquer(j1.getPokemon());
				joueur = false;
			}
			else if(e.getActionCommand() == "Effet" && joueur == false){
				j1.getPokemon().effet();
				joueur = true;
			}
			else if(e.getActionCommand() == "Effet" && joueur == true){
				j2.getPokemon().effet();
				joueur = false;
			}
			else if(e.getActionCommand() == "Passer" && joueur == true){
				joueur = false;
			}
			else if(e.getActionCommand() == "Passer" && joueur == false){
				joueur = true;
			}
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						Insets insets = game.getInsets(); 
        				
                	// Placement joueur 1
						//manJ1.setText("Manche : "+Integer.toString(j1.getNbrManche()));
						Dimension size = manJ1.getPreferredSize();
						manJ1.setBounds(100 + insets.left, 150 +insets.top, size.width, size.height);
						attJ1.setText("Attaque : "+String.valueOf(j1.getPokemon().getAttaque()));
						size = attJ1.getPreferredSize();
						attJ1.setBounds(100 + insets.left, 170 +insets.top, size.width, size.height);
						defJ1.setText("Defense : "+String.valueOf(j1.getPokemon().getDefense()));
						size = defJ1.getPreferredSize();
						defJ1.setBounds(100 + insets.left, 190 +insets.top, size.width, size.height);
						effJ1.setText("Effet : "+String.valueOf(j1.getPokemon().getEffet()));
						size = effJ1.getPreferredSize();
						effJ1.setBounds(100 + insets.left, 210 +insets.top, size.width, size.height);
						imgJ1.setIcon(new ImageIcon(j1.getPokemon().getImage()));
						size = imgJ1.getPreferredSize();
						imgJ1.setBounds(170 + insets.left, 150 +insets.top, size.width, size.height);
						
						
						// joueur 2
						//manJ2.setText("Manche : "+Integer.toString(j2.getNbrManche()));
						size = manJ2.getPreferredSize();
						manJ2.setBounds(520 + insets.left , 150 +insets.top, size.width, size.height);
						attJ2.setText("Attaque : "+String.valueOf(j2.getPokemon().getAttaque()));
						size = attJ2.getPreferredSize();
						attJ2.setBounds(520 + insets.left , 170 +insets.top, size.width, size.height);
						defJ2.setText("Defense : "+String.valueOf(j2.getPokemon().getDefense()));
						size = defJ2.getPreferredSize();
						defJ2.setBounds(520 + insets.left, 190 +insets.top, size.width, size.height);
						effJ2.setText("Effet : "+String.valueOf(j2.getPokemon().getEffet()));
						size = effJ2.getPreferredSize();
						effJ2.setBounds(520 + insets.left , 210 +insets.top, size.width, size.height);
						imgJ2.setIcon(new ImageIcon(j2.getPokemon().getImage()));
						size = imgJ2.getPreferredSize();
						imgJ2.setBounds(450 + insets.left, 150 +insets.top, size.width, size.height);
						
						if(j1.getPokemon().getDefense() <= 0 || j2.getPokemon().getDefense() <= 0){
							attaquer.setVisible(false);
							passer.setVisible(false);
							effet.setVisible(false);
							if(j1.getPokemon().getDefense() <= 0){
								affichageVainqueur.setText("Joueur 2 Gagne !");
							}else{
								affichageVainqueur.setText("Joueur 1 Gagne !");
							}
							size = affichageVainqueur.getPreferredSize();
							affichageVainqueur.setBounds(300 + insets.left, 200 +insets.top, size.width, size.height);
						}
						//Titre
						if(joueur == false){
							titreTour.setText("Tour Joueur 1");
						}else{
							titreTour.setText("Tour Joueur 2");
						}
						
						size = titreTour.getPreferredSize();
						titreTour.setBounds(300 + insets.left, 70 +insets.top, size.width, size.height);
                }
				}); 
				((CardLayout) cardLayout.getLayout()).show(cardLayout, Game);
			 
		}
    }
}
