package pets;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class RoboDogTest {
	
	RoboDog underTest;
	
	@Before
	public void setUp() {
		underTest = new RoboDog();
	}
	
	@Test
	public void verifyThatOiledReducesRusty30to20() {
		underTest.oil();
		int rust = underTest.getRustLevel();
		assertThat(rust, is(20));
	}
	
	@Test
	public void verifyThatWalkIncreasesHappiness10to20() {
		underTest.walk();
		int happiness = underTest.getHappiness();
		assertThat(happiness, is(20));
	}
	
	@Test
	public void verifyThatTickIncreasesRustLevelfrom30to33() {
		underTest.tick();
		int rust = underTest.getRustLevel();
		assertThat(rust, is(33));
	}
	
	@Test
	public void verifyTickReducesHappinessFrom10to7() {
		underTest.tick();
		int happiness = underTest.getHappiness();
		assertThat(happiness, is(7));
	}
	
	@Test
	public void verifyTickReducesHealthFrom10to9IfRustEQorGreater40() {
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		int health = underTest.getHealthLevel();
		assertThat(health, is(9));
	}

}
