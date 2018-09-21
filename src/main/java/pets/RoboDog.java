package pets;

public class RoboDog extends RoboPet implements PetDog {

	public RoboDog() {
		this.healthLevel = 10;
		this.happiness = 10;
		this.rustLevel = 30;
	}

	@Override
	public void walk() {
		happiness += 10;
	}



}
