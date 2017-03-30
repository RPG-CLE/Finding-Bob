package extension;

import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

import client.*;
import client.interfaces.IAJ;
import client.interfaces.IEntreeUtilisateur;
import client.interfaces.IPersonnage;

public class ActionJeu implements IAJ {
	public ActionJeu() {
	}

	@Override
	public boolean action(Jeu j) {
		// TODO Auto-generated method stub
		Evenement evt = j.getEntree().lireEntree();
		if (evt != null){
			j.getHero().doAction(ActionDeplacer.class, evt);
			for(IPersonnage ennemi:j.getMap().getEnnemis()){
				
		    	Random random = new Random();
		    	int result = random.nextInt(4);
		    	Evenement evntEnnemi = new Evenement(result);
		    	ennemi.doAction(ActionDeplacer.class, evntEnnemi);
		    }
		}
		
	    
		
		IPersonnage ennemi= (IPersonnage) j.getMap().getEnnemi(j.getHero().getPosX(), j.getHero().getPosY());
		if (ennemi!=null&&ennemi.getPv()>0) {
			System.out.println("Votre Héro entre en Combat !!");
			double force_hero = j.getHero().getForce();
			double force_ennemi = ennemi.getForce();
			double vie_hero = j.getHero().getPv();
			double vie_ennemi = ennemi.getPv();
			while (vie_hero > 0 && vie_ennemi > 0) {
				System.out.println("Vie ennemi = " + vie_ennemi + "-"
						+ force_hero);
				vie_ennemi -= force_hero;
				if (vie_ennemi > 0) {
					System.out.println("Vie vie_hero = " + vie_hero + "-"
							+ force_ennemi);
					vie_hero -= force_ennemi;
				}
			}
			if (vie_hero < 1) {
				System.out.println("Votre hero est mort.");
			} else {
				System.out.println("Vous avez tué l'énnemi et il vous reste "
						+ vie_hero + " pv.");
				Jeu.map.removePersonnage(ennemi);
				Jeu.map.getCase(j.getHero().getPosX(), j.getHero().getPosY()).setPersonnage(j.getHero());
			}
			j.getHero().setPv(vie_hero);
			//ennemi.setPv(vie_ennemi);
		}
		if (j.getHero().getPv() < 1){
			j.setGameOn(false);
			return false;
		}
		j.afficher();
		return true;
	}

}
