package extension.personnageJouable;
import client.interfaces.IPersonnage;
public class Voleur implements IPersonnage {
	
	private double pv; // Les points de vie du perso
	private double force;
	private String nom;
	private int posX = 0;
	private int posY = 0;
	
	public Voleur(){
		super();
		this.pv=6;
		this.force=9;
		this.nom="DefaultVoleur";
		this.posX=0;
		this.posY=0;
	}
	
	public Voleur(double pv, double force, String nom, int x, int y) {
		super();
		this.pv = pv;
		this.force = force;
		this.nom = nom;
		this.posX=x;
		this.posY=y;
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
		this.posX = x;
		this.posY = y;
	}
	
	/* (non-Javadoc)
	 * @see client.IPersonnage#getX()
	 */
	@Override
	public int getPosX(){
		return posX;
	}
	

	public void setPosX(int x){
		posX = x;
	}
	
	/* (non-Javadoc)
	 * @see client.IPersonnage#getY()
	 */
	@Override
	public int getPosY(){
		return posY;
	}
	
	
	public void setPosY(int y){
		posY = y;
	}
	
	/* (non-Javadoc)
	 * @see client.IPersonnage#deplacer(java.lang.String)
	 */
	@Override
	public void deplacer(String deplacement){
		switch (deplacement) {
			case "haut":  //TODO;
				setPos(this.posX,this.posY-1);
				break;
			case "bas":  //TODO;
				setPos(this.posX,this.posY+1);
			    break;
			case "gauche":  //TODO;
				setPos(this.posX-1,this.posY);
			    break;
			case "droite":  //TODO;
				setPos(this.posX+1,this.posY);
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



