package attributes;

public class Happiness extends Attribute{
	
	public Happiness() {
		value = 10;
	}
	
	public void increaseValue() {
		value += 10;
	}
	
	public void decreaseValue() {
		if (value - 3 < 0) {
			value = 0;
		} else {
			value -= 3;
		}
	}

}
