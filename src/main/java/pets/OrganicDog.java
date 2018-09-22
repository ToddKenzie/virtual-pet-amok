package pets;

public class OrganicDog extends OrganicPet implements PetDog{

	public OrganicDog(String name) {
		super(name);
		this.hunger = new Hunger(30);
		this.thirst = new Thirst(30);
		this.waste = new Waste(2);
	}

	public void walk() {
		happiness.increaseValue();
		waste.decreaseValue();
	}
	
	protected void tick() {
		hunger.increaseValue();
		thirst.increaseValue();
		waste.increaseValue();
		happiness.decreaseValue();
		modifyHealthLevel();
	}


}
