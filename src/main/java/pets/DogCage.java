package pets;

public class DogCage {

	private int cageWaste;

	public int getCageWaste() {
		return cageWaste;
	}

	public void increaseCageWaste(OrganicPet orgPet) {
		cageWaste += orgPet.getWaste();
	}

	public void cleanDogCage() {
		cageWaste = 0;
	}

}
