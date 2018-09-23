package pets;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import attributes.LitterBoxWaste;

public class PetShelterTest {

	PetShelter underTest;
	VirtualPet petOrgCat;
	VirtualPet petOrgDog;
	VirtualPet petRoboCat;
	VirtualPet petRoboDog;

	@Before
	public void setUp() {
		underTest = new PetShelter();
		petOrgCat = new OrganicCat("Meow");
		petOrgDog = new OrganicDog("Woof");
		petRoboCat = new RoboCat("ME-OW");
		petRoboDog = new RoboDog("WO-OF");
		underTest.takeInPet(petOrgCat);
		underTest.takeInPet(petOrgDog);
		underTest.takeInPet(petRoboCat);
		underTest.takeInPet(petRoboDog);
	}

	@Test
	public void verify2PetsAreBroughtIntoShelter() {
		PetShelter underTest2 = new PetShelter();
		underTest2.takeInPet(petOrgCat);
		underTest2.takeInPet(petOrgDog);
		Collection<VirtualPet> allPets = underTest2.getAllPets();
		assertThat(allPets.size(), is(2));
	}

	@Test
	public void feedOnlyOrganicPetsOC6to2OD8to4() {
		underTest.feedOrganicPets();
		OrganicCat catCheck = (OrganicCat) petOrgCat;
		int hungerOC = catCheck.getHunger();
		OrganicDog dogCheck = (OrganicDog) petOrgDog;
		int hungerOD = dogCheck.getHunger();
		assertThat(hungerOC, is(2));
		assertThat(hungerOD, is(4));
	}

	@Test
	public void waterOnlyOrganicPetsOC6to2OD8to4() {
		underTest.giveWaterToOrganicPets();
		OrganicCat catCheck = (OrganicCat) petOrgCat;
		int thirstOC = catCheck.getThirst();
		OrganicDog dogCheck = (OrganicDog) petOrgDog;
		int thirstOD = dogCheck.getThirst();
		assertThat(thirstOC, is(2));
		assertThat(thirstOD, is(4));
	}

	@Test
	public void giveOilToOnlyRoboticPetsRC6to2RD8to4() {
		underTest.oilRoboticPets();
		RoboCat catCheck = (RoboCat) petRoboCat;
		int rustRC = catCheck.getRustLevel();
		RoboDog dogCheck = (RoboDog) petRoboDog;
		int rustRD = dogCheck.getRustLevel();
		assertThat(rustRC, is(2));
		assertThat(rustRD, is(4));
	}

	@Test
	public void giveWalkToOnlyDogsHappiness10to14() {
		underTest.walkDogs();
		int roboHappy = petRoboDog.getHappiness();
		int orgHappy = petOrgDog.getHappiness();
		assertThat(roboHappy, is(14));
		assertThat(orgHappy, is(14));
	}

	@Test
	public void giveLasersToOnlyLasersHappiness10to14DecreaseOrgDog10to9() {
		underTest.playLasersWithPets();
		int roboCHappy = petRoboCat.getHappiness();
		int orgCHappy = petOrgCat.getHappiness();
		int roboDHappy = petRoboDog.getHappiness();
		int orgDHappy = petOrgDog.getHappiness();
		assertThat(roboCHappy, is(14));
		assertThat(orgCHappy, is(14));
		assertThat(roboDHappy, is(14));
		assertThat(orgDHappy, is(9));
	}

	@Test
	public void testTickAllShouldReduceHappy10to9() {
		underTest.tickAll();
		int happyOC = petOrgCat.getHappiness();
		int happyOD = petOrgDog.getHappiness();
		int happyRC = petRoboCat.getHappiness();
		int happyRD = petRoboDog.getHappiness();
		assertThat(happyOC, is(9));
		assertThat(happyOD, is(9));
		assertThat(happyRC, is(9));
		assertThat(happyRD, is(9));
	}

	@Test
	public void testThatCatWasteIncreasesLitterBoxWasteOnTick0to1() {
		underTest.tickAll();
		LitterBoxWaste litterboxWaste = underTest.getLitterBoxWaste();
		assertThat(litterboxWaste.getValue(), is(1));
	}

	@Test
	public void testThatCleanLitterBoxWillCleanBoxTo0Waste() {
		underTest.tickAll(); // create LitterBoxWaste
		underTest.cleanLitterBox();
		LitterBoxWaste litterboxWaste = underTest.getLitterBoxWaste();
		assertThat(litterboxWaste.getValue(), is(0));
	}

	@Test
	public void testThatCagesIncreaseCageWasteOnTick() {
		OrganicDog orgDog2 = new OrganicDog("Sparky");
		underTest.takeInPet(orgDog2);
		underTest.tickAll();
		int cageWaste = underTest.checkCageWaste(petOrgDog).getValue();
		int cage2 = underTest.checkCageWaste(orgDog2).getValue();
		assertThat(cageWaste, is(3));
		assertThat(cage2, is(3));
	}

	@Test
	public void testThatCleanCageReduceCageWasteTo0() {
		underTest.tickAll();
		underTest.cleanAllDogCages();
		int cageWaste = underTest.checkCageWaste(petOrgDog).getValue();
		assertThat(cageWaste, is(0));
	}

	@Test
	public void assertThatLitterBoxWasteEQorGreater10ReduceOrgCatHealth10to9() {
		underTest.takeInPet(new OrganicCat("Meow2"));
		underTest.takeInPet(new OrganicCat("Meow3"));
		underTest.tickAll();
		underTest.tickAll();
		underTest.tickAll();
		underTest.tickAll();
		int orgCatHealth = petOrgCat.getHealthLevel();
		assertThat(orgCatHealth, is(9));
	}

	@Test
	public void assertThatCageWasteEQorGreater10ReduceOrgDogHealth10to9() {
		underTest.tickAll();
		underTest.tickAll();
		underTest.tickAll();
		int orgDogHealth = petOrgDog.getHealthLevel();
		assertThat(orgDogHealth, is(9));
	}

	@Test
	public void adoptAPetsoThereWillBe3PetsInShelter() {
		underTest.adopt("ME-OW");
		Collection<VirtualPet> allPets = underTest.getAllPets();
		assertThat(allPets, containsInAnyOrder(petOrgCat, petOrgDog, petRoboDog));
	}

	@Test
	public void assertThatChaseToyMiceIncreaseCatHappinessfrom10to14DogDecrease10to9() {
		underTest.playWithToyMice();
		int roboCHappy = petRoboCat.getHappiness();
		int orgCHappy = petOrgCat.getHappiness();
		int roboDHappy = petRoboDog.getHappiness();
		int orgDHappy = petOrgDog.getHappiness();
		assertThat(roboCHappy, is(14));
		assertThat(orgCHappy, is(14));
		assertThat(roboDHappy, is(9));
		assertThat(orgDHappy, is(9));
	}

	@Test
	public void assertThatUserCanCreateSpecificPetType() {
		underTest.takeInPet("Cat", "moo");
		VirtualPet check = underTest.retrievePetInfo("moo");
		assertThat(check.getName(), is("moo"));
	}

	@Test
	public void increasePetHealthByTakingToVet9To10() {
		//make PetHealth Drop
		underTest.takeInPet(new OrganicCat("Meow2"));
		underTest.takeInPet(new OrganicCat("Meow3"));
		underTest.tickAll();
		underTest.tickAll();
		underTest.tickAll();
		underTest.tickAll();
		// vetCheck
		underTest.callVet("Meow");
		int orgCatHealth = petOrgCat.getHealthLevel();
		assertThat(orgCatHealth, is(10));
	}
	
	@Test
	public void increaseRoboPetHealthByChangingBatteries9to10() {
		//reduce RoboPetHealth
		underTest.tickAll();
		underTest.tickAll();
		underTest.tickAll();
		underTest.tickAll();
		//change Batteries
		underTest.changeBatteries("WO-OF");
		int health = petRoboDog.getHealthLevel();
		assertThat(health, is(10));
	}
	
	@Test
	public void assertHappiness0ReducesHealth10to9OnTick() {
		underTest.tickAll();
		underTest.cleanAllDogCages();
		underTest.tickAll();
		underTest.cleanAllDogCages();
		underTest.oilRoboticPets();
		underTest.feedOrganicPets();
		underTest.giveWaterToOrganicPets();
		underTest.tickAll();
	
		underTest.cleanAllDogCages();
		underTest.cleanLitterBox();
		underTest.tickAll();
		underTest.cleanAllDogCages();
		underTest.tickAll();
	
		underTest.oilRoboticPets();
		underTest.feedOrganicPets();
		underTest.giveWaterToOrganicPets();
		underTest.cleanAllDogCages();
		underTest.tickAll();
		underTest.cleanAllDogCages();
		underTest.tickAll();
		underTest.cleanLitterBox();
		underTest.tickAll();
		int happyOD = petOrgDog.getHealthLevel();
		underTest.tickAll();
		underTest.tickAll();

		int happyOC = petOrgCat.getHealthLevel();
		assertThat(happyOC, is(9));
		assertThat(happyOD, is(9));
		
		int happyRC = petRoboCat.getHealthLevel();
		int happyRD = petRoboDog.getHealthLevel();
		assertThat(happyRC, is(9));
		assertThat(happyRD, is(9));
	}
	
	// Tested method by making cage public. Returned to private
//		@Test
//		public void checkAdoptRemovesDogCage() {
//		underTest.adopt("Woof");
//		Set<VirtualPet> allDogs = underTest.dogCages.keySet();
//		assertThat(allDogs, containsInAnyOrder(petRoboDog));
//		
//	}

}
