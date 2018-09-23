package pets;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class OrganicCatTest {

	
	OrganicCat underTest;
	
	@Before
	public void setUp() {
		underTest = new OrganicCat("");
	}
	
	@Test
	public void verifyFeedReducesHungerFrom6to2() {
		underTest.feed();
		int hunger = underTest.getHunger();
		assertThat(hunger, is(2));
	}
	
	@Test
	public void verifyDrinkReducesThirstFrom6to2() {
		underTest.drink();
		int thirst = underTest.getThirst();
		assertThat(thirst, is(2));
	}
	
	@Test
	public void verifyPlayWithLasersIncreasesHappinessFrom10to14() {
		underTest.playWithLasers();
		int happiness = underTest.getHappiness();
		assertThat(happiness, is(14));
	}
	
	@Test
	public void verifyTickIncreasesHunger6to7Thirst6to7() {
		underTest.tick();
		int hunger = underTest.getHunger();
		int thirst = underTest.getThirst();
		assertThat(hunger, is(7));
		assertThat(thirst, is(7));
	}
	
	@Test
	public void verifyHealthDecreasesFrom10to9OnTickIfHungerEQorGreaterThan12() {
		underTest.drink(); //prevent double hit on healthCheck
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		int healthLevel = underTest.getHealthLevel();
		assertThat(healthLevel, is(9));
	}
	
	@Test
	public void verifyHealthDecreasesFrom10to9OnTickIfThirstEQorGreaterThan12() {
		underTest.feed(); //prevent double hit on healthCheck
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		int healthLevel = underTest.getHealthLevel();
		assertThat(healthLevel, is(9));
	}
	
	@Test
	public void verifyTickReducesHappinessFrom10to9() {
		underTest.tick();
		int happiness = underTest.getHappiness();
		assertThat(happiness, is(9));
	}
	
	
}
