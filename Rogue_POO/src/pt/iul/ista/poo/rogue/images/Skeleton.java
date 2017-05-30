package pt.iul.ista.poo.rogue.images;

import pt.iul.ista.poo.rogue.utils.Position;

public class Skeleton extends Image {
	
	private Position position;

	public Skeleton(Position position) {
		super(position);
		this.position = position;
	}
	
	@Override
	public String getName() {
		return "Skeleton";
	}
	
	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public boolean canMove() {
		return false;
	}

	@Override
	public int priority() {
		return 5;
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
