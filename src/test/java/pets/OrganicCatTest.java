package pets;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class OrganicCatTest {

	
	OrganicCat underTest;
	
	@Before
	public void setUp() {
		underTest = new OrganicCat();
	}
	
	@Test
	public void verifyFeedReducesHungerFrom25to15() {
		underTest.feed();
		int hunger = underTest.getHunger();
		assertThat(hunger, is(15));
	}
	
	@Test
	public void verifyDrinkReducesThirstFrom25to15() {
		underTest.drink();
		int thirst = underTest.getThirst();
		assertThat(thirst, is(15));
	}
	
	@Test
	public void verifyPlayWithLasersIncreasesHappinessFrom10to20() {
		underTest.playWithLasers();
		int happiness = underTest.getHappiness();
		assertThat(happiness, is(20));
	}
	
	@Test
	public void verifyTickIncreasesHunger25to28Thirst25to28Waste1to2() {
		underTest.tick();
		int hunger = underTest.getHunger();
		int thirst = underTest.getThirst();
		int waste = underTest.getWaste();
		assertThat(hunger, is(28));
		assertThat(thirst, is(28));
		assertThat(waste, is(2));
	}
	
	@Test
	public void verifyHealthDecreasesFrom10to9OnTickIfHungerEQorGreaterThan40() {
		underTest.drink(); //prevent double hit on healthCheck
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		int healthLevel = underTest.getHealthLevel();
		assertThat(healthLevel, is(9));
	}
	
	@Test
	public void verifyHealthDecreasesFrom10to9OnTickIfThirstEQorGreaterThan40() {
		underTest.feed(); //prevent double hit on healthCheck
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		int healthLevel = underTest.getHealthLevel();
		assertThat(healthLevel, is(9));
	}
	
	@Test
	public void verifyTickReducesHappinessFrom10to7() {
		underTest.tick();
		int happiness = underTest.getHappiness();
		assertThat(happiness, is(7));
	}
	
	
}
