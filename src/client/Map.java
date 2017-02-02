package client;

import java.util.ArrayList;;


public class Map {
	private ArrayList<ArrayList<Case>> carte;
	
	public Case getCase(int x, int y){
		return carte.get(x).get(y);		
	}
}
