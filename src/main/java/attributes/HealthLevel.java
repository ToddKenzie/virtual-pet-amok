package attributes;

public class HealthLevel extends Attribute{

	public HealthLevel() {
		value = 10;
	}
	
	public void increaseValue() {
		value = 10;
	}
	public void decreaseValue() {
		value--;
	}
	
	public String toString() {
		String publish;
		if (value <= 1) {
			publish = "X(";
		} else if (value <= 3) {
			publish = ":`(";
		} else if (value <= 5) {
			publish = ":(";
		} else if (value <= 7) {
			publish = ":|";
		} else if (value <= 9) {
			publish = ":)";
		} else {
			publish = ":D";
		}
		return publish;
	}
}
