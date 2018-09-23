package pets;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class RoboDogTest {
	
	RoboDog underTest;
	
	@Before
	public void setUp() {
		underTest = new RoboDog("");
	}
	
	@Test
	public void verifyThatOiledReducesRusty8to4() {
		underTest.oil();
		int rust = underTest.getRustLevel();
		assertThat(rust, is(4));
	}
	
	@Test
	public void verifyThatWalkIncreasesHappiness10to14() {
		underTest.walk();
		int happiness = underTest.getHappiness();
		assertThat(happiness, is(14));
	}
	
	@Test
	public void verifyThatTickIncreasesRustLevelfrom8to9() {
		underTest.tick();
		int rust = underTest.getRustLevel();
		assertThat(rust, is(9));
	}
	
	@Test
	public void verifyTickReducesHappinessFrom10to9() {
		underTest.tick();
		int happiness = underTest.getHappiness();
		assertThat(happiness, is(9));
	}
	
	@Test
	public void verifyTickReducesHealthFrom10to9IfRustEQorGreater12() {
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		int health = underTest.getHealthLevel();
		assertThat(health, is(9));
	}

}
