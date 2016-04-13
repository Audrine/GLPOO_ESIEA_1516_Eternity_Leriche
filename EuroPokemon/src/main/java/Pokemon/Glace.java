package Pokemon;

public class Glace extends Pokemon {
	
	public Glace(int id, String nom, String type, String image) {
		super(id, nom, type, image); 
	}
	@Override
	public void effet() {
		setAttaque(getAttaque()+getEffet());
	}

}
