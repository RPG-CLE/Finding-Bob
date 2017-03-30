package extension;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import client.Case;
import client.Jeu;
import client.Personnage;
import client.interfaces.IMap;
import client.interfaces.IPersonnage;
import framework.PartieProvider;

public class Map implements IMap{
	IPersonnage heros;
	IPersonnage vilain;
	private Case[][] cases;
	private int largeur=20;
	private int hauteur=20;
	int positionPersonageY;
	int positionPersonageX;
	List<IPersonnage> ennemis;

	public Map(){
		this.positionPersonageY=2;
		this.positionPersonageX=2;
		this.cases = new Case[largeur][hauteur];
		for (int i = 0; i < this.getLargeur(); i++) {
			for (int j = 0; j < this.getHauteur(); j++) {
				this.setCase(i, j, new Case("Herbe"));
			}
		}
		this.genererMonde(0.09);
		ennemis = new ArrayList<IPersonnage>();
		initialiseEnnemis();
	}
	
	private void initialiseEnnemis(){
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("src/extension/configMap/configListeEnnemis.txt"));
			for(Object key : prop.keySet()){
				IPersonnage ennemi = (IPersonnage) (IPersonnage) PartieProvider.getInstance().getObjetByConfig(IPersonnage.class,
						(String)prop.get(key));
				this.ennemis.add(ennemi);
				this.getCase(ennemi.getPosX(), ennemi.getPosY()).setPersonnage(ennemi);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public int getLargeur() {
		return largeur;
	}


	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}


	public int getHauteur() {
		return hauteur;
	}


	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}


	public Case[][] getCases() {
		return cases;
	}

	public void setCases(Case[][] carte) {
		this.cases = carte;
	}
	
	public void setCase(int x, int y, Case _case){
		cases[x][y] = _case;
	}
	
	public Case getCase(int x, int y){
		if(x >= 0 && y >= 0 && x < getLargeur() && y < getHauteur())
			return cases[x][y];
		else
			return null;
	}
	
	public IPersonnage getEnnemi(int x, int y){
		for(IPersonnage pers : ennemis){
			if(pers.getPosX()==x && pers.getPosY() == y){
				return pers;
			}
		}
		return null;
	}
	
	public List<Case> getCasesAdjacentes(int x, int y){
		List<Case> listCase = new ArrayList<Case>();
		
		if(this.getCase(x, y-1) != null)
			listCase.add(this.getCase(x, y-1));
		if(this.getCase(x, y+1) != null)
			listCase.add(this.getCase(x, y+1));
		if(this.getCase(x-1, y) != null)
			listCase.add(this.getCase(x-1, y));
		if(this.getCase(x+1, y) != null)
			listCase.add(this.getCase(x+1, y));
		
		if(this.getCase(x-1, y-1) != null)
			listCase.add(this.getCase(x-1, y-1));
		if(this.getCase(x+1, y-1) != null)
			listCase.add(this.getCase(x+1, y-1));
		if(this.getCase(x+1, y+1) != null)
			listCase.add(this.getCase(x+1, y+1));
		if(this.getCase(x-1, y+1) != null)
			listCase.add(this.getCase(x-1, y+1));
				
		return listCase;
	}
	

	public int getPositionPersonageX(){
		return heros.getPosX();
	}
	public int getPositionPersonageY(){
		return heros.getPosY();
	}
	
	public void setPositionPersonageX(int valeur){
		positionPersonageX=valeur;
	}
	
	public void setPositionPersonageY(int valeur){
		positionPersonageY=valeur;
	}
	
	public void setHero(IPersonnage heros){
		this.heros = heros;
		heros.setPosX(positionPersonageX);
		heros.setPosY(positionPersonageY);
		this.getCase(heros.getPosX(), heros.getPosY()).setPersonnage(heros);
	}
	
	public void setVilain(IPersonnage vilain){
		this.vilain = vilain;
		this.getCase(vilain.getPosX(), vilain.getPosY()).setPersonnage(vilain);
	}
	
	public void deplacerHeroDroite(){
		if(heros.getPosX()<this.largeur-1){
			if(Jeu.map.getCase(heros.getPosX()+1,heros.getPosY()).isPassable()){
				this.getCase(heros.getPosX(), heros.getPosY()).setPersonnage(null);
				heros.setPosX(heros.getPosX()+1);
				this.getCase(heros.getPosX(), heros.getPosY()).setPersonnage(heros);
			}
		}
		else{
			if(Jeu.map.getCase(0,heros.getPosY()).isPassable()){
				this.getCase(heros.getPosX(), heros.getPosY()).setPersonnage(null);
				heros.setPosX(0);
				this.getCase(heros.getPosX(), heros.getPosY()).setPersonnage(heros);
			}
		}
	}
	public void deplacerHeroGauche(){		
		if(heros.getPosX()>0){
			if(Jeu.map.getCase(heros.getPosX()-1,heros.getPosY()).isPassable()){
				this.getCase(heros.getPosX(), heros.getPosY()).setPersonnage(null);
				heros.setPosX(heros.getPosX()-1);
				this.getCase(heros.getPosX(), heros.getPosY()).setPersonnage(heros);
			}
		}
		else{
			if(Jeu.map.getCase(this.largeur-1,heros.getPosY()).isPassable()){
				this.getCase(heros.getPosX(), heros.getPosY()).setPersonnage(null);
				heros.setPosX(this.largeur-1);
				this.getCase(heros.getPosX(), heros.getPosY()).setPersonnage(heros);
			}
		}
	}
	public void deplacerHeroHaut(){
		if(heros.getPosY()>0){
			if(Jeu.map.getCase(heros.getPosX(),heros.getPosY()-1).isPassable()){
				this.getCase(heros.getPosX(), heros.getPosY()).setPersonnage(null);
				heros.setPosY(heros.getPosY()-1);
				this.getCase(heros.getPosX(), heros.getPosY()).setPersonnage(heros);
			}
		}
		else{
			if(Jeu.map.getCase(heros.getPosX(), this.hauteur-1).isPassable()){
				this.getCase(heros.getPosX(), heros.getPosY()).setPersonnage(null);
				heros.setPosY(this.hauteur-1);
				this.getCase(heros.getPosX(), heros.getPosY()).setPersonnage(heros);
			}
		}
	}
	public void deplacerHeroBas(){
		if(heros.getPosY()<this.hauteur-1){
			if(Jeu.map.getCase(heros.getPosX(),heros.getPosY()+1).isPassable()){
				this.getCase(heros.getPosX(), heros.getPosY()).setPersonnage(null);
				heros.setPosY(heros.getPosY()+1);
				this.getCase(heros.getPosX(), heros.getPosY()).setPersonnage(heros);
			}
		}
		else{
			if(Jeu.map.getCase(heros.getPosX(),0).isPassable()){
				this.getCase(heros.getPosX(), heros.getPosY()).setPersonnage(null);
				heros.setPosY(0);
				this.getCase(heros.getPosX(), heros.getPosY()).setPersonnage(heros);
			}
		}
	}
	
	private void genererMonde(double pourcentage) {
		int caseX, caseY;
		Random random = new Random();

		for (int i = 0; i < pourcentage * this.getHauteur()*this.getLargeur(); i++) {
			caseX = random.nextInt(this.getLargeur());
			caseY = random.nextInt(this.getHauteur());
			
			if(this.getCase(caseX, caseY) == null) continue;
			
			this.getCase(caseX, caseY).setNom("Eau");
			this.getCase(caseX, caseY).setPassable(false);
			
			List<Case> listCase = this.getCasesAdjacentes(caseX, caseY);
			for(Case _case : listCase){
				if(!_case.getNom().equals("Eau")){
					_case.setNom("Terre");
				}
			}

		}

	}
	
	public List<IPersonnage> getEnnemis() {
		return ennemis;
	}

	public void setEnnemis(List<IPersonnage> ennemis) {
		this.ennemis = ennemis;
	}
}
