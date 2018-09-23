package pets;

import attributes.CageWaste;

public class DogCage {

	private CageWaste cageWaste = new CageWaste(0);

	public CageWaste getCageWaste() {
		return cageWaste;
	}

	public void increaseCageWaste(OrganicPet oPet) {
		cageWaste.increaseValue(oPet.getWaste());
	}

	public void cleanDogCage() {
		cageWaste.decreaseValue();
	}

}
