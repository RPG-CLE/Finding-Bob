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
				if(getPosY()!=0){
					if(!Jeu.map.getCase(getPosX(),getPosY()-1).isPassable())return;
					Jeu.map.getCase(getPosX(),getPosY()).setPersonnage(null);
					setPos(getPosX(),getPosY()-1);
					Jeu.map.getCase(getPosX(),getPosY()).setPersonnage(this);
				}
				break;
			case "bas":  //TODO;
				if(getPosY()!=Jeu.map.getLargeur()){
					if(!Jeu.map.getCase(getPosX(),getPosY()+1).isPassable())return;
					Jeu.map.getCase(getPosX(),getPosY()).setPersonnage(null);
					setPos(getPosX(),getPosY()+1);
					Jeu.map.getCase(getPosX(),getPosY()).setPersonnage(this);
				}
			    break;
			case "gauche":  //TODO;
				if(getPosX()!=0){
					if(!Jeu.map.getCase(getPosX()-1,getPosY()).isPassable())return;
					Jeu.map.getCase(getPosX(),getPosY()).setPersonnage(null);
					setPos(getPosX()-1,getPosY());
					Jeu.map.getCase(getPosX(),getPosY()).setPersonnage(this);
				}
			    break;
			case "droite":  //TODO;
				if(getPosX()!=Jeu.map.getHauteur()){
					if(!Jeu.map.getCase(getPosX()+1,getPosY()).isPassable())return;
					Jeu.map.getCase(getPosX(),getPosY()).setPersonnage(null);
					setPos(getPosX()+1,getPosY());
					Jeu.map.getCase(getPosX(),getPosY()).setPersonnage(this);
				}
			    break;
			default: //TODO invalide direction;
			    break;
		}
	}
	
	public void addAction(Class<? extends IAction> cl, IAction action){
		actions.put(cl, action);
		
	}
	
	public void doAction(Class<? extends IAction> cl, Evenement evt){
		actions.get(cl).action(this, evt);
		
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
