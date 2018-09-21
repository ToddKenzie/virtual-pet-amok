package pets;

public abstract class VirtualPet {

	protected int healthLevel;
	protected int happiness;

	public VirtualPet() {
		super();
	}

	public int getHealthLevel() {
		return healthLevel;
	}

	public int getHappiness() {
		return happiness;
	}

	protected abstract void tick();

	protected abstract void modifyHealthLevel();

}