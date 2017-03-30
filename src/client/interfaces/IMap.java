package client.interfaces;

import java.util.List;

import client.Case;

public interface IMap {
	int getLargeur();
	void setLargeur(int valeur);
	int getHauteur();
	void setHauteur(int valeur);
	int getPositionPersonageX();
	int getPositionPersonageY();
	void setPositionPersonageX(int valeur);
	void setPositionPersonageY(int valeur);
	void setHero(IPersonnage heros);
	void setVilain(IPersonnage vilain);
	Case getCase(int x, int y);
	IPersonnage getEnnemi(int x, int y);
	public List<IPersonnage> getEnnemis();
	public void setEnnemis(List<IPersonnage> ennemis);
	void deplacerDroite();
	void deplacerGauche();
	void deplacerHaut();
	void deplacerBas();


	
}
