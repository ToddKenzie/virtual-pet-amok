package pets;

public class RoboCat extends RoboPet implements PetCat {

	
	public RoboCat(String name) {
		super(name);
		this.rustLevel = new RustLevel(25);
	}
	
	public void playWithLasers() {
		happiness.increaseValue();;
	}



}
