package pets;

public class OrganicCat extends OrganicPet implements PetCat{

	public OrganicCat(String name) {
		super(name);
		this.happiness = 10;
		this.hunger = 25;
		this.thirst = 25;
		this.waste = 1;
		
	}

	public void playWithLasers() {
		happiness += 10;
	}




}
