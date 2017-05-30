package pt.iul.ista.poo.rogue.images;

import pt.iul.ista.poo.rogue.utils.Position;

public class Hammer extends Image {

	public Hammer(Position position) {
		super(position);
	}
	
	@Override
	public String getName() {
		return "Hammer";
	}

	@Override
	public boolean canMove() {
		return true;
	}

	@Override
	public int priority() {
		return 4;
	}

	@Override
	public boolean isDoor() {
		return false;
	}
	
	@Override
	public boolean isObject() {
		return true;
	}

}
