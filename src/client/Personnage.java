package client;

public class Personnage extends Element{
	
	private double pv; // Les point de vie du perso
	private double force;
	private String nom;
	
	
	public Personnage(double pv, double force, String nom) {
		super();
		this.pv = pv;
		this.force = force;
		this.nom = nom;
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
	
	
	
	@Override
	public String toString() {
		return "Personnage [pv=" + pv + ", force=" + force + ", nom=" + nom
				+ "]";
	}
	
	
}
