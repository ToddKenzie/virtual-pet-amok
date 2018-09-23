package pets;

public class OrganicPet extends VirtualPet implements Feedable, Drinkable {

	protected Hunger hunger;
	protected Thirst thirst;
	protected Waste waste;

	public OrganicPet(String name) {
		super(name);
	}
	

	public int getHunger() {
		return hunger.getValue();
	}

	public int getThirst() {
		return thirst.getValue();
	}

	public int getWaste() {
		return waste.getValue();
	}

	public void feed() {
		hunger.decreaseValue();
	}

	public void drink() {
		thirst.decreaseValue();
	}

	protected void tick() {
		increaseHungerOnTick();
		increaseThirstOnTick();
		happiness.decreaseValue();
		modifyHealthLevel();
	}

	protected void modifyHealthLevel() {
		reduceHealthOnHighHunger();
		reduceHealthOnHighThirst();
	}


	@Override
	public void increaseHungerOnTick() {
		hunger.increaseValue();
	}

	@Override
	public void increaseThirstOnTick() {
		thirst.increaseValue();
	}

	@Override
	public void reduceHealthOnHighHunger() {
		if (hunger.getValue() >= 40) {
			healthLevel.decreaseValue();
		}
	}

	@Override
	public void reduceHealthOnHighThirst() {
		if (thirst.getValue() >= 40) {
			healthLevel.decreaseValue();
		}
	}




}