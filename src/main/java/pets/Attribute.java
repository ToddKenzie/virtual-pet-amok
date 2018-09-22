package pets;

public abstract class Attribute {
	
	protected int value;
	
	public int getValue() {
		return value;
	}
	
	public void increaseValue() {
		value += 3;
	}
	
	public void decreaseValue() {
		value -= 10;
	}

}
