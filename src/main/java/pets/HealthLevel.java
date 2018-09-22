package pets;

public class HealthLevel extends Attribute{

	public HealthLevel() {
		value = 10;
	}
	
	public void decreaseValue() {
		value--;
	}
}
