package pets;

public class RoboCat extends RoboPet implements AttractedToLasers, PlaysWithToyMice {

	
	public RoboCat(String name) {
		super(name);
		this.rustLevel = new RustLevel(25);
	}
	
	public void playWithLasers() {
		happiness.increaseValue();;
	}

	@Override
	public void playWithToyMice() {
		happiness.increaseValue();
	}



}
