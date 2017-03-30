package extension;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import client.Evenement;
import client.Jeu;
import client.interfaces.IAJ;
import client.interfaces.IPersonnage;

public class ActionJeuSnakeTutorial implements IAJ {
	long lastTurn;
	
	public void ActionJeu() {
		lastTurn = System.currentTimeMillis();
	}

	@Override
	public boolean action(Jeu j) {
		try {
			TimeUnit.MILLISECONDS.sleep(400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		Evenement evt = j.getEntree().lireEntree();
		if (evt != null){
			j.getHero().doAction(ActionDeplacer.class, evt);
		}else{
			j.getHero().setPv(99);
			j.getMap().deplacerDroite(j.getHero());
			if(j.getHero().getPv()>0){
				j.getHero().setPv(10);
			}
		}
		
		
		
		IPersonnage ennemi= (IPersonnage) j.getMap().getEnnemi(j.getHero().getPosX(), j.getHero().getPosY());
		
		if (ennemi!=null) {
			System.out.println("Miam");
			Jeu.map.removePersonnage(ennemi);
			double vie_hero = j.getHero().getPv();
			Jeu.map.getCase(j.getHero().getPosX(), j.getHero().getPosY()).setPersonnage(j.getHero());
		}
		if (j.getHero().getPv() < 1){
			j.setGameOn(false);
		}

		j.afficher();
		return j.getGameOn();
	}
}
