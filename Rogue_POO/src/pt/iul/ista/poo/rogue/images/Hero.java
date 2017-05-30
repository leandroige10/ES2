package pt.iul.ista.poo.rogue.images;

import java.util.List;

import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.rogue.utils.Position;
import pt.iul.ista.poo.rogue.utils.Vector2D;

public class Hero extends Image {

	private Position position;

	public Hero(Position position) {
		super (position);
		this.position = position;
	}

	@Override
	public String getName() {
		return "Hero";
	}
	
	//Método que recebe um vector2d e o adiciona à posição do Hero.

	public void move(Vector2D vector2d) {

		int x = this.position.getX() + vector2d.getX();
		int y = this.position.getY() + vector2d.getY();
		if (x < 0)
			x = 0;
		if (y < 0)
			y = 0;
		if (x > 9)
			x = 9;
		if (y > 9)
			y = 9;

		this.position = new Position(x, y);
		System.out.println(position);
	}
	
	//Metódo que verifica se existe uma Wall ou um outro tile como por exemplo uma 
	//DoorWay e retorna verdadeiro ou falso conforme se verifique se o Hero se pode
	//movimentar para a posição ou não.
	
	public ImageTile intersect(List<ImageTile> tiles){
		for(ImageTile tile : tiles){
			//if(image.getName().contentEquals("Sword")){
				if(this.position.equals(tile.getPosition())){
					return tile;
					//System.out.println("Sword");
					//return true;
				}
			//}
			//if(image.getName().contentEquals("DoorWay")){
			//	if(newPosition.equals(image.getPosition())){
			//		System.out.println("DoorWay");
					//return false;
			//	}
			//}
		}
		return null;
	}
	
	public boolean cantMoving (Position newPosition, List<Image> images){
		for(Image image : images){
			if(newPosition.equals(image.getPosition())){
				if(image.canMove())
					return false;
				else
					return true;
			}
		}
		return false;
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

	public void newPosition(Position position) {
		this.position = position;
	}
	
	@Override
	public boolean isObject() {
		return false;
	}
}
