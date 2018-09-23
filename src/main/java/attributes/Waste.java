package attributes;

public class Waste extends Attribute {
	
	public Waste(int value) {
		this.value = value;
	}
	
	public void increaseValue() {
		value++;
	}
	
	public void decreaseValue() {
		value = 0;
	}

	public String toString() {
		String publish;
		if (value <= 2) {
			publish = "Clean";
		} else if (value <= 4) {
			publish = "A Little Febreeze never hurts";
		} else if (value <= 6) {
			publish = "Noticeable";
		} else if (value <= 8) {
			publish = "Health Hazard";
		} else {
			publish = "Toxic Wastedump";
		}
		return publish;
	}
}
