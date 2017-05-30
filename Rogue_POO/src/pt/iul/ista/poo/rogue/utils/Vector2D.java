package pt.iul.ista.poo.rogue.utils;

public class Vector2D {
	
	private int x;
	private int y;

	public Vector2D(int x, int y) {
		this.x = x;
		this.y = y;
		}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	public Vector2D plus(Vector2D vector2d) {
		int newX = x + vector2d.getX();
		int newY = y + vector2d.getY();
		Vector2D newVectorPlus = new Vector2D(newX, newY);

		return newVectorPlus;
	}

	public Vector2D minus(Vector2D vector2d) {
		int newX = x - vector2d.getX();
		int newY = y - vector2d.getY();
		Vector2D newVectorMinus = new Vector2D(newX, newY);

		return newVectorMinus;
	}

}
