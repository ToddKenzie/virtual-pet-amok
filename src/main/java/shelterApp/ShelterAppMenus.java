package shelterApp;

import pets.*;

public class ShelterAppMenus {

	public static String welcome() {
		String welcome = "welcome placeholder";
		return welcome;
	}
	
	public static String petStatus(PetShelter shelter) {
		String petStatus = "\'Real Pets\'\n"
				+ "Type\t|Health\t| Happy\t|Hunger\t|Thirst\t| Name\n";
		for (VirtualPet vPet : shelter.getAllPets()) {
			if (vPet instanceof OrganicPet) {
				petStatus += vPet + "\n";
			}
		}
		petStatus += "\nRobotic Pets\n"
				+ "Type\t|Health\t| Happy\t| Rust\t| Name\n";
		for (VirtualPet vPet : shelter.getAllPets()) {
			if (vPet instanceof RoboPet) {
				petStatus += vPet + "\n";
			}
		}
		petStatus += "\nWaste Levels That May Need Your Attention\n";
		petStatus += "LitterBox status is: " + shelter.getLitterBoxWaste() + "\n";
		if (verifyOrganicDogExists(shelter)) {
			for (VirtualPet vPet : shelter.getAllPets()) {
				if (vPet instanceof OrganicDog) {
					petStatus += vPet.getName() +"'s cage: " + shelter.checkCageWaste(vPet) + "\n";
				}
			}
			petStatus += "\n";	
		}
		return petStatus;
	}

	public static String mainMenu() {
		String mainMenu = "\t\t\t-----Options Menu-----\n" 
	+ "Press \'F\' to FEED the pets\t\t" 
				+ "Press \'D\' to give water to DRINK\n"
	+ "Press \'O\' to OIL pets\t\t\t"
				+ "Press \'W\' to WALK all the dogs\n" 
	+ "Press \'L\' to play with LASER pointers\t"
				+ "Press \'M\' to play with fake MICE\n\t\t\t  ------------------\n"
	+ "Press \'CB\' to CLEAN litterbox\t\t" 
				+ "Press \'CC\' to CLEAN Cages\n"
	+ "Press \'V\' to Call VET \t\t\t" 
				+ "Press \'B\' to Change BATTERIES\n\t\t\t  ------------------\n"
	+ "Press \'T\' to TAKE in a new pet\t\t" 
				+ "Press \'A\' to have a pet ADOPTed\n"
	+ "\t\t  ---Press \'Q\' to QUIT application---\n";

		return mainMenu;
	}

	public static String takeInNewPetMenu() {
		String takeinPetMenu = "take in pet placeholder";
		return takeinPetMenu;
	}

	public static String closing() {
		String closing = "closing placeholder";
		return closing;
	}
	
	public static boolean verifyOrganicDogExists(PetShelter shelter) {
		for (VirtualPet vPet : shelter.getAllPets()) {
			if (vPet instanceof OrganicDog) {
				return true;
			}
		}
		return false;
	}

}
