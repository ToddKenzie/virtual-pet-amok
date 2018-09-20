package pets;

public class OrganicDog {

	protected int healthLevel;
	protected int happiness;
	protected int hunger;
	protected int thirst;
	protected int waste;
	
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
	
	public OrganicDog() {
		this.healthLevel = 10;
		this.happiness = 10;
		this.hunger = 30;
		this.thirst = 30;
		this.waste = 2;
	}

	protected void feed() {
		hunger -= 10;
		
	}

	protected void drink() {
		thirst -= 10;
	}

	protected void walk() {
		happiness += 10;
		waste = 0;
	}

	protected void tick() {
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
