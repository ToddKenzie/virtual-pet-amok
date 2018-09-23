package pets;

public interface Drinkable {
	
	int getThirst();
	
	void drink();
	
	void increaseThirstOnTick();
	
	void reduceHealthOnHighThirst();

}
