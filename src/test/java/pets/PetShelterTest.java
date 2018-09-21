package pets;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

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
	

}
