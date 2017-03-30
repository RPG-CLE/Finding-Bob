package extension;

import java.util.List;

import client.Case;
import client.interfaces.IMap;
import client.interfaces.IPersonnage;

public class GestionnaireDeMap implements IMap {
	
	Map mapCourante;
	boolean changement;
	
	public GestionnaireDeMap(){
		mapCourante = new Map();
		changement = false;
	}
	
	private void changementDeCarte(){
		if(mapCourante.changementDeCarte()){
			Map tmp = new Map();
			tmp.setHero(mapCourante.getHero());
			mapCourante = tmp;
			changement = true;
		}
	}

	@Override
	public int getLargeur(){
		return mapCourante.getLargeur();
	}

	@Override
	public void setLargeur(int valeur) {
		mapCourante.setLargeur(valeur);

	}

	@Override
	public int getHauteur() {
		return mapCourante.getHauteur();
	}

	@Override
	public void setHauteur(int valeur) {
		mapCourante.setHauteur(valeur);

	}

	@Override
	public int getPositionPersonageX() {
		return mapCourante.getPositionPersonageX();
	}

	@Override
	public int getPositionPersonageY() {
		return mapCourante.getPositionPersonageY();
	}

	@Override
	public void setPositionPersonageX(int valeur) {
		mapCourante.setPositionPersonageX(valeur);

	}

	@Override
	public void setPositionPersonageY(int valeur) {
		mapCourante.setPositionPersonageY(valeur);

	}

	@Override
	public void setHero(IPersonnage heros) {
		mapCourante.setHero(heros);

	}

	@Override
	public void setVilain(IPersonnage vilain) {
		mapCourante.setVilain(vilain);

	}

	@Override
	public Case getCase(int x, int y) {
		return mapCourante.getCase(x, y);
	}

	@Override
	public IPersonnage getEnnemi(int x, int y) {
		return mapCourante.getEnnemi(x, y);
	}

	@Override
	public List<IPersonnage> getEnnemis() {
		return mapCourante.getEnnemis();
	}

	@Override
	public void setEnnemis(List<IPersonnage> ennemis) {
		mapCourante.setEnnemis(ennemis);

	}

	@Override
	public void deplacerDroite(IPersonnage perso) {
		mapCourante.deplacerDroite(perso);
		if(perso == mapCourante.getHero())
			changementDeCarte();

	}

	@Override
	public void deplacerGauche(IPersonnage perso) {
		mapCourante.deplacerGauche(perso);
		if(perso == mapCourante.getHero())
			changementDeCarte();

	}

	@Override
	public void deplacerHaut(IPersonnage perso) {
		mapCourante.deplacerHaut(perso);
		if(perso == mapCourante.getHero())
			changementDeCarte();

	}

	@Override
	public void deplacerBas(IPersonnage perso) {
		mapCourante.deplacerBas(perso);
		if(perso == mapCourante.getHero())
			changementDeCarte();

	}

	@Override
	public void removePersonnage(IPersonnage personnage) {
		mapCourante.removePersonnage(personnage);

	}
	
	public boolean rechargementTexture(){
		if(changement){
			changement = false;
			return true;
		}
		else{
			return false;
		}
	}
	
	

}
