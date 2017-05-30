package pt.iul.ista.poo.rogue.tests;

import org.junit.Assert;
import org.junit.Test;

import pt.iul.ista.poo.rogue.utils.Direction;
import pt.iul.ista.poo.rogue.utils.Vector2D;

public class DirectionTest {

	@Test
	public void testAsVector() {
		Assert.assertEquals(Direction.UP.asVector().getY(), new Vector2D(0, -1).getY());
		Assert.assertEquals(Direction.DOWN.asVector().getY(), new Vector2D(0, 1).getY());
		Assert.assertEquals(Direction.LEFT.asVector().getX(), new Vector2D(-1, 0).getX());
		Assert.assertEquals(Direction.RIGHT.asVector().getX(), new Vector2D(1, 0).getX());
	}

}
