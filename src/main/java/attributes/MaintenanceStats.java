package attributes;

public abstract class MaintenanceStats extends Attribute {

	public void increaseValue() {
		value += 3;
	}
	
	public void decreaseValue() {
		if (value - 10 < 0) {
			value = 0;
		} else {
			value -= 10;
		}
	}
}
