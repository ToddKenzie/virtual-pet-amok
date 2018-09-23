package pets;

public class OrganicDog extends OrganicPet implements Walkable, HatesToyMice, HatesLasers {

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
		increaseHungerOnTick();
		increaseThirstOnTick();
		waste.increaseValue();
		happiness.decreaseValue();
		modifyHealthLevel();
	}

	@Override
	public void hatesToyMice() {
		happiness.decreaseValue();
	}

	@Override
	public void hatesLasers() {
		happiness.decreaseValue();
	}

}
