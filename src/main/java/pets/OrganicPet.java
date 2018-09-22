package pets;

public class OrganicPet extends VirtualPet {

	protected int hunger;
	protected int thirst;
	protected int waste;

	public OrganicPet(String name) {
		super(name);
	}
	

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public int getWaste() {
		return waste;
	}

	protected void feed() {
		hunger -= 10;
	}

	protected void drink() {
		thirst -= 10;
	}

	protected void tick() {
		hunger += 3;
		thirst += 3;
		waste++;
		happiness -= 3;
		modifyHealthLevel();
	}

	protected void modifyHealthLevel() {
		if (hunger >= 40) {
			healthLevel.decreaseValue();;
		}
		if (thirst >= 40) {
			healthLevel.decreaseValue();;
		}
	}

}