package pets;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class RoboCatTest {
	
	RoboCat underTest;
	
	@Before
	public void setUp() {
		underTest = new RoboCat();
	}
	
	@Test
	public void verifyOilRedcuesRustFrom25to15() {
		underTest.oil();
		int rust = underTest.getRustLevel();
		assertThat(rust, is(15));
	}
	
	@Test
	public void verifyLasersIncreaseHappinessfrom10to20() {
		underTest.playWithLasers();
		int happiness = underTest.getHappiness();
		assertThat(happiness, is(20));
	}
	
	@Test
	public void verifyTickIncreasesRustFrom25to28() {
		underTest.tick();
		int rust = underTest.getRustLevel();
		assertThat(rust, is(28));
	}
	
	@Test
	public void verifyTickReducesHappinessFrom10to7() {
		underTest.tick();
		int happiness = underTest.getHappiness();
		assertThat(happiness, is(7));
	}
	
	@Test
	public void OnTickHealthReduce10to9ifRustEQofGreater40() {
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.tick();
		int health = underTest.getHealthLevel();
		assertThat(health, is(9));
	}

}
