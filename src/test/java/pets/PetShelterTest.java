package pets;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

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
	public void feedOnlyOrganicPetsOC25to15OD30to20() {
		underTest.feedOrganicPets();
		OrganicCat catCheck = (OrganicCat)petOrgCat;
		int hungerOC = catCheck.getHunger();
		OrganicDog dogCheck = (OrganicDog)petOrgDog;
		int hungerOD = dogCheck.getHunger();
		assertThat(hungerOC, is(15));
		assertThat(hungerOD, is(20));
	}

	@Test
	public void waterOnlyOrganicPetsOC25to15OD30to20() {
		underTest.giveWaterToOrganicPets();
		OrganicCat catCheck = (OrganicCat)petOrgCat;
		int thirstOC = catCheck.getThirst();
		OrganicDog dogCheck = (OrganicDog)petOrgDog;
		int thirstOD = dogCheck.getThirst();
		assertThat(thirstOC, is(15));
		assertThat(thirstOD, is(20));
	}

	@Test
	public void giveOilToOnlyRoboticPetsRC25to15RD30to20() {
		underTest.oilRoboticPets();
		RoboCat catCheck = (RoboCat)petRoboCat;
		int rustRC = catCheck.getRustLevel();
		RoboDog dogCheck = (RoboDog)petRoboDog;
		int rustRD = dogCheck.getRustLevel();
		assertThat(rustRC, is(15));
		assertThat(rustRD, is(20));
	}

	@Test
	public void giveWalkToOnlyDogsHappiness10to20() {
		underTest.walkDogs();
		int roboHappy = petRoboDog.getHappiness();
		int orgHappy = petOrgDog.getHappiness();
		assertThat(roboHappy, is(20));
		assertThat(orgHappy, is(20));
	}
	
	@Test
	public void giveLasersToOnlyCatsHappiness10to20() {
		underTest.playWithLasersWithCats();
		int roboHappy = petRoboCat.getHappiness();
		int orgHappy = petOrgCat.getHappiness();
		assertThat(roboHappy, is(20));
		assertThat(orgHappy, is(20));
	}
	
	@Test
		public void testTickAllShouldReduceHappy10to7() {
			underTest.tickAll();
			int happyOC = petOrgCat.getHappiness();
			int happyOD = petOrgDog.getHappiness();
			int happyRC = petRoboCat.getHappiness();
			int happyRD = petRoboDog.getHappiness();
			assertThat(happyOC, is(7));
			assertThat(happyOD, is(7));
			assertThat(happyRC, is(7));
			assertThat(happyRD, is(7));
		}

	@Test
	public void testThatCatWasteIncreasesLitterBoxWasteOnTick0to2() {
		underTest.tickAll();
		int litterboxWaste = underTest.getLitterBoxWaste();
		assertThat(litterboxWaste, is(2));
	}
	
	@Test
	public void testThatCleanLitterBoxWillCleanBoxTo0Waste() {
		underTest.tickAll(); //create LitterBoxWaste
		underTest.cleanLitterBox();
		int litterboxWaste = underTest.getLitterBoxWaste();
		assertThat(litterboxWaste, is(0));
	}
	
	@Test
	public void testThatCagesIncreaseCageWasteOnTick() {
		OrganicDog orgDog2 = new OrganicDog("Sparky");
		underTest.takeInPet(orgDog2);
		underTest.tickAll();
		int cageWaste = underTest.checkCageWaste(petOrgDog);
		int cage2 = underTest.checkCageWaste(orgDog2);
		assertThat(cageWaste, is(3));
		assertThat(cage2, is(3));
	}
	
	@Test
	public void testThatCleanCageReduceCageWasteTo0() {
		underTest.tickAll();
		underTest.cleanAllDogCages();
		int cageWaste = underTest.checkCageWaste(petOrgDog);
		assertThat(cageWaste, is(0));
	}
	
	@Test
	public void assertThatLitterBoxWasteEQorGreater10ReduceOrgCatHealth10to9() {
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
	
	//Tested method by making cage public.  Returned to private
//		@Test
//		public void checkAdoptRemovesDogCage() {
//		underTest.adopt("Woof");
//		Set<VirtualPet> allDogs = underTest.dogCages.keySet();
//		assertThat(allDogs, containsInAnyOrder(petRoboDog));
//		
//	}
	
	
	
}
