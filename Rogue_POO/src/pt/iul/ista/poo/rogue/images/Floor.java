package pt.iul.ista.poo.rogue.images;

import pt.iul.ista.poo.rogue.utils.Position;
public class Floor extends Image {

	public Floor(Position position) {
		super(position);
	}

	@Override
	public String getName() {
		return "Floor";
	}

	@Override
	public boolean canMove() {
		return true;
	}

	@Override
	public int priority() {
		return 1;
	}

	@Override
	public boolean isDoor() {
		return false;
	}
	
	@Override
	public boolean isObject() {
		return false;
	}
}
