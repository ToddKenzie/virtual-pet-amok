package pets;

public class OrganicCat extends OrganicPet implements AttractedToLasers, PlaysWithToyMice {

	public OrganicCat(String name) {
		super(name);
		this.hunger = new Hunger(25);
		this.thirst = new Thirst(25);
		this.waste = new Waste(1);

	}

	public void playWithLasers() {
		happiness.increaseValue();
	}

	@Override
	public void playWithToyMice() {
		happiness.increaseValue();
	}

}
