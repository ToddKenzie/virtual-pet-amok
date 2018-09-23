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
	

}
