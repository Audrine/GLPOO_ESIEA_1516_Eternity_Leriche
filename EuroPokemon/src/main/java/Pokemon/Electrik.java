package Pokemon;

public class Electrik extends Pokemon {


	public Electrik(int id, String nom, String type, String image) {
		super(id, nom, type, image); 
	}

	@Override
	public void effet() {
		setDefense(getDefense()+getEffet());
	}

}
