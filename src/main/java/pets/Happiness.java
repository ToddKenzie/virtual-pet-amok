package pets;

public class Happiness extends Attribute{
	
	public Happiness() {
		value = 10;
	}
	
	public void increaseValue() {
		value += 10;
	}
	
	public void decreaseValue() {
		value -= 3;
	}

}
