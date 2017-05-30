package pt.iul.ista.poo.rogue.images;

import pt.iul.ista.poo.rogue.utils.Position;

public class Sword extends Image {
	
	Position position;
	
	public Sword(Position position){
		super (position);
		this.position= position;
	}

	@Override
	public String getName() {
		return "Sword";
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
