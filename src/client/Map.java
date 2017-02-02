package client;

public class Map {
	private Case[][] carte;
	
	public Map(int largeur, int hauteur){
		this.carte = new Case[largeur][hauteur];
	}
	
	public Case getCase(int x, int y){
		return carte[x][y];
	}
}
