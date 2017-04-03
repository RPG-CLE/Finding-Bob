package extension;

import java.util.Random;

import client.*;
import client.interfaces.IAJ;
import client.interfaces.IPersonnage;

public class ActionJeu implements IAJ {
	
	long lastTurn;
	
	public ActionJeu() {
		lastTurn = System.currentTimeMillis();
	}

	@Override
	public boolean action(Jeu j) {
		// TODO Auto-generated method stub
		Evenement evt = j.getEntree().lireEntree();
		if (evt != null){
			j.getHeros().doAction(ActionDeplacer.class, evt);
			
		}   
		
		if(System.currentTimeMillis() - lastTurn > 1000){
			for(IPersonnage ennemi:j.getMap().getEnnemis()){
				if(ennemi.getPosX() == j.getHeros().getPosX() && ennemi.getPosY() == j.getHeros().getPosY()) continue;
		    	Random random = new Random();
		    	int result = random.nextInt(4);
		    	Evenement evntEnnemi = new Evenement(result);
		    	ennemi.doAction(ActionDeplacer.class, evntEnnemi);
		    }
			lastTurn = System.currentTimeMillis();
		}
		
		
		
		IPersonnage ennemi= (IPersonnage) j.getMap().getEnnemi(j.getHeros().getPosX(), j.getHeros().getPosY());
		if (ennemi!=null&&ennemi.getPv()>0) {
			System.out.println("Votre Héros entre en Combat !!");
			double force_hero = j.getHeros().getForce();
			double force_ennemi = ennemi.getForce();
			double vie_hero = j.getHeros().getPv();
			double vie_ennemi = ennemi.getPv();
			while (vie_hero > 0 && vie_ennemi > 0) {
				System.out.println("Vie ennemi = " + vie_ennemi + "-"
						+ force_hero);
				vie_ennemi -= force_hero;
				if (vie_ennemi > 0) {
					System.out.println("Vie du héros = " + vie_hero + "-"
							+ force_ennemi);
					vie_hero -= force_ennemi;
				}
			}
			if (vie_hero < 1) {
				System.out.println("Votre héros est mort.");
			} else {
				System.out.println("Vous avez tué l'ennemi et il vous reste "
						+ vie_hero + " pv.");
				Jeu.map.removePersonnage(ennemi);
				Jeu.map.getCase(j.getHeros().getPosX(), j.getHeros().getPosY()).setPersonnage(j.getHeros());
			}
			j.getHeros().setPv(vie_hero);
			//ennemi.setPv(vie_ennemi);
		}
		if (j.getHeros().getPv() < 1){
			j.setGameOn(false);
		}

		j.afficher();
		return j.getGameOn();
	}

}
