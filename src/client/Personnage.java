package client;

public class Personnage{
	
	private double pv; // Les points de vie du perso
	private double force;
	private String nom;
	private int pos_x;
	private int pos_y;
	
	public Personnage(double pv, double force, String nom, int x, int y) {
		super();
		this.pv = pv;
		this.force = force;
		this.nom = nom;
		this.pos_x=x;
		this.pos_y=y;
	}
	
	public double getPv() {
		return pv;
	}
	public void setPv(double pv) {
		this.pv = pv;
	}
	public double getForce() {
		return force;
	}
	public void setForce(double force) {
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setPos(int x,int y){
		this.pos_x = x;
		this.pos_y = y;
	}
	
	public int getX(){
		return pos_x;
	}
	
	public int getY(){
		return pos_y;
	}
	
	public void deplacer(String deplacement){
		switch (deplacement) {
			case "haut":  //TODO;
				setPos(this.pos_x,this.pos_y-1);
				break;
			case "bas":  //TODO;
				setPos(this.pos_x,this.pos_y+1);
			    break;
			case "gauche":  //TODO;
				setPos(this.pos_x-1,this.pos_y);
			    break;
			case "droite":  //TODO;
				setPos(this.pos_x+1,this.pos_y);
			    break;
			default: //TODO invalide direction;
			    break;
		}
	}
	
	@Override
	public String toString() {
		return "Personnage [pv=" + pv + ", force=" + force + ", nom=" + nom
				+ "]";
	}
	
	
}
