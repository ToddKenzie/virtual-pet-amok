package attributes;

public class Happiness extends Attribute{
	
	public Happiness() {
		value = 10;
	}
	
	public void increaseValue() {
		value += 4;
	}
	
	public void decreaseValue() {
		if (value - 1 < 0) {
			value = 0;
		} else {
			value -= 1;
		}
	}
	
	public String toString() {
		String publish;
		if (value <= 2) {
			publish = "X(";
		} else if (value <= 4) {
			publish = ":`(";
		} else if (value <= 6) {
			publish = ":(";
		} else if (value <= 8) {
			publish = ":|";
		} else if (value <= 10) {
			publish = ":)";
		} else {
			publish = ":D";
		}
		return publish;
	}
}
