package client;

public class Map {
	private Case[][] carte;
	
	public Case getCase(int x, int y){
		return carte[x][y];
	}
}
