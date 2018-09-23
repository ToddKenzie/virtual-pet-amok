package pets;

import attributes.Happiness;
import attributes.HealthLevel;

public abstract class VirtualPet {

	protected String name;
	protected HealthLevel healthLevel;
	protected Happiness happiness;


	public String getName() {
		return name;
	}

	public int getHealthLevel() {
		return healthLevel.getValue();
	}

	public int getHappiness() {
		return happiness.getValue();
	}

	public VirtualPet(String name) {
		this.name = name;
		this.healthLevel = new HealthLevel();
		this.happiness = new Happiness();
	}

	protected abstract void tick();

	protected abstract void modifyHealthLevel();

	protected void reduceHealth() {
		healthLevel.decreaseValue();
	}
	
	protected void increaseHealth() {
		healthLevel.increaseValue();
	}


}