package pets;

public class OrganicPet extends VirtualPet {

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

	protected void feed() {
		hunger.decreaseValue();
	}

	protected void drink() {
		thirst.decreaseValue();
	}

	protected void tick() {
		hunger.increaseValue();
		thirst.increaseValue();
		happiness.decreaseValue();
		modifyHealthLevel();
	}

	protected void modifyHealthLevel() {
		if (hunger.getValue() >= 40) {
			healthLevel.decreaseValue();
		}
		if (thirst.getValue() >= 40) {
			healthLevel.decreaseValue();
		}
	}

}