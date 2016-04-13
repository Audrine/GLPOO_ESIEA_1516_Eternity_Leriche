package Pokemon;

public class Eau extends Pokemon{
	
	public Eau(int id, String nom, String type, String image) {
		super(id, nom, type, image); 
	}
	@Override
	public void effet() {
		setDefense(getDefense()+getEffet());	
	}

}
