package pets;

public class OrganicDog extends OrganicPet {

	public OrganicDog() {
		this.healthLevel = 10;
		this.happiness = 10;
		this.hunger = 30;
		this.thirst = 30;
		this.waste = 2;
	}

	protected void walk() {
		happiness += 10;
		waste = 0;
	}

}
