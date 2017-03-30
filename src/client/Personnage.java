package client;

import client.interfaces.IAction;
import client.interfaces.IPersonnage;

import java.util.HashMap;
import java.util.Map;

public class Personnage implements IPersonnage{
	
	protected double pv; // Les points de vie du perso
	protected double force;
	protected String nom;
	protected int posX = 0;
	protected int posY = 0;
	protected Map<Class<? extends IAction>,IAction> actions;

	
	public Personnage(){
		actions = new HashMap<Class<? extends IAction>,IAction>();
	}
	
	public Personnage(double pv, double force, String nom, int x, int y) {
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
				Jeu.map.deplacerHeroHaut();
				break;
			case "bas":  //TODO;
				Jeu.map.deplacerHeroBas();
			    break;
			case "gauche":  //TODO;
				Jeu.map.deplacerHeroGauche();
			    break;
			case "droite":  //TODO;
				Jeu.map.deplacerHeroDroite();
			    break;
			default: //TODO invalide direction;
			    break;
		}
	}
	
	public void addAction(Class<? extends IAction> cl, IAction action){
		actions.put(cl, action);
		
	}
	
	public void doAction(Class<? extends IAction> cl, Evenement evt){
		if(actions.containsKey(cl)){
			actions.get(cl).action(this, evt);
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
