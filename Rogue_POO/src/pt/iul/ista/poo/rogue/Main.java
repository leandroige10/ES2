package pt.iul.ista.poo.rogue;

import pt.iul.ista.poo.gui.ImageMatrixGUI;

public class Main {

	public static void main(String[] args) {
		ImageMatrixGUI gui = ImageMatrixGUI.getInstance();
		gui.setName("Rogue");
		gui.addObserver(new Game(gui));
		gui.go();
	}
}
