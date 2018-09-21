package pets;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PetShelter {

	private int litterBoxWaste;
	private Map<String, VirtualPet> allPets = new HashMap<>();
	private Map<VirtualPet, DogCage> dogCages = new HashMap<>();;
	
	
	public int getLitterBoxWaste() {
		return litterBoxWaste;
	}
	
	public Collection<VirtualPet> getAllPets() {
		return allPets.values();
	}
	
	public void takeInPet(VirtualPet pet) {
		allPets.put(pet.getName(), pet);
		if(pet instanceof PetDog) {
			dogCages.put(pet, new DogCage());
		}
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

	public void tickAll() {
		for(VirtualPet vPet : this.getAllPets()) {
			vPet.tick();
		}
		increaseWastePiles();
		reducePetHealthFromWaste();
	}
	

	public void increaseWastePiles() {
		for (VirtualPet vPet : this.getAllPets()) {
			if(vPet instanceof OrganicPet) {
				OrganicPet orgPet = (OrganicPet)vPet;
				if(orgPet instanceof PetDog) {
					dogCages.get(orgPet).increaseCageWaste(orgPet);
				} else {
					litterBoxWaste += orgPet.getWaste();
				}
			}
		}
	}

	private void reducePetHealthFromWaste() {
		reduceCatHealthFromLitterBox();
		reduceDogHealthFromCage();
	}

	private void reduceCatHealthFromLitterBox() {
		if(litterBoxWaste >= 10) {
			for (VirtualPet vPet : this.getAllPets()) {
				if (vPet instanceof OrganicCat) {
					vPet.reduceHealth();
				}
			}
		}
	}

	private void reduceDogHealthFromCage() {
		for(VirtualPet vPet : dogCages.keySet()) {
			if (dogCages.get(vPet).getCageWaste() >= 10) {
				vPet.reduceHealth();
			}
		}
	}
	
	public void cleanLitterBox() {
		litterBoxWaste = 0;
	}

	public int checkCageWaste(VirtualPet petOrgDog) {
		return dogCages.get(petOrgDog).getCageWaste();
	}

	public void cleanDogCage(VirtualPet petOrgDog) {
		dogCages.get(petOrgDog).cleanDogCage();
	}

}
