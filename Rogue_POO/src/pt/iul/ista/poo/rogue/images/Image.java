package pt.iul.ista.poo.rogue.images;

import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.rogue.utils.Position;

public abstract class Image implements ImageTile, Images{
	
	private Position position;
	private String name;
	private boolean move;
	private int priority;
	private boolean object;
	
	
	public Image(Position position) {
		this.position = position;
	}
	
	public void setPosition(Position position){
		this.position = position;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Position getPosition() {
		return position;
	}
	
	@Override
	public boolean canMove(){
		return move;
	}
	
	@Override
	public int priority(){
		return priority;
	}
	
	@Override
	public boolean isObject() {
		return object;
	}
}
