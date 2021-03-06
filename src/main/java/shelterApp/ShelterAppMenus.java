package shelterApp;

import pets.*;

public class ShelterAppMenus {

	public static String welcome() {
		String welcome = "Welcome to the Complex Happy Home Shelter.  You've got your hands full!";
		return welcome;
	}
	
	public static String petStatus(PetShelter shelter) {
		String petStatus = "\n";
		if (verifyOrganicPetExists(shelter)) {
			petStatus += "\'Real Pets\'\n"
			+ "Type\t|Health\t| Happy\t|Hunger\t|Thirst\t| Name\n";
			for (VirtualPet vPet : shelter.getAllPets()) {
				if (vPet instanceof OrganicPet) {
					petStatus += vPet + "\n";
				}
			}	
		}
		if (verifyRoboPetExists(shelter)) {
			petStatus += "\nRobotic Pets\n"
					+ "Type\t|Health\t| Happy\t| Rust\t| Name\n";
			for (VirtualPet vPet : shelter.getAllPets()) {
				if (vPet instanceof RoboPet) {
					petStatus += vPet + "\n";
				}
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
		String mainMenu = "\n\t\t\t-----Options Menu-----\n" 
	+ "Press \'F\' to FEED the pets\t\t" 
				+ "Press \'D\' to give water to DRINK\n"
	+ "Press \'O\' to OIL pets\t\t\t"
				+ "Press \'W\' to WALK all the dogs\n" 
	+ "Press \'L\' to play with LASER pointers\t"
				+ "Press \'M\' to play with fake MICE\n\t\t\tPress \'P\' to PLAY with one pet\n\t\t\t  ------------------\n"
	+ "Press \'CB\' to CLEAN litterbox\t\t" 
				+ "Press \'CC\' to CLEAN Cages\n"
	+ "Press \'V\' to Call VET \t\t\t" 
				+ "Press \'B\' to Change BATTERIES\n\t\t\t  ------------------\n"
	+ "Press \'T\' to TAKE in a new pet\t\t" 
				+ "Press \'A\' to have a pet ADOPTed\n"
	+ "\t\t  ---Press \'Q\' to QUIT application---\n\nWhat would you like to do?>";

		return mainMenu;
	}

	public static String closing() {
		String closing = "Thanks for participating.  I hope your time was enjoyable.";
		return closing;
	}
	
	public static boolean verifyOrganicPetExists(PetShelter shelter) {
		for (VirtualPet vPet : shelter.getAllPets()) {
			if (vPet instanceof OrganicPet) {
				return true;
			}
		}
		return false;
	}

	public static boolean verifyRoboPetExists(PetShelter shelter) {
		for (VirtualPet vPet : shelter.getAllPets()) {
			if (vPet instanceof RoboPet) {
				return true;
			}
		}
		return false;
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
