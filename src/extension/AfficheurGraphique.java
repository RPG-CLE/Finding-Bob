package extension;

import javax.swing.JFrame;

import client.Jeu;
import client.interfaces.IAfficheur;

public class AfficheurGraphique implements IAfficheur{
	private FenetreJeu fenetre;
	private int tailleCaseX = 32;
	private int tailleCaseY = 32;
	private boolean dejaAffiche = false;
	
	public AfficheurGraphique(){
		initialiserFenetre();
	}
		
	@Override
	public void afficher(Jeu jeu){
		if(!dejaAffiche){
			initialiserJeu(jeu);
			dejaAffiche = !dejaAffiche;
		}
		else if(jeu.getMap().rechargementTexture()){
			rechargerFenetre();
		}
			
		fenetre.update();
	}
	
	public void initialiserFenetre(){
		
		fenetre = new FenetreJeu("Finding Bob");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
	}
	
	public void rechargerFenetre(){
			
			fenetre.rechargerFenetre();
			fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			fenetre.setVisible(true);
		}
	
	public void initialiserJeu(Jeu jeu){
		//fenetre.setSize(jeu.getMap().getLargeur() * tailleCaseX, jeu.getMap().getHauteur() * tailleCaseY);
		fenetre.initialiserFenetre(jeu);
		fenetre.pack();
		//fenetre.setResizable(false);
		
	}
	
}
