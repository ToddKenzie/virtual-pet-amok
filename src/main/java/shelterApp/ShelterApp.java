package shelterApp;

import java.util.ArrayList;
import java.util.Scanner;

import pets.*;

public class ShelterApp {

	public static PetShelter shelter;
	public static Scanner input;
	public static ArrayList<String> choices;

	public static void main(String[] args) {

		appStartUp();
		System.out.println(ShelterAppMenus.welcome());

		do {
			System.out.println(ShelterAppMenus.petStatus(shelter));
			System.out.println(ShelterAppMenus.mainMenu());
			String userMainMenuInput = input.nextLine();

			if (userMainMenuInput.equalsIgnoreCase("F")) {
				if (verifyOrganicPetExists()) {
					shelter.feedOrganicPets();
					System.out.println("\nYou feed all of the pets.");
				} else {
					System.out.println("\nThere are no pets present that can be fed.");
				}

			} else if (userMainMenuInput.equalsIgnoreCase("D")) {
				if (verifyOrganicPetExists()) {
					shelter.giveWaterToOrganicPets();
					System.out.println("\nYou give water to all of the thirsty pets.");
				} else {
					System.out.println("\nThere are no pets that like water here.");
				}

			} else if (userMainMenuInput.equalsIgnoreCase("O")) {
				if (verifyRoboPetExists()) {
					shelter.oilRoboticPets();
					System.out.println("\nYou lubricate the robots.");
				} else {
					System.out.println(
							"\nThere are no pets here who like oil.  You'd have to do a lot of clean-up and PETA would likely be called.");
				}

			} else if (userMainMenuInput.equalsIgnoreCase("W")) {
				if (verifyWalkablePetExists()) {
					shelter.walkDogs();
					System.out.println("\nYou walk the dogs.  They all seem to be happier");
					if (verifyOrganicDogExists()) {
						System.out.println(
								"The real dogs take some extra time doing their business in the yard.  At least it's not in the cages.");
					}
				} else {
					System.out.println("\nNo pets here liked to be walked.  You may think that, but you're wrong.");
				}

			} else if (userMainMenuInput.equalsIgnoreCase("L")) {
				if (verifyAttractedToLasersPetExists()) {
					shelter.playLasersWithPets();
					System.out.println(
							"\nYou bring out the laser pointers.  Pets begin running all over the place chasing them.");
					if (verifyHatesLasersPetExists()) {
						System.out
								.println("The real dogs just get riled up with all the other animals running around.");
					}
				} else {
					System.out.println("\nYou'd only rile up the pets in the shelter.  I wouldn't advise it.");
				}

			} else if (userMainMenuInput.equalsIgnoreCase("M")) {
				if (verifyPlaysWithToyMicePetExists()) {
					shelter.playWithToyMice();
					System.out.println("\nThe cats begin throwing the mice around.");
					if (verifyHatesToyMicePetExists()) {
						System.out.println("\nThe dogs get aggrivates with all the cats running around.");
					}
				} else {
					System.out.println("\nThe dogs just stare at you.");
				}

			} else if (userMainMenuInput.equalsIgnoreCase("P")) {
				System.out.println("\nWhich pet would you like to play with?");
				String petToPlayWith = verifyPetNameExists();
				shelter.playWithOnePet(petToPlayWith);
				System.out.println("You play with " + petToPlayWith
						+ ".  The rest of the pets stare at you.\nPerhaps playing with only one isn't the best option.");

			} else if (userMainMenuInput.equalsIgnoreCase("CB")) {
				shelter.cleanLitterBox();
				System.out.println("\nYou clean out the cats' litterbox.");

			} else if (userMainMenuInput.equalsIgnoreCase("CC")) {
				shelter.cleanAllDogCages();
				System.out.println("\nYou spend time cleaning all of the dog cages.");

			} else if (userMainMenuInput.equalsIgnoreCase("V")) {
				if (verifyOrganicPetExists()) {
					System.out.println("\nWhich pet will you call the vet to treat?");
					String petToCallVet = verifyVetCanBeCalledOnPet();
					shelter.callVet(petToCallVet);
					System.out.println(petToCallVet + " gets treated by the vet.");
				} else {
					System.out.println("\nThere are no pets here you can take to the vet.");
				}

			} else if (userMainMenuInput.equalsIgnoreCase("B")) {
				if (verifyRoboPetExists()) {
					System.out.println("\nWhich pet will you change the batteries?");
					String petToChangeBatteries = verifyBatteriesCanBeChangedOnPet();
					shelter.changeBatteries(petToChangeBatteries);
					System.out.println("You exchange the batteries on " + petToChangeBatteries);
				} else {
					System.out.println("\nThere are no pets here with batteries.");
				}

			} else if (userMainMenuInput.equalsIgnoreCase("T")) {
				System.out.println("Which type of pet will you bring into the shelter?");
				String petType = verifyPetChoiceToBringIn();
				System.out.println("What will the pet's name be?");
				String petName = verifyPetNameDoesNotExist();
				shelter.takeInPet(petType, petName);
				System.out.println("You brought in " + petName + ".");

			} else if (userMainMenuInput.equalsIgnoreCase("A")) {
				System.out.println("\nWhich pet will you have adopted?");
				String petToAdopt = verifyPetNameExists();
				shelter.adopt(petToAdopt);
				System.out.println(petToAdopt + " has been adopted!");

			} else if (userMainMenuInput.equalsIgnoreCase("Q")) {
				break;
			} else {
				System.out.println("\nInvalid Input");
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

		choices = new ArrayList<>();
		choices.add("1");
		choices.add("2");
		choices.add("3");
		choices.add("4");
		choices.add("Cat");
		choices.add("dog");
		choices.add("robocat");
		choices.add("robodog");
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

	public static String verifyPetChoiceToBringIn() {
		System.out.println("1 for CAT, 2 for DOG, 3 for ROBOCAT, 4 for ROBODOG?");
		String petTypeChoice;
		while (true) {
			petTypeChoice = input.nextLine();
			for (String string : choices) {
				if (string.equalsIgnoreCase(petTypeChoice)) {
					return petTypeChoice;
				} 
			}
			System.out.println("Invalid choice.");
		}
	}

	public static String verifyPetNameDoesNotExist() {
		String petName;
		while (true) {
			petName = input.nextLine();
			if (shelter.retrievePetInfo(petName) == null) {
				return petName;
			} else {
				System.out.println("Pet name exists - please use a different name.");
			}
		}
	}

}
