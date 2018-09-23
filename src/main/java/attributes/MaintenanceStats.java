package attributes;

public abstract class MaintenanceStats extends Attribute {

	public void increaseValue() {
		value += 1;
	}
	
	public void decreaseValue() {
		if (value - 4 < 0) {
			value = 0;
		} else {
			value -= 4;
		}
	}
}
