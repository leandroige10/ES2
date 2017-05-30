package pt.iul.ista.poo.rogue.images;

import pt.iul.ista.poo.rogue.utils.Position;
public class DoorWay extends Image {
	
	public String newRoom;
	
	public DoorWay(Position position){
		super (position);
	}

	@Override
	public String getName() {
		return "DoorWay";
	}

	@Override
	public boolean canMove() {
		return true;
	}

	@Override
	public int priority() {
		return 2;
	}

	@Override
	public boolean isDoor() {
		return true;
	}
	
	@Override
	public boolean isObject() {
		return false;
	}
	
	public void setNewRoom(String fileName){
		this.newRoom = fileName;
		System.out.println(newRoom);
	}
}
