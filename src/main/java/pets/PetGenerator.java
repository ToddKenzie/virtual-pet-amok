package pets;

public class PetGenerator {

	public VirtualPet createPet(String petType, String petName) {
		
		if (petType.equalsIgnoreCase("Cat") || petType.equals("1")) {
			return new OrganicCat(petName);
		} else if (petType.equalsIgnoreCase("Dog") || petType.equals("2")) {
			return new OrganicDog(petName);
		} else if (petType.equalsIgnoreCase("RoboCat") || petType.equals("3")) {
			return new RoboCat(petName);
		} else if (petType.equalsIgnoreCase("RoboDog") || petType.equals("4")) {
			return new RoboDog(petName);
		}
		return null;
	}
	
}
