package pets;

import attributes.RustLevel;

public class RoboCat extends RoboPet implements AttractedToLasers, PlaysWithToyMice {

	
	public RoboCat(String name) {
		super(name);
		this.rustLevel = new RustLevel(6);
	}
	
	public void playWithLasers() {
		happiness.increaseValue();;
	}

	@Override
	public void playWithToyMice() {
		happiness.increaseValue();
	}

	public String toString() {
		return "RoboCat\t| " + this.healthLevel + "\t| " + this.happiness + "\t| " + this.rustLevel + "\t| " + this.name;
	}


}
