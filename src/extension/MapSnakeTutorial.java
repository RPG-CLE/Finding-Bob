package extension;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import client.Case;
import client.Evenement;
import client.Jeu;
import client.Personnage;
import client.interfaces.IMap;
import client.interfaces.IPersonnage;
import framework.PartieProvider;

public class MapSnakeTutorial implements IMap{
	IPersonnage heros;
	IPersonnage vilain;
	private Case[][] cases;
	private int largeur=20;
	private int hauteur=20;
	int positionPersonageY;
	int positionPersonageX;
	List<IPersonnage> ennemis;
	private LinkedList<Integer> corpsMonstreX;
	private LinkedList<Integer> corpsMonstreY;
	private boolean up = false;
	private IPersonnage partieCorps;
	Evenement dernierEvt = new Evenement(Evenement.DROITE);

	public MapSnakeTutorial(){
		this.positionPersonageY=2;
		this.positionPersonageX=2;
		this.cases = new Case[largeur][hauteur];
		for (int i = 0; i < this.getLargeur(); i++) {
			for (int j = 0; j < this.getHauteur(); j++) {
				if(i%hauteur==0||j%largeur==0||i==hauteur-1||j==largeur-1){
					this.setCase(i, j, new Case("Terre"));
				}else{
					this.setCase(i, j, new Case("Herbe"));					
				}
			}
		}
		this.corpsMonstreX = new LinkedList<Integer>() ;
		this.corpsMonstreY = new LinkedList<Integer>() ;
		
		ennemis = new ArrayList<IPersonnage>();
		partieCorps = getPartieQueux(0,0);
		initialiseEnnemis();
	}
	
	private void initialiseEnnemis(){
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("src/extension/configMap/configSnakeTutorial.txt"));
			for(Object key : prop.keySet()){
				if(key.toString().equals("bonbonsnake")){
					IPersonnage ennemi = (IPersonnage) (IPersonnage) PartieProvider.getInstance().getObjetByConfig(IPersonnage.class,
							(String)prop.get(key));
					this.ennemis.add(ennemi);
					this.getCase(ennemi.getPosX(), ennemi.getPosY()).setPersonnage(ennemi);		
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private IPersonnage getPartieQueux(int x, int y){
		Properties prop = new Properties();
		IPersonnage partieQueux = null;
		try {
			prop.load(new FileReader("src/extension/configMap/configSnakeTutorial.txt"));
			for(Object key : prop.keySet()){
				if(key.toString().equals("queuxsnake")){
					partieQueux = (IPersonnage) (IPersonnage) PartieProvider.getInstance().getObjetByConfig(IPersonnage.class,
							(String)prop.get(key));
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return partieQueux;
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
	
	public void deplacerDroite(IPersonnage perso){
		int xavant = perso.getPosX();
		int yavant = perso.getPosY();
		boolean goDroite = false;
		if(perso.getPv()==99){
			switch(this.dernierEvt.getEvenement()){
				case Evenement.HAUT :
					this.deplacerHaut(perso);
					break;
				case Evenement.BAS :
					this.deplacerBas(perso);
					break;
				case Evenement.GAUCHE :
					this.deplacerGauche(perso);
					break;
				case Evenement.DROITE :
					goDroite= true;
				break;
			}
		}else{
			goDroite=true;
		}
		if(goDroite){
			this.dernierEvt = new Evenement(Evenement.DROITE);
			this.getCase(perso.getPosX(), perso.getPosY()).setPersonnage(null);
			perso.setPosX(perso.getPosX()+1);
			this.getCase(perso.getPosX(), perso.getPosY()).setPersonnage(perso);
		}
		seMangeOuMur(perso);
		actualise(xavant,yavant);
	}
	public void deplacerGauche(IPersonnage perso){
		this.dernierEvt = new Evenement(Evenement.GAUCHE);
		int xavant = perso.getPosX();
		int yavant = perso.getPosY();
		
		this.getCase(perso.getPosX(), perso.getPosY()).setPersonnage(null);
		perso.setPosX(perso.getPosX()-1);
		this.getCase(perso.getPosX(), perso.getPosY()).setPersonnage(perso);

		seMangeOuMur(perso);
		actualise(xavant,yavant);
	}
	public void deplacerHaut(IPersonnage perso){
		this.dernierEvt = new Evenement(Evenement.HAUT);
		int xavant = perso.getPosX();
		int yavant = perso.getPosY();

		this.getCase(perso.getPosX(), perso.getPosY()).setPersonnage(null);
		perso.setPosY(perso.getPosY()-1);
		this.getCase(perso.getPosX(), perso.getPosY()).setPersonnage(perso);

		seMangeOuMur(perso);
		actualise(xavant,yavant);
	}
	public void deplacerBas(IPersonnage perso){
		this.dernierEvt = new Evenement(Evenement.BAS);
		int xavant = perso.getPosX();
		int yavant = perso.getPosY();

		this.getCase(perso.getPosX(), perso.getPosY()).setPersonnage(null);
		perso.setPosY(perso.getPosY()+1);
		this.getCase(perso.getPosX(), perso.getPosY()).setPersonnage(perso);

		seMangeOuMur(perso);
		actualise(xavant,yavant);
	}
	
	private void seMangeOuMur(IPersonnage perso){
		if(!dispoCase(perso.getPosX(), perso.getPosY())){
			perso.setPv(0);
		}
	}
	private void genererMonde(double pourcentage) {
	}
	
	public List<IPersonnage> getEnnemis() {
		return ennemis;
	}

	public void setEnnemis(List<IPersonnage> ennemis) {
		this.ennemis = ennemis;
	}

	@Override
	public void removePersonnage(IPersonnage personnage){
		this.up=true;
		cases[personnage.getPosX()][personnage.getPosY()].setPersonnage(null);
		Random random = new Random();
		int caseX = random.nextInt(this.getLargeur());
		int caseY = random.nextInt(this.getHauteur());
		while(!dispoCase(caseX,caseY)){
			random = new Random();
			caseX = random.nextInt(this.getLargeur()-1);
			caseY = random.nextInt(this.getHauteur()-1);
			if(caseX==0)
				caseX++;
			if(caseY==0)
				caseY++;
		}
		this.getCase(ennemis.get(0).getPosX(),ennemis.get(0).getPosY()).setPersonnage(null);
		ennemis.get(0).setPos(caseX, caseY);
		this.getCase(caseX,caseY).setPersonnage(ennemis.get(0));
	}
	
	
	private boolean dispoCase(int caseX, int caseY){
		int posx = 0;
		int posy = 0;
		Iterator itrX = this.corpsMonstreX.iterator();
		Iterator itrY = this.corpsMonstreY.iterator();
		if(caseX==0||(caseX==this.largeur-1)||caseY==0||(caseY==this.hauteur-1)){
			return false;
		}
		while(itrX.hasNext()){
			posx = ((int) itrX.next());
			posy = ((int) itrY.next());
			if((posx==caseX) && (posy==caseY)){
				return false;
			}
		}
		return true;
	}
	
	private void actualise(int x, int y){
		if(!this.up){
			if(this.corpsMonstreX.size()>0){
				int posXCase = this.corpsMonstreX.getLast();
				int posYCase = this.corpsMonstreY.getLast();
				this.getCase(posXCase, posYCase).setPersonnage(null);
				this.corpsMonstreX.removeLast();
				this.corpsMonstreY.removeLast();
				
				this.corpsMonstreX.addFirst(x);
				this.corpsMonstreY.addFirst(y);
				this.getCase(x, y).setPersonnage(partieCorps);
			}
		}else{
			this.corpsMonstreX.addFirst(x);
			this.corpsMonstreY.addFirst(y);
			this.getCase(x, y).setPersonnage(partieCorps);
		}
		this.up = false;

	}

	@Override
	public boolean rechargementTexture() {
		// TODO Auto-generated method stub
		return false;
	}
}
