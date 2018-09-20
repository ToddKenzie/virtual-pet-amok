package pets;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class OrganicDogTest {

	OrganicDog underTest;
	
	@Before
	public void setUp() {
		underTest = new OrganicDog();
	}
	
	@Test
	public void verifyAnOrganicDogCanBeFed30to20() {
		underTest.feed();
		int hunger = underTest.getHunger();
		assertThat(hunger, is(20));
	}
	
	@Test
	public void verifyAnOrganicDogCanDrink30to20() {
		underTest.drink();
		int thirst = underTest.getThirst();
		assertThat(thirst, is(20));
	}
	
	@Test
	public void verifyWalkIncreasesHappiness10to20() {
		underTest.walk();
		int happiness = underTest.getHappiness();
		assertThat(happiness, is(20));
	}
	
	@Test
	public void verifyWalkReducesWaste2to0() {
		underTest.walk();
		int waste = underTest.getWaste();
		assertThat(waste, is(0));
	}
	
	@Test
	public void verifyTickIncreasesHunger30to33Thirst30to33Waste2to3() {
		underTest.tick();
		int hunger = underTest.getHunger();
		int thirst = underTest.getThirst();
		int waste = underTest.getWaste();
		assertThat(hunger, is(33));
		assertThat(thirst, is(33));
		assertThat(waste, is(3));
	}
	
	@Test
	public void verifyHealthDecreasesFrom10to9IfHungerEQorExceed40() {
		underTest.drink();  //prevent water condition match
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		int health = underTest.getHealthLevel();
		assertThat(health, is(9));
	}
	
	@Test
	public void verifyHealthDecreasesFrom10to9IfThirstEQorExceed40() {
		underTest.feed();  //prevent food condition match
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		int health = underTest.getHealthLevel();
		assertThat(health, is(9));
	}

}
