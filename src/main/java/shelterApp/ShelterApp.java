package shelterApp;

import java.util.Scanner;

import pets.PetShelter;

public class ShelterApp {
	
	public static PetShelter shelter;
	public static Scanner input;
	
	public static void main(String[] args) {
		
		appStartUp();
		System.out.println(ShelterAppMenus.welcome());
		
		
		do {
			
		System.out.println(ShelterAppMenus.mainMenu());
		String userMainMenuInput = input.nextLine();
		
		if (userMainMenuInput.equalsIgnoreCase("F")) {
			shelter.feedOrganicPets();
			
		} else if (userMainMenuInput.equalsIgnoreCase("D")) {
			shelter.giveWaterToOrganicPets();
			
		} else if (userMainMenuInput.equalsIgnoreCase("O")) {
			shelter.oilRoboticPets();
			
		} else if (userMainMenuInput.equalsIgnoreCase("W")) {
			shelter.walkDogs();
			
		} else if (userMainMenuInput.equalsIgnoreCase("L")) {
			shelter.playLasersWithPets();
		
		} else if (userMainMenuInput.equalsIgnoreCase("M")) {
			shelter.playWithToyMice();
			
		} else if (userMainMenuInput.equalsIgnoreCase("CB")) {
			shelter.cleanLitterBox();
			
		} else if (userMainMenuInput.equalsIgnoreCase("CC")) {
			shelter.cleanAllDogCages();
			
		} else if (userMainMenuInput.equalsIgnoreCase("V")) {
			//call name of pet
			String petToCallVet = input.nextLine();
			shelter.callVet(petToCallVet);
			
		} else if (userMainMenuInput.equalsIgnoreCase("B")) {
			//call name of Pet
			String petToChangeBatteries = input.nextLine();
			shelter.changeBatteries(petToChangeBatteries);
			
		} else if (userMainMenuInput.equalsIgnoreCase("T")) {
			//code to take in new pet into shelter
			
		} else if (userMainMenuInput.equalsIgnoreCase("A")) {
			//call name of pet
			String petToAdopt = input.nextLine();
			shelter.adopt(petToAdopt);
			
		} else if (userMainMenuInput.equalsIgnoreCase("Q")) {
			break;
		} else {
			System.out.println("Invalid Input");
		}
		
		shelter.tickAll();
		
		} while (true);
		
		
		System.out.println(ShelterAppMenus.closing());
		input.close();
	}
	
	
	
	public static void appStartUp() {
		shelter = new PetShelter();
		shelter.takeInPet("Cat", "Kitty");
		shelter.takeInPet("Dog", "Buster");
		shelter.takeInPet("RoboCat", "KRYSTAL");
		shelter.takeInPet("RoboDog", "SPARKY");
		
		input = new Scanner(System.in);
	}

}
