package shelterApp;

import java.util.Scanner;

import pets.PetShelter;

public class ShelterApp {
	
	public static PetShelter shelter;
	public static Scanner input;
	
	public static void main(String[] args) {
		
		appStartUp();
		System.out.println(ShelterAppMenus.welcome());
		
		System.out.println(ShelterAppMenus.mainMenu());
		
		
		
		
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
