package pets;

public class OrganicCat extends OrganicPet {

	public OrganicCat() {
		this.healthLevel = 10;
		this.happiness = 10;
		this.hunger = 25;
		this.thirst = 25;
		this.waste = 1;
		
	}

	public void playWithLasers() {
		happiness += 10;
	}




}
