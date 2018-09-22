package pets;

public class OrganicCat extends OrganicPet implements PetCat{

	public OrganicCat(String name) {
		super(name);
		this.hunger = new Hunger(25);
		this.thirst = new Thirst(25);
		this.waste = new Waste(1);
		
	}

	public void playWithLasers() {
		happiness.increaseValue();;
	}




}
