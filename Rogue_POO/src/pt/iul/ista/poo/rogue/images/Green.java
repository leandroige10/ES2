package pt.iul.ista.poo.rogue.images;

import pt.iul.ista.poo.rogue.utils.Position;

public class Green extends Image {

	public Green(Position position){
		super (position);
	}

	@Override
	public String getName() {
		return "Green";
	}

	@Override
	public boolean canMove() {
		return false;
	}

	@Override
	public int priority() {
		return 2;
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
