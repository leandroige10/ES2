package pt.iul.ista.poo.rogue.images;

import pt.iul.ista.poo.rogue.utils.Position;

public class Wall extends Image {
	
	
	public Wall(Position position){
		super (position);
	}

	@Override
	public String getName() {
		return "Wall";
	}

	@Override
	public boolean canMove() {
		return false;
	}

	@Override
	public int priority() {
		return 6;
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
