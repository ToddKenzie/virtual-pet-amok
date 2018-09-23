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
	
	public String toString() {
		String publish;
		if (value <= 2) {
			publish = ":D";
		} else if (value <= 4) {
			publish = ":)";
		} else if (value <= 6) {
			publish = ":|";
		} else if (value <= 8) {
			publish = ":(";
		} else if (value <=10) {
			publish = ":`(";
		} else {
			publish = "X(";
		}
		return publish;
	}
	
}
