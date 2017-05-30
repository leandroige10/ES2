package pt.iul.ista.poo.rogue.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pt.iul.ista.poo.rogue.utils.Vector2D;

public class Vector2DTest {
	
	private Vector2D vector = new Vector2D(2, 3);
	
	@Before
	public void prepare() {
		
	}
	
	@Test
	public void testConstructor() {
		Assert.assertEquals(2, vector.getX());
		Assert.assertEquals(3, vector.getY());
	}

	@Test
	public void testPlus() {
		Assert.assertEquals(new Vector2D(5, 5).getX(), vector.plus(new Vector2D(3, 2)).getX());
		Assert.assertEquals(new Vector2D(5, 5).getY(), vector.plus(new Vector2D(3, 2)).getY());
		Assert.assertEquals(new Vector2D(0, 0).getX(), vector.plus(new Vector2D(-2, -3)).getX());
		Assert.assertEquals(new Vector2D(0, 0).getY(), vector.plus(new Vector2D(-2, -3)).getY());
	}

	@Test
	public void testMinus() {		
		Assert.assertEquals(new Vector2D(-1, 1).getX(), vector.minus(new Vector2D(3, 2)).getX());
		Assert.assertEquals(new Vector2D(-1, 1).getY(), vector.minus(new Vector2D(3, 2)).getY());
		Assert.assertEquals(new Vector2D(4, 6).getX(), vector.minus(new Vector2D(-2, -3)).getX());
		Assert.assertEquals(new Vector2D(4, 6).getY(), vector.minus(new Vector2D(-2, -3)).getY());
	}

}
