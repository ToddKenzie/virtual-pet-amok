package pets;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PetShelter {

	private Map<String, VirtualPet> allPets = new HashMap<>();
	
	
	
	public Collection<VirtualPet> getAllPets() {
		return allPets.values();
	}
	
	public void takeInPet(VirtualPet pet) {
		allPets.put(pet.getName(), pet);
	}

	public void feedOrganicPets() {
		Collection<VirtualPet> allPets = getAllPets();
		for (VirtualPet virtualPet : allPets) {
			if (virtualPet instanceof OrganicPet) {
				OrganicPet petToFeed = (OrganicPet)virtualPet;
				petToFeed.feed();
			}
		}
	}

	public void giveWaterToOrganicPets() {
		Collection<VirtualPet> allPets = getAllPets();
		for (VirtualPet virtualPet : allPets) {
			if (virtualPet instanceof OrganicPet) {
				OrganicPet petToGiveWater = (OrganicPet)virtualPet;
				petToGiveWater.drink();
			}
		}		
	}

	public void oilRoboticPets() {
		Collection<VirtualPet> allPets = getAllPets();
		for (VirtualPet virtualPet : allPets) {
			if (virtualPet instanceof RoboPet) {
				RoboPet petToOil = (RoboPet)virtualPet;
				petToOil.oil();
			}
		}			
	}

}
