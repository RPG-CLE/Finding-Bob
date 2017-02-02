package extension;
import client.*;

public class ActionJeu implements IAJ {
	@Override
	public void action(Jeu j) {
		// TODO Auto-generated method stub
	   j.deplacer("droite");
	   j.afficher();
	   System.out.println();
	}
	
}
