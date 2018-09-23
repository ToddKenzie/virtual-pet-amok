package pets;

public class PetGenerator {

	public VirtualPet createPet(String petType, String petName) {
		
		if (petType.equalsIgnoreCase("Cat")) {
			return new OrganicCat(petName);
		} else if (petType.equalsIgnoreCase("Dog")) {
			return new OrganicDog(petName);
		} else if (petType.equalsIgnoreCase("RoboCat")) {
			return new RoboCat(petName);
		} else if (petType.equalsIgnoreCase("RoboDog")) {
			return new RoboDog(petName);
		}
		return null;
	}
	
}
