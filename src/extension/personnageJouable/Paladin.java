package extension.personnageJouable;

import client.interfaces.IPersonnage;

public class Paladin implements IPersonnage{
	
	private double pv; // Les points de vie du perso
	private double force;
	private String nom;
	private int pos_x = 0;
	private int pos_y = 0;
	
	public Paladin(){
		;
	}
	
	public Paladin(double pv, double force, String nom, int x, int y) {
		super();
		this.pv = pv;
		this.force = force;
		this.nom = nom;
		this.pos_x=x;
		this.pos_y=y;
	}
	
	/* (non-Javadoc)
	 * @see client.IPersonnage#getPv()
	 */
	@Override
	public double getPv() {
		return pv;
	}
	/* (non-Javadoc)
	 * @see client.IPersonnage#setPv(double)
	 */
	@Override
	public void setPv(double pv) {
		this.pv = pv;
	}
	/* (non-Javadoc)
	 * @see client.IPersonnage#getForce()
	 */
	@Override
	public double getForce() {
		return force;
	}
	/* (non-Javadoc)
	 * @see client.IPersonnage#setForce(double)
	 */
	@Override
	public void setForce(double force) {
		this.force = force;
	}
	/* (non-Javadoc)
	 * @see client.IPersonnage#getNom()
	 */
	@Override
	public String getNom() {
		return nom;
	}
	/* (non-Javadoc)
	 * @see client.IPersonnage#setNom(java.lang.String)
	 */
	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/* (non-Javadoc)
	 * @see client.IPersonnage#setPos(int, int)
	 */
	@Override
	public void setPos(int x,int y){
		this.pos_x = x;
		this.pos_y = y;
	}
	
	/* (non-Javadoc)
	 * @see client.IPersonnage#getX()
	 */
	@Override
	public int getX(){
		return pos_x;
	}
	
	/* (non-Javadoc)
	 * @see client.IPersonnage#getY()
	 */
	@Override
	public int getY(){
		return pos_y;
	}
	
	/* (non-Javadoc)
	 * @see client.IPersonnage#deplacer(java.lang.String)
	 */
	@Override
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
	
	/* (non-Javadoc)
	 * @see client.IPersonnage#toString()
	 */
	@Override
	public String toString() {
		return "Personnage [pv=" + pv + ", force=" + force + ", nom=" + nom
				+ "]";
	}
	
	
}
