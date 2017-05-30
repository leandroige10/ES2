package pt.iul.ista.poo.rogue.utils;

/**
 * @author POO2016
 * 
 * Cardinal directions
 *
 */
public enum Direction {
	LEFT, UP, RIGHT, DOWN;
	
	public Vector2D asVector() {
		switch (this){
			case UP:
				return (new Vector2D(0,-1));
			case DOWN:
				return (new Vector2D(0,1));
			case RIGHT:
				return (new Vector2D(1,0));
			case LEFT:
				return (new Vector2D(-1,0));
		}
		return null;
	}
}
