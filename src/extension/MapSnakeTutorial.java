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
import client.interfaces.IMap;
import client.interfaces.IPersonnage;
import framework.PartieProvider;

////////////////////////////////////////////////////////////////////////////////
////////////////////CLASSE EXPLIQUEE DANS LE TUTORIAL DU RAPPORT////////////////
//////CF section du rapport : Implémentation de l’interface ”IMap"//////////////
////////////////////////////////////////////////////////////////////////////////

/**
 * Classe MapSnakeTutorial. Classe implémentent l'interface IMap 
 *  
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vallée
 *
 */
public class MapSnakeTutorial implements IMap{
	private IPersonnage heros; // qui represente la tête de votre serpent
	private Case[][] cases; // qui représente les différentes cases de votre map
	private int largeur=20;  // qui représente la largeur de votre map
	private int hauteur=20; // qui représente la hauteur de votre map
	private List<IPersonnage> ennemis;// qui représente la liste des différents bonbons, dans notre démonstration, nous en auront qu'un seul
	private LinkedList<Integer> corpsMonstreX; // qui représente le plus simplement une liste chainée des positions x du corps
	private LinkedList<Integer> corpsMonstreY; // qui représente le plus simplement une liste chainée des positions y du corps
	private boolean up = false; // qui représente lorsque le snake level up (mange un bonbon)
	private IPersonnage partieCorps; // qui servira d'apparence pour le corps
	private Evenement dernierEvt = new Evenement(Evenement.DROITE); // qui représente le déplacement par défaut (dernier déplacement initialisé à droite)
	
	/**
	 * Constructeur de la classe MapSnakeTutorial
	 * 
	 * @return MapSnakeTutorial : la MapSnakeTutorial construite avec :
	 * - ses différentes cases initialisé en herbe (et le contour en Terre)
	 * - initialisation de ses deux listes chainées
	 * - initialisation de sa partieCorps par l'appel de la fonction getPartieQueux
	 * - l'appel de la fonction initialiseEnnemis
	 */
	public MapSnakeTutorial(){
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
		partieCorps = getPartieQueux();
		initialiseEnnemis();
	}
	
	/**
	 * Permet de retourner un objet de type IPersonnage lié à la configuation 
	 * 
	 * @return IPersonnage : représentant une partie du corps du snake (Qui sera utilisé pour son apparence)
	 */
	private IPersonnage getPartieQueux(){
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return partieQueux;
	}
	
	/**
	 *  Initialise les différents ennemis (dans cette extension, la liste possède un ennemi = un bonbon) lié à la configuration
	 */
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Accesseur de l'attribut largeur
	 * 
	 * @return int : la largeur de la map
	 */
	public int getLargeur() {
		return largeur;
	}

	/**
	 * Permet de retourner un objet de type IPersonnage lié à sa configuation 
	 * 
	 * @return IPersonnage : représentant une partie du corps du snake (Qui sera utilisé pour son apparence)
	 */
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	/**
	 * Getter de l'attribut hauteur
	 * 
 	 * @return int : hauteur 
	 */
	public int getHauteur() {
		return hauteur;
	}

	/**
	 * Setter de l'attribut hauteur de la classe
	 * 
	 * @param hauteur : la nouvelle haute
	 */
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	/**
	 * Getter de l'attribut ennemis
	 * 
 	 * @return List<IPersonnage> : ennemis 
	 */
	public List<IPersonnage> getEnnemis() {
		return ennemis;
	}
	
	/**
	 * Setter de l'attribut ennemis de la classe
	 * 
	 * @param ennemis : la nouvelle liste des ennemis
	 */
	public void setEnnemis(List<IPersonnage> ennemis) {
		this.ennemis = ennemis;
	}

	/**
	 * Accesseur de l'attribut cases
	 * 
	 * @return Case[][] : le tableau de tableau des différentes cases
	 */
	public Case[][] getCases() {
		return cases;
	}

	/**
	 * Setter de l'attribut cases de la classe
	 * 
	 * @param Case[][] : la nouvelle carte
	 */
	public void setCases(Case[][] carte) {
		this.cases = carte;
	}
	
	/**
	 * Setter de la case dans l'attribut cases en position x,y de la classe
	 * 
	 * @param x : Coordonnée x 
	 * @param y : Coordonnée y 
	 * @param _case : Coordonnée _case
	 */
	public void setCase(int x, int y, Case _case){
		cases[x][y] = _case;
	}
	
	/**
	 * Accesseur de la case en position x,y dans l'attribut cases[][]
	 * 
	 * @return Case : case correspondant aux coordonnées x,y, null si elle n'existe pas (Hors limite)
	 */
	public Case getCase(int x, int y){
		if(x >= 0 && y >= 0 && x < getLargeur() && y < getHauteur())
			return cases[x][y];
		else
			return null;
	}
	
	/**
	 * Accesseur du personnage de la case en position x,y dans l'attribut cases[][]
	 * 
	 * @return IPersonnage : Ipersonnage se trouvant sur la case correspondant aux coordonnées x,y, null si elle n'existe pas (Hors limite)
	 */
	public IPersonnage getEnnemi(int x, int y){
		for(IPersonnage pers : ennemis){
			if(pers.getPosX()==x && pers.getPosY() == y){
				return pers;
			}
		}
		return null;
	}
	
	/**
	 * Setter du heros et set le personnage à la bonne case 
	 *  
	 * @param heros : nouveau heros (snake)
	 */
	public void setHero(IPersonnage heros){
		this.heros = heros;
		this.getCase(heros.getPosX(), heros.getPosY()).setPersonnage(heros);
	}
	
	/**
	 * Gère le déplacement vers la droite du snap sur la map
	 * 
	 * @param IPersonnage : perso qui représentera le snake (héros)
	 */
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
	
	/**
	 * Gère le déplacement vers la gauche du snap sur la map
	 * 
	 * @param IPersonnage : perso qui représentera le snake (héros)
	 */
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
	
	/**
	 * Gère le déplacement vers le haut du snap sur la map
	 * 
	 * @param IPersonnage : perso qui représentera le snake (héros)
	 */
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
	
	/**
	 * Gère le déplacement vers le bas du snap sur la map
	 * 
	 * @param IPersonnage : perso qui représentera le snake (héros)
	 */
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
	
	/**
	 * Procédure permettant de detecter des collisions (corps ou mur) et donc de tuer le snake(héros)
 	 * @param perso : IPersonnage
	 */
	private void seMangeOuMur(IPersonnage perso){
		if(!dispoCase(perso.getPosX(), perso.getPosY())){
			perso.setPv(0);
		}
	}
	
	/**
	 * Procédure permetant génèrer une nouvelle position possible pour le bonbon et setPersonnage de l'ancienne case à null
 	 * @param personnage : IPersonnage
	 */
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
	
	/**
	 * Fonction permetant de détecter des collisions (Mur, bordure et corps du snake) en position caseX et caseY
	 * 
 	 * @param caseX : int
 	 * @param caseY : int
 	 * @return boolean : true si la case est disponible, false sinon
	 */
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
	
	/**
	 * Procédure permet d'actualiser la longueur de la queux (corps) du snake 
	 * Si up == true alors ajouter la position du héros sinon supprimer la queux et ajouter la position du héros
	 * Cet appel de procédure est appelé dans chaque deplacement
	 * 
 	 * @param x : int
 	 * @param y : int
	 */
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

	
	/////////////////////////////////////////////////////////////////////////
	/////Fonctions inutiles d'implémenter pour cette extension///////////////
	/////////////////////////////////////////////////////////////////////////
	
	@Override
	public boolean rechargementTexture() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<Case> getCasesAdjacentes(int x, int y){
		List<Case> listCase = new ArrayList<Case>();
		//inutile dans cette extension
		return listCase;
	}

	public int getPositionPersonageX(){
		//inutile dans cette extension
		return 0;
	}
	public int getPositionPersonageY(){
		//inutile dans cette extension
		return 0;
	}
	
	public void setPositionPersonageX(int valeur){
		//inutile dans cette extension
	}
	
	public void setPositionPersonageY(int valeur){
		//inutile dans cette extension
	}
	
	public void setVilain(IPersonnage vilain){
		//Pas besoin d'implémenter
	}
}
