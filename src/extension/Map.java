package extension;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import client.Case;
import client.Personnage;
import client.interfaces.IMap;
import client.interfaces.IPersonnage;

public class Map implements IMap{
	IPersonnage heros;
	IPersonnage vilain;
	private Case[][] cases;
	private int largeur=20;
	private int hauteur=20;
	int positionPersonageY;
	int positionPersonageX;
	List<Personnage> ennemis;
	
	public Map(){
		System.out.println("je passssseee");

		this.cases = new Case[largeur][hauteur];
		for (int i = 0; i < this.getLargeur(); i++) {
			for (int j = 0; j < this.getHauteur(); j++) {
				this.setCase(i, j, new Case("Herbe"));
			}
		}
		this.genererMonde(0.09);
		Personnage ennemis1 = new Personnage(10, 10, "monstraquatique", 8,8);
		Personnage ennemis2 = new Personnage(10, 10, "monstraquatique", 9,9);
		this.ennemis = new ArrayList<Personnage>();
		this.ennemis.add(ennemis1);
		this.ennemis.add(ennemis2);
	
		this.getCase(this.ennemis.get(0).getPosX(), this.ennemis.get(0).getPosY()).setPersonnage(this.ennemis.get(0));
		this.getCase(this.ennemis.get(1).getPosX(), this.ennemis.get(1).getPosX()).setPersonnage(this.ennemis.get(1));
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
	
	private void genererMonde(double pourcentage) {
		int caseX, caseY;
		Random random = new Random();

		System.out.println(pourcentage * this.getHauteur()*getLargeur());
		for (int i = 0; i < pourcentage * this.getHauteur()*this.getLargeur(); i++) {
			caseX = random.nextInt(this.getLargeur());
			caseY = random.nextInt(this.getHauteur());
			
			if(this.getCase(caseX, caseY) == null) continue;
			
			this.getCase(caseX, caseY).setNom("Eau");
			
			List<Case> listCase = this.getCasesAdjacentes(caseX, caseY);
			for(Case _case : listCase){
				if(!_case.getNom().equals("Eau")){
					_case.setNom("Terre");
				}
			}

		}

	}
}
