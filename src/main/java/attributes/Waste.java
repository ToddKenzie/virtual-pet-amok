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

}
