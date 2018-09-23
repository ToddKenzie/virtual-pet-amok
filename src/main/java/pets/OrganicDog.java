package pets;

import attributes.Hunger;
import attributes.Thirst;
import attributes.Waste;

public class OrganicDog extends OrganicPet implements Walkable, HatesToyMice, HatesLasers {

	public OrganicDog(String name) {
		super(name);
		this.hunger = new Hunger(8);
		this.thirst = new Thirst(8);
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
	
	public String toString() {
		return "Dog\t| " + this.healthLevel + "\t| " + this.happiness + "\t| " + this.hunger + "\t| " + this.thirst + "\t| " + this.name;
	}

}
