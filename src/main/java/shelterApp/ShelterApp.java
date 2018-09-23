package shelterApp;

import java.util.Scanner;

import pets.*;

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
			if (verifyOrganicPetExists()) {
				shelter.feedOrganicPets();
				System.out.println("You feed all of the pets.");
			} else {
				System.out.println("There are no pets present that can be fed.");
			}
			
			
		} else if (userMainMenuInput.equalsIgnoreCase("D")) {
			if (verifyOrganicPetExists() ) {
				shelter.giveWaterToOrganicPets();
				System.out.println("You give water to all of the thirsty pets.");
			} else {
				System.out.println("There are no pets that like water here.");
			}
			
			
		} else if (userMainMenuInput.equalsIgnoreCase("O")) {
			if (verifyRoboPetExists()) {
				shelter.oilRoboticPets();
				System.out.println("You lubricate the robots.");
			} else {
				System.out.println("There are no pets here who like oil.  You'd have to do a lot of clean-up and PETA would likely be called.");
			}
			
			
		} else if (userMainMenuInput.equalsIgnoreCase("W")) {
			if (verifyWalkablePetExists()) {
				shelter.walkDogs();
				System.out.println("You walk the dogs.  They all seem to be happier");
				if (verifyOrganicDogExists()) {
					System.out.println("The real dogs take some extra time doing their business in the yard.  At least it's not in the cages.");
				}
			} else {
				System.out.println("No pets here liked to be walked.  You may think that, but you're wrong.");
			}
			
		} else if (userMainMenuInput.equalsIgnoreCase("L")) {
			if (verifyAttractedToLasersPetExists()) {
				shelter.playLasersWithPets();
				System.out.println("You bring out the laser pointers.  Pets begin running all over the place chasing them.");
				if (verifyHatesLasersPetExists()) {
					System.out.println("The real dogs just get riled up with all the other animals running around.");
				}
			} else {
				System.out.println("You'd only rile up the pets in the shelter.  I wouldn't advise it.");
			}
		
		} else if (userMainMenuInput.equalsIgnoreCase("M")) {
			if (verifyPlaysWithToyMicePetExists()) {
				shelter.playWithToyMice();
				System.out.println("The cats begin throwing the mice around.");
				if (verifyHatesToyMicePetExists()) {
					System.out.println("The dogs get aggrivates with all the cats running around.");
				}
			} else {
				System.out.println("The dogs just stare at you.");
			}
			
		} else if (userMainMenuInput.equalsIgnoreCase("CB")) {
			shelter.cleanLitterBox();
			System.out.println("You clean out the cats' litterbox.");
			
		} else if (userMainMenuInput.equalsIgnoreCase("CC")) {
			shelter.cleanAllDogCages();
			System.out.println("You spend time cleaning all of the dog cages.");
			
		} else if (userMainMenuInput.equalsIgnoreCase("V")) {
			if (verifyOrganicPetExists()) {
				System.out.println("Which pet will you call the vet to treat?");
				String petToCallVet = verifyVetCanBeCalledOnPet();
				shelter.callVet(petToCallVet);
			} else {
				System.out.println("There are no pets here you can take to the vet.");
			}
			
			
		} else if (userMainMenuInput.equalsIgnoreCase("B")) {
			if (verifyRoboPetExists()) {
				System.out.println("Which pet will you change the batteries?");
				String petToChangeBatteries = verifyBatteriesCanBeChangedOnPet();
				shelter.changeBatteries(petToChangeBatteries);
			} else {
				System.out.println("There are no pets here with batteries.");
			}
			
		} else if (userMainMenuInput.equalsIgnoreCase("T")) {
			//code to take in new pet into shelter
			
		} else if (userMainMenuInput.equalsIgnoreCase("A")) {
			System.out.println("Which pet will you have adopted?");
			String petToAdopt = verifyPetNameExists();
			shelter.adopt(petToAdopt);
			System.out.println(petToAdopt + " has been adopted!");
			
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
	
	public static boolean verifyOrganicPetExists() {
		for (VirtualPet vPet : shelter.getAllPets()) {
			if (vPet instanceof OrganicPet) {
				return true;
			}
		}
		return false;
	}
	
	public static String verifyVetCanBeCalledOnPet() {
		String petToCallVet;
		while (true) {
			petToCallVet = input.nextLine();
			if (shelter.retrievePetInfo(petToCallVet) instanceof OrganicPet) {
				return petToCallVet;
			} else if (shelter.retrievePetInfo(petToCallVet) != null) {
				System.out.println("This pet cannot be taken to the vet.  Choose another pet.");
			} else {
				System.out.println("Pet name is invalid - double-check your spelling.");
			}
		}
	}
	
	public static boolean verifyRoboPetExists() {
		for (VirtualPet vPet : shelter.getAllPets()) {
			if (vPet instanceof RoboPet) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean verifyWalkablePetExists() {
		for (VirtualPet vPet : shelter.getAllPets()) {
			if (vPet instanceof Walkable) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean verifyOrganicDogExists() {
		for (VirtualPet vPet : shelter.getAllPets()) {
			if (vPet instanceof OrganicDog) {
				return true;
			}
		}
		return false;
	}

	public static boolean verifyAttractedToLasersPetExists() {
		for (VirtualPet vPet : shelter.getAllPets()) {
			if (vPet instanceof AttractedToLasers) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean verifyHatesLasersPetExists() {
		for (VirtualPet vPet : shelter.getAllPets()) {
			if (vPet instanceof HatesLasers) {
				return true;
			}
		}
		return false;
	}

	public static boolean verifyPlaysWithToyMicePetExists() {
		for (VirtualPet vPet : shelter.getAllPets()) {
			if (vPet instanceof PlaysWithToyMice) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean verifyHatesToyMicePetExists() {
		for (VirtualPet vPet : shelter.getAllPets()) {
			if (vPet instanceof HatesToyMice) {
				return true;
			}
		}
		return false;
	}

	public static String verifyBatteriesCanBeChangedOnPet() {
		String petToChangeBatteries;
		while (true) {
			petToChangeBatteries = input.nextLine();
			if (shelter.retrievePetInfo(petToChangeBatteries) instanceof RoboPet) {
				return petToChangeBatteries;
			} else if (shelter.retrievePetInfo(petToChangeBatteries) != null) {
				System.out.println("This pet does not have any batteries.  Choose another pet.");
			} else {
				System.out.println("Pet name is invalid - double-check your spelling.");
			}
		}
	}
	
	public static String verifyPetNameExists() {
		String petName;
		while (true) {
			petName = input.nextLine();
			if (shelter.retrievePetInfo(petName) != null) {
				return petName;
			} else {
				System.out.println("Pet name does not exist - double-check your spelling.");
			}
		}
	}
	
	

}
