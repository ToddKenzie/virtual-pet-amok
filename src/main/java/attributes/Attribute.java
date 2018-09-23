package attributes;

public abstract class Attribute {
	
	protected int value;
	
	public int getValue() {
		return value;
	}
	
	public abstract void increaseValue();
	
	public abstract void decreaseValue(); 
}
