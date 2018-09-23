package pets;

public interface Oilable {
	
	int getRustLevel();
	
	void oil();
	
	void increaseRustLevelOnTick();
	
	void decreaseHealthOnHighRustLevel();

}
