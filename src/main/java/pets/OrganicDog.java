package pets;

public class OrganicDog extends OrganicPet implements PetDog{

	public OrganicDog(String name) {
		super(name);
		this.happiness = 10;
		this.hunger = 30;
		this.thirst = 30;
		this.waste = 2;
	}

	public void walk() {
		happiness += 10;
		waste = 0;
	}

}
