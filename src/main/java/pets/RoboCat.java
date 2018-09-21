package pets;

public class RoboCat extends RoboPet implements PetCat {

	
	public RoboCat() {
		this.healthLevel = 10;
		this.happiness = 10;
		this.rustLevel = 25;
	}
	
	public void playWithLasers() {
		happiness += 10;
	}



}
