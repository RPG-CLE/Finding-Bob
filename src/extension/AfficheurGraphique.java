package extension;

import javax.swing.JFrame;

import client.Jeu;
import client.interfaces.IAfficheur;

public class AfficheurGraphique implements IAfficheur{
	private JFrame fenetre;
	private int tailleCaseX;
	private int tailleCaseY;
	
	public AfficheurGraphique(){
		initialiserFenetre();
	}
		
	@Override
	public void afficher(Jeu jeu){
		
		
	}
	
	public void initialiserFenetre(){
		fenetre = new JFrame("Finding Bob");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
	}
	
	public void initialiserJeu(Jeu jeu){
		fenetre.setSize(jeu.getMap().getLargeur(), jeu.getMap().getHauteur());
		
	}
}
