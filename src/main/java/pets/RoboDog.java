package pets;

public class RoboDog extends RoboPet implements PetDog {

	public RoboDog(String name) {
		super(name);
		this.happiness = 10;
		this.rustLevel = 30;
	}

	@Override
	public void walk() {
		happiness += 10;
	}



}
