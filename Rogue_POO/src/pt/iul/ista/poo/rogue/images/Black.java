package pt.iul.ista.poo.rogue.images;

import pt.iul.ista.poo.rogue.utils.Position;

public class Black extends Image {
	
	public Black(Position position){
		super (position);
	}
	
	@Override
	public String getName() {
		return "Black";
	}
	
	@Override
	public boolean canMove() {
		return false;
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
