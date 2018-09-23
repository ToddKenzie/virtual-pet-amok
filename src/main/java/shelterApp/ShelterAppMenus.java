package shelterApp;

import pets.PetShelter;

public class ShelterAppMenus {

	public static String welcome() {
		String welcome = "welcome placeholder";
		return welcome;
	}
	
	public static String petStatus(PetShelter shelter) {
		String petStatus = "Placeholder";
		
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

}
