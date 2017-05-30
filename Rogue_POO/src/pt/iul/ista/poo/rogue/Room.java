package pt.iul.ista.poo.rogue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pt.iul.ista.poo.rogue.images.Hammer;
import pt.iul.ista.poo.rogue.images.DoorClosed;
import pt.iul.ista.poo.rogue.images.DoorOpen;
import pt.iul.ista.poo.rogue.images.DoorWay;
import pt.iul.ista.poo.rogue.images.Image;
import pt.iul.ista.poo.rogue.images.Sword;
import pt.iul.ista.poo.rogue.images.Wall;
import pt.iul.ista.poo.rogue.utils.Position;


public class Room {
	
	List<Image> images = new ArrayList<Image>();
	List<String> opLines = new ArrayList<String>();
	
	String[][] map = new String[10][10];
//	char[][] originalMap = new char [10][10];
	
	//Método devolve a matiz de Strings "map" que ira servir para a impressão de 
	//imagens nas posições indicados no ficheiro lido.
	
	public void roomFile (String fileName) throws IOException  {
		
		images.clear();
		opLines.clear();
		
		try{
			String filePath = ("rooms/" + fileName);
			File file = new File (filePath);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			
			int x = 0;
			int y = 0;
			
			//Leitura do ficheiro guardando as linhas de operações na lista de
			//Strings "opLines" e o mapa de jogo na matriz de Strings "map".

			while((line = reader.readLine()) != null){
				if(line.startsWith("#")){
					if(line.endsWith("#")){
					}
					else{
						opLines.add(line.substring(2, line.length()));
					}
				}
				else{
					for (int i = 0; i < line.length(); i++){
						map[x][y] = "" + line.charAt(i);
						//originalMap[x][y] = line.charAt(i);
						x++;
					}
					x = 0;
					y++;				
				}
			}
			reader.close();
			
		}
		catch(FileNotFoundException exception) {
			System.out.println("File Not Found. Sorry!");
		}
	}
	
	public void ops(){
		
		String positionOp = null;
		String typeOp = null;
		String nextLevel = null;
		String distinationOp = null;
		String needsOp = null;
		
		for(String string : opLines){
			String[] tokens = string.split(" ");
			for(int i = 0; i < tokens.length;i++){
				if(i == 0){
					positionOp = tokens[i];
					System.out.println(positionOp);
				}
				if(i == 1 ){
					typeOp = tokens[i];
					System.out.println(typeOp);
				}
				if(i == 2){
					nextLevel = tokens[i];
					System.out.println(nextLevel);
				}
				if(i == 3){
					distinationOp = tokens[i];
					System.out.println(distinationOp);
				}
				if(i == 4){
					needsOp = tokens[i];
					System.out.println(needsOp);
				}
			}
			for(int i = 0; i < map.length; i++){
				for(int j = 0; j < map[i].length; j++){
					if(tokens.length == 5){ //DoorClosed
						if(map[i][j].equals(positionOp)){
							map[i][j] = "d";
						}
					
					}
					if(tokens.length == 4 ){//DoorWay ou DoorOpen
						if(map[i][j].equals(positionOp)){
							map[i][j] = typeOp;
						}
					}
					if(tokens.length == 2){
						//KEY LINE
					}
				}
			}
			System.out.println("Linha Operação: " + string);
		}
	}
	public void setTiles(){
		ops();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				switch (map[i][j]) {
				case "W":
					Wall wall = new Wall (new Position(i,j));
					images.add(wall);
					break;
				case "E":
					images.add(new DoorWay (new Position(i,j)));
					break;
				case "d":
					images.add(new DoorClosed (new Position(i,j)));
					break;
				case "D":
					images.add(new DoorOpen (new Position(i,j)));
					break;
				case "h":
					images.add(new Hammer(new Position(i,j)));
					break;
				case "s":
					images.add(new Sword(new Position(i,j)));
					break;
				}
			}
		}
	}
	
	
	public List<Image> getImages(){
		return images;
	}
	
	public List<String> getOp(){
		return opLines;
	}
}