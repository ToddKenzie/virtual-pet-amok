package pets;

public class OrganicPet {

	protected int healthLevel;
	protected int happiness;
	protected int hunger;
	protected int thirst;
	protected int waste;

	public OrganicPet() {
		super();
	}

	public int getHealthLevel() {
		return healthLevel;
	}

	public int getHappiness() {
		return happiness;
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

	public void feed() {
		hunger -= 10;
	}

	public void drink() {
		thirst -= 10;
	}

	public void tick() {
		hunger += 3;
		thirst += 3;
		waste++;
		modifyHealthLevel();
	}

	protected void modifyHealthLevel() {
		if (hunger >= 40) {
			healthLevel--;
		}
		if (thirst >= 40) {
			healthLevel--;
		}
	}

}