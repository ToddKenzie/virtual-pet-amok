package pets;

import attributes.RustLevel;

public abstract class RoboPet extends VirtualPet implements Oilable {

	protected RustLevel rustLevel;

	public RoboPet(String name) {
		super(name);
	}

	public int getRustLevel() {
		return rustLevel.getValue();
	}

	public void oil() {
		rustLevel.decreaseValue();
	}

	@Override
	protected void tick() {
		increaseRustLevelOnTick();
		happiness.decreaseValue();
		modifyHealthLevel();
	}

	@Override
	protected void modifyHealthLevel() {
		decreaseHealthOnHighRustLevel();
		reduceHealthOnLowHappiness();
	}

	@Override
	public void increaseRustLevelOnTick() {
		rustLevel.increaseValue();
	}

	@Override
	public void decreaseHealthOnHighRustLevel() {
		if (rustLevel.getValue() >= 12) {
			healthLevel.decreaseValue();
		}
	}
	
	@Override
	protected void reduceHealthOnLowHappiness() {
		if (happiness.getValue() == 0) {
			healthLevel.decreaseValue();
		}
	}

}