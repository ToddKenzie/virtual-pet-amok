package pets;

import attributes.RustLevel;

public class RoboDog extends RoboPet implements Walkable, AttractedToLasers, HatesToyMice {

	public RoboDog(String name) {
		super(name);
		this.rustLevel = new RustLevel(8);
	}

	@Override
	public void walk() {
		happiness.increaseValue();
	}

	@Override
	public void playWithLasers() {
		happiness.increaseValue();
	}

	@Override
	public void hatesToyMice() {
		happiness.decreaseValue();
	}



}
