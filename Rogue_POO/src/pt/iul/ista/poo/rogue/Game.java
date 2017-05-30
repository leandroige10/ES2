package pt.iul.ista.poo.rogue;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import pt.iul.ista.poo.gui.ImageMatrixGUI;
import pt.iul.ista.poo.gui.ImageTile;
import pt.iul.ista.poo.rogue.images.Black;
import pt.iul.ista.poo.rogue.images.Floor;
import pt.iul.ista.poo.rogue.images.Hero;
import pt.iul.ista.poo.rogue.images.Image;
import pt.iul.ista.poo.rogue.utils.Direction;
import pt.iul.ista.poo.rogue.utils.Position;

public class Game implements Observer {

	public String fileName = "room2.txt";
	
	Room room = new Room();
	Hero hero = new Hero(new Position(3,4));

	
	List<ImageTile> tiles1 = new ArrayList<ImageTile>();
	List<ImageTile> tilesFloor = new ArrayList<ImageTile>();
	List<ImageTile> tilesStatus = new ArrayList<ImageTile>();
	List<String> opLines = new ArrayList<String>();
	List<Image> images1 = new ArrayList<Image>();
	
	ImageTile[] objects = new ImageTile[3];
	
	ImageMatrixGUI gui = ImageMatrixGUI.getInstance();
	

	public Game(ImageMatrixGUI gui) { 
		
		setLists();
		gui.newStatusImages(tilesStatus);
		gui.update();
	}
	
	public void setLists(){
		try {
			room.roomFile(fileName);
		} catch (IOException e) {
			System.out.println("Erro no Mapa de Jogo");
		}
		room.setTiles();
		opLines.addAll(room.getOp());
		images1.addAll(room.getImages());
		images1.add(hero);
		for(Image images : images1){
			tiles1.add((ImageTile)images);
		}
		for(int i = 0; i < 10 ; i++){
			for(int j = 0; j < 10 ; j++){
				tilesFloor.add(new Floor(new Position(i,j)));
			}
		}
		
		for (int i = 0; i <= 9; i++) {
			tilesStatus.add(new Black(new Position(i, 0)));
		}
		gui.newImages(tilesFloor);
		gui.newImages(tiles1);
		gui.update();
	}
	
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		Integer keyCode = (Integer) arg1;
		
		switch (keyCode) {
		case KeyEvent.VK_DOWN:
			Position heroDown = hero.getPosition().plus(Direction.DOWN.asVector());
			if(hero.cantMoving(heroDown, images1)){
				break;
			}
			hero.move(Direction.DOWN.asVector());
			gui.update();
			verify();
			break;
		case KeyEvent.VK_UP:
			Position heroUp = hero.getPosition().plus(Direction.UP.asVector());
			if(hero.cantMoving(heroUp, images1)){
				break;
			}
			hero.move(Direction.UP.asVector());
			gui.update();
			verify();
			break;
		case KeyEvent.VK_RIGHT:
			Position heroRight = hero.getPosition().plus(Direction.RIGHT.asVector());
			if(hero.cantMoving(heroRight, images1)){
				break;
			}
			hero.move(Direction.RIGHT.asVector());
			gui.update();
			verify();
			break;
		case KeyEvent.VK_LEFT:
			Position heroLeft = hero.getPosition().plus(Direction.LEFT.asVector());
			if(hero.cantMoving(heroLeft, images1)){
				break;
			}
			hero.move(Direction.LEFT.asVector());
			gui.update();
			verify();
			break;
		case KeyEvent.VK_1:
			leaveObject(1);
			break;
		case KeyEvent.VK_2:
			leaveObject(2);
			break;
		case KeyEvent.VK_3:
			leaveObject(3);
			break;
		}
	}

	private void verify() {
		ImageTile tileIn;
		Image imageIn;
		tileIn = hero.intersect(tiles1);
		imageIn = (Image) tileIn;
		if(imageIn != null){
			if(imageIn.isDoor()){
				newRoom(imageIn);
			}
			if(imageIn.isObject()){
				catchObject(imageIn);
			}
			
		}
	}
	
	public void newRoom(Image imageIn){

		for(String string :opLines){
			String[] tokens = string.split(" ");
			for(int i = 0; i < tokens.length;i++){
				if(i == 2){
					fileName = tokens[i];
				}
			}
		}
		clearRoom();
		setLists();
		Position posit = new Position(4,9);
		hero.setPosition(posit);
		gui.update();
	}
	
	public void clearRoom(){
		tiles1.clear();
		images1.clear();
		opLines.clear();
		tilesFloor.clear();
		gui.clearImages();
	}
	
	private void catchObject(Image imageIn) {
		Iterator<ImageTile> iteratorT = tiles1.iterator();
		while(iteratorT.hasNext()){
			ImageTile imageTile = iteratorT.next();
			if(objects[objects.length-1] == null){
				if(imageTile.equals(imageIn)){
					iteratorT.remove();
					gui.removeImage(imageTile);
					gui.update();
					for(int i = 0; i < objects.length; i ++){
						if(objects[i] == null){
							imageIn.setPosition(new Position(7+i,0));
							imageTile = (ImageTile)imageIn;
							objects[i] = imageTile;
							tilesStatus.add(objects[i]);
							gui.addStatusImage(objects[i]);
							gui.update();
							break;
						}
						else
							continue;
					}	
				}
			}
		}
	}
	public void leaveObject(int i){
		if(objects[i-1] != null){
			Image image = (Image)objects[i-1];
			image.setPosition(hero.getPosition());
			Iterator<ImageTile> iteratorT = tilesStatus.iterator();
			while(iteratorT.hasNext()){
				ImageTile imageTile = iteratorT.next();
				if(imageTile.equals(image)){
					iteratorT.remove();
					objects[i-1]= null;
					gui.removeStatusImage(imageTile);
					gui.update();
				}
			}
			tiles1.add((ImageTile)image);
			images1.add(image);
			gui.addImage((ImageTile)image);
			gui.update();
		}
	}
}
