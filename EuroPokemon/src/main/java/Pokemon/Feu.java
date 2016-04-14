package Pokemon;

public class Feu extends Pokemon {
	
	public Feu() {
		// TODO Auto-generated constructor stub
		super(); 
	}
	public Feu(int id, String nom, String type, String image) {
		super(id, nom, type, image); 
	}
	@Override
	public void effet() {
		setAttaque(getAttaque()+getEffet());
	}

}
