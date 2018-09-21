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
		for (VirtualPet vPet : this.getAllPets()) {
			if (vPet instanceof OrganicPet) {
				OrganicPet petToFeed = (OrganicPet)vPet;
				petToFeed.feed();
			}
		}
	}

	public void giveWaterToOrganicPets() {
		for (VirtualPet vPet : this.getAllPets()) {
			if (vPet instanceof OrganicPet) {
				OrganicPet petToGiveWater = (OrganicPet)vPet;
				petToGiveWater.drink();
			}
		}		
	}

	public void oilRoboticPets() {
		for (VirtualPet vPet : this.getAllPets()) {
			if (vPet instanceof RoboPet) {
				RoboPet petToOil = (RoboPet)vPet;
				petToOil.oil();
			}
		}			
	}

	public void walkDogs() {
		for(VirtualPet vPet : this.getAllPets()) {
			if(vPet instanceof PetDog) {
				PetDog petToWalk = (PetDog)vPet;
				petToWalk.walk();
			}
		}
	}

	public void playWithLasersWithCats() {
		for(VirtualPet vPet : this.getAllPets()) {
			if(vPet instanceof PetCat) {
				PetCat petToPlayLasersWith = (PetCat)vPet;
				petToPlayLasersWith.playWithLasers();
			}
		}
	}

	public void tickAllPets() {
		for(VirtualPet vPet : this.getAllPets()) {
			vPet.tick();
		}
	}

}
