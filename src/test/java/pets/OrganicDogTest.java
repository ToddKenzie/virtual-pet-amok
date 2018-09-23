package pets;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class OrganicDogTest {

	OrganicDog underTest;
	
	@Before
	public void setUp() {
		underTest = new OrganicDog("");
	}
	
	@Test
	public void verifyAnOrganicDogCanBeFed8to3() {
		underTest.feed();
		int hunger = underTest.getHunger();
		assertThat(hunger, is(3));
	}
	
	@Test
	public void verifyAnOrganicDogCanDrink8to3() {
		underTest.drink();
		int thirst = underTest.getThirst();
		assertThat(thirst, is(3));
	}
	
	@Test
	public void verifyWalkIncreasesHappiness10to14() {
		underTest.walk();
		int happiness = underTest.getHappiness();
		assertThat(happiness, is(14));
	}
	
	@Test
	public void verifyWalkReducesWaste2to0() {
		underTest.walk();
		int waste = underTest.getWaste();
		assertThat(waste, is(0));
	}
	
	@Test
	public void verifyTickIncreasesHunger8to9Thirst8to9Waste2to3() {
		underTest.tick();
		int hunger = underTest.getHunger();
		int thirst = underTest.getThirst();
		int waste = underTest.getWaste();
		assertThat(hunger, is(9));
		assertThat(thirst, is(9));
		assertThat(waste, is(3));
	}
	
	@Test
	public void verifyHealthDecreasesFrom10to9IfHungerEQorExceed12() {
		underTest.drink();  //prevent water condition match
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		int health = underTest.getHealthLevel();
		assertThat(health, is(9));
	}
	
	@Test
	public void verifyHealthDecreasesFrom10to9IfThirstEQorExceed12() {
		underTest.feed();  //prevent food condition match
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		int health = underTest.getHealthLevel();
		assertThat(health, is(9));
	}
	
	@Test
	public void verifyTickReducesHappinessFrom10to9() {
		underTest.tick();
		int happiness = underTest.getHappiness();
		assertThat(happiness, is(9));
	}

}
