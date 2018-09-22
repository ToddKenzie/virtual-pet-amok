package pets;

public class RoboPet extends VirtualPet {

	protected int rustLevel;

	public RoboPet(String name) {
		super(name);
	}

	public int getRustLevel() {
		return rustLevel;
	}

	protected void oil() {
		rustLevel -= 10;
	}

	@Override
	protected void tick() {
		rustLevel += 3;
		happiness -= 3;
		modifyHealthLevel();
	}

	@Override
	protected void modifyHealthLevel() {
		if (rustLevel >= 40) {
			healthLevel.decreaseValue();;
		}
	}

}