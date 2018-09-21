package pets;

public abstract class VirtualPet {

	protected String name;
	protected int healthLevel;
	protected int happiness;


	public String getName() {
		return name;
	}

	public int getHealthLevel() {
		return healthLevel;
	}

	public int getHappiness() {
		return happiness;
	}

	public VirtualPet(String name) {
		this.name = name;
		this.healthLevel = 10;
	}

	protected abstract void tick();

	protected abstract void modifyHealthLevel();

	public void reduceHealth() {
		healthLevel--;
	}


}