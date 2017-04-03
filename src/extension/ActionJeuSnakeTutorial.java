package extension;

import java.util.concurrent.TimeUnit;

import client.Evenement;
import client.Jeu;
import client.interfaces.IAJ;
import client.interfaces.IPersonnage;


////////////////////////////////////////////////////////////////////////////////
////////////////////CLASSE EXPLIQUEE DANS LE TUTORIAL DU RAPPORT////////////////
//////CF section du rapport : Implementation de l’interface ”IAJ"///////////////
////////////////////////////////////////////////////////////////////////////////

/**
 * Classe ActionJeuSnakeTutorial. Classe implémentent l'interface IAJ 
 *  
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vallée
 *
 */
public class ActionJeuSnakeTutorial implements IAJ {
	@Override
	public boolean action(Jeu j) {
		//Sleep permetant de laisser le temps à l'utilisateur pour saisir une nouvelle direction
		try {
			TimeUnit.MILLISECONDS.sleep(400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		Evenement evt = j.getEntree().lireEntree();
		if (evt != null){
			//l'tilisateur a saisit une nouvelle direction alors appel de l'action approprié
			j.getHeros().doAction(ActionDeplacer.class, evt);
		}else{
			//l'tilisateur n'a pas saisit de nouvelle direction alors set la vie du snake à 99 et appelle la fonction déplacerDroite (appel par défaut) 
			j.getHeros().setPv(99);
			j.getMap().deplacerDroite(j.getHeros());
			//Réinitialise la vie du snake à la normal s'il n'est pas mort
			if(j.getHeros().getPv()>0){
				j.getHeros().setPv(10);
			}
		}
		
		IPersonnage ennemi= (IPersonnage) j.getMap().getEnnemi(j.getHeros().getPosX(), j.getHeros().getPosY());
		
		if (ennemi!=null) {
			//Le Snake mange un bonbon 
			System.out.println("Miam");
			Jeu.map.removePersonnage(ennemi);
			Jeu.map.getCase(j.getHeros().getPosX(), j.getHeros().getPosY()).setPersonnage(j.getHeros());
		}

		//analyse si le snake est mort
		if (j.getHeros().getPv() < 1){
			//set le gameOn a false du jeu
			j.setGameOn(false);
		}

		//affiche le jeu
		j.afficher();
		//return l'état du jeu (si return false alors l'application reconnaitra la fin de la partie)
		return j.getGameOn();
	}
}
