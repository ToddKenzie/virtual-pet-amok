package pets;

public class RoboDog extends RoboPet implements PetDog {

	public RoboDog(String name) {
		super(name);
		this.rustLevel = new RustLevel(30);
	}

	@Override
	public void walk() {
		happiness.increaseValue();
	}



}
