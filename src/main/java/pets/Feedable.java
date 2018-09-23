package pets;

public interface Feedable {
	
	int getHunger();
	
	public void feed();
	
	public void increaseHungerOnTick();
	
	public void reduceHealthOnHighHunger();

}
