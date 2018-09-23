package shelterApp;

public class ShelterAppMenus {

	public static String welcome() {
		String welcome = "welcome placeholder";
		return welcome;
	}

	public static String mainMenu() {
		String mainMenu = "Options Menu\n" 
	+ "Press \'F\' to FEED the pets\t\t" 
				+ "Press \'D\' to give water to DRINK\n"
	+ "Press \'O\' to OIL pets\t\t\t"
				+ "Press \'W\' to WALK all the dogs\n" 
	+ "Press \'L\' to play with LASER pointers\t"
				+ "Press \'M\' to play with fake MICE\n\n"
	+ "Press \'CB\' to CLEAN litterbox\t\t" 
				+ "Press \'CC\' to CLEAN Cages\n"
	+ "Press \'V\' to Call VET \t\t\t" 
				+ "Press \'B\' to Change BATTERIES\n\n"
	+ "Press \'T\' to TAKE in a new pet\t\t" 
				+ "Press \'A\' to have a pet ADOPTed";
		/*
		 * All options Feed Organics Give Water To Organics Oil Robots
		 * 
		 * Walk Dogs Bring out laser pens Bring out toy mice
		 * 
		 * 
		 * 
		 * 
		 * Clean Cages Clean LitterBox
		 * 
		 * Call Vet Change Batteries
		 * 
		 * Adopt Take in new pet
		 * 
		 * 
		 */

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
