package pets;

public abstract class Attribute {
	
	protected int value;
	
	public int getValue() {
		return value;
	}
	
	public void increaseValue() {
		value += 10;
	}
	
	public void decreaseValue() {
		value -= 3;
	}

}
