package pets;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import attributes.CageWaste;
import attributes.LitterBoxWaste;

public class PetShelter {

	private PetGenerator petGen = new PetGenerator();
	
	private Map<String, VirtualPet> allPets = new HashMap<>();
	private Map<VirtualPet, DogCage> dogCages = new HashMap<>();
	
	private LitterBoxWaste litterBoxWaste = new LitterBoxWaste(0);
	
	public Collection<VirtualPet> getAllPets() {
		return allPets.values();
	}
	
	public CageWaste checkCageWaste(VirtualPet petOrgDog) {
		return dogCages.get(petOrgDog).getCageWaste();
	}

	public LitterBoxWaste getLitterBoxWaste() {
		return litterBoxWaste;
	}
	
	public VirtualPet retrievePetInfo(String petName) {
		return allPets.get(petName);
	}
	
	protected void takeInPet(VirtualPet pet) {
		allPets.put(pet.getName(), pet);
		if(pet instanceof OrganicDog) {
			OrganicDog oPet = (OrganicDog)pet;
			dogCages.put(oPet, new DogCage());
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
	
	public boolean feedFeedablePets() {
		boolean didFeedPet = false;
		for (VirtualPet vPet : this.getAllPets()) {
			if (vPet instanceof Feedable) {
				((Feedable)vPet).feed();
				didFeedPet = true;
			}
		}
		return didFeedPet;
	}

	public boolean giveWaterToDrinkablePets() {
		boolean didPetDrink = false;
		for (VirtualPet vPet : this.getAllPets()) {
			if (vPet instanceof Drinkable) {
				((Drinkable)vPet).drink();
				didPetDrink = true;
			}
		}
		return didPetDrink;
	}

	public boolean oilOilablePets() {
		boolean didOilPet = false;
		for (VirtualPet vPet : this.getAllPets()) {
			if (vPet instanceof Oilable) {
				((Oilable)vPet).oil();
				didOilPet = true;
			}
		}
		return didOilPet;
	}

	public boolean walkWalkablePets() {
		boolean didWalkPet = false;
		for(VirtualPet vPet : this.getAllPets()) {
			if(vPet instanceof Walkable) {
				((Walkable)vPet).walk();
				didWalkPet = true;
			}
		}
		return didWalkPet;
	}

	public void playLasersWithPets() {
		for(VirtualPet vPet : this.getAllPets()) {
			if(vPet instanceof AttractedToLasers) {
				((AttractedToLasers)vPet).playWithLasers();
			} else if (vPet instanceof HatesLasers) {
				((HatesLasers)vPet).hatesLasers();
			}
		}
	}

	public void playWithToyMice() {
		for(VirtualPet vPet : this.getAllPets()) {
			if(vPet instanceof PlaysWithToyMice) {
				((PlaysWithToyMice)vPet).playWithToyMice();
			} else if (vPet instanceof HatesToyMice) {
				((HatesToyMice)vPet).hatesToyMice();
			}
		}
	}

	public void playWithOnePet(String petName) {
		allPets.get(petName).play();
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
	
	public void cleanLitterBox() {
		litterBoxWaste.decreaseValue();
	}
	
	public void cleanAllDogCages() {
		for (DogCage cage : dogCages.values()) {
			cage.cleanDogCage();
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
				if(orgPet instanceof OrganicDog) {
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
			if (dogCages.get(vPet).getCageWaste().getValue() >= 10) {
				vPet.reduceHealth();
			}
		}
	}
	


}
