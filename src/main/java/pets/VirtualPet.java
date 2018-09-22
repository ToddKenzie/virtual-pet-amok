package pets;

public abstract class VirtualPet {

	protected String name;
	protected HealthLevel healthLevel;
	protected int happiness;


	public String getName() {
		return name;
	}

	public int getHealthLevel() {
		return healthLevel.getValue();
	}

	public int getHappiness() {
		return happiness;
	}

	public VirtualPet(String name) {
		this.name = name;
	}

	protected abstract void tick();

	protected abstract void modifyHealthLevel();

	public void reduceHealth() {
		healthLevel.decreaseValue();;
	}


}