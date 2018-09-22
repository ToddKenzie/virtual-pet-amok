package pets;

public class RoboPet extends VirtualPet {

	protected RustLevel rustLevel;

	public RoboPet(String name) {
		super(name);
	}

	public int getRustLevel() {
		return rustLevel.getValue();
	}

	protected void oil() {
		rustLevel.decreaseValue();
	}

	@Override
	protected void tick() {
		rustLevel.increaseValue();
		happiness.decreaseValue();
		modifyHealthLevel();
	}

	@Override
	protected void modifyHealthLevel() {
		if (rustLevel.getValue() >= 40) {
			healthLevel.decreaseValue();
		}
	}

}