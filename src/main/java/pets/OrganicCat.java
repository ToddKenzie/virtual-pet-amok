package pets;

import attributes.Hunger;
import attributes.Thirst;
import attributes.Waste;

public class OrganicCat extends OrganicPet implements AttractedToLasers, PlaysWithToyMice {

	public OrganicCat(String name) {
		super(name);
		this.hunger = new Hunger(6);
		this.thirst = new Thirst(6);
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
