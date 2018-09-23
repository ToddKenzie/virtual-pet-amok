package pets;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import attributes.LitterBoxWaste;

public class PetShelter {

	private PetGenerator petGen = new PetGenerator();
	
	private Map<String, VirtualPet> allPets = new HashMap<>();
	private Map<VirtualPet, DogCage> dogCages = new HashMap<>();
	
	private LitterBoxWaste litterBoxWaste = new LitterBoxWaste(0);
	
	public int getLitterBoxWaste() {
		return litterBoxWaste.getValue();
	}
	
	public Collection<VirtualPet> getAllPets() {
		return allPets.values();
	}
	
	protected void takeInPet(VirtualPet pet) {
		allPets.put(pet.getName(), pet);
		if(pet instanceof OrganicDog) {
			dogCages.put(pet, new DogCage());
		}
	}

	public void takeInPet(String petType, String petName) {
		VirtualPet newPet = petGen.createPet(petType, petName);
		takeInPet(newPet);
	}
	
	public void adopt(String petName) {
		VirtualPet vPet = allPets.get(petName);
		if (vPet instanceof OrganicDog) {
			dogCages.remove(vPet);
		}
		allPets.remove(petName);
	}
	
	public VirtualPet retrievePetInfo(String petName) {
		return allPets.get(petName);
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
			if(vPet instanceof Walkable) {
				Walkable petToWalk = (Walkable)vPet;
				petToWalk.walk();
			}
		}
	}

	public void playLasersWithPets() {
		for(VirtualPet vPet : this.getAllPets()) {
			if(vPet instanceof AttractedToLasers) {
				AttractedToLasers petToPlayLasersWith = (AttractedToLasers)vPet;
				petToPlayLasersWith.playWithLasers();
			} else if (vPet instanceof HatesLasers) {
				HatesLasers petThatHatesLasers = (HatesLasers)vPet;
				petThatHatesLasers.hatesLasers();
			}
		}
	}

	public void playWithToyMice() {
		for(VirtualPet vPet : this.getAllPets()) {
			if(vPet instanceof PlaysWithToyMice) {
				PlaysWithToyMice petToPlayMiceWith = (PlaysWithToyMice)vPet;
				petToPlayMiceWith.playWithToyMice();
			} else if (vPet instanceof HatesToyMice) {
				HatesToyMice petThatHatesMice = (HatesToyMice)vPet;
				petThatHatesMice.hatesToyMice();
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
				if(orgPet instanceof Walkable) {
					dogCages.get(orgPet).increaseCageWaste(orgPet);
				} else {
					litterBoxWaste.increaseValue();
				}
			}
		}
	}

	private void reducePetHealthFromWaste() {
		reduceCatHealthFromLitterBox();
		reduceDogHealthFromCage();
	}

	private void reduceCatHealthFromLitterBox() {
		if(litterBoxWaste.getValue() >= 10) {
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
	
	public int checkCageWaste(VirtualPet petOrgDog) {
		return dogCages.get(petOrgDog).getCageWaste();
	}

	public void cleanLitterBox() {
		litterBoxWaste.decreaseValue();
	}

	public void cleanAllDogCages() {
		for (DogCage cage : dogCages.values()) {
			cage.cleanDogCage();
		}
	}

	public boolean callVet(String petName) {
		VirtualPet vPet = allPets.get(petName);
		if (vPet instanceof OrganicPet) {
			vPet.increaseHealth();
			return true;
		}
		return false;
	}

	public boolean changeBatteries(String petName) {
		VirtualPet vPet = allPets.get(petName);
		if (vPet instanceof RoboPet) {
			vPet.increaseHealth();
			return true;
		}
		return false;
	}
	

}
