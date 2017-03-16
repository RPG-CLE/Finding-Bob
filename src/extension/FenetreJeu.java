package extension;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import client.Case;
import client.Jeu;

public class FenetreJeu extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -478208599359849405L;
	JPanel panneau;
	GridLayout casesJeu; 
	CaseApparence casesApparence[][];

	public FenetreJeu(String nomJeu) {
		super(nomJeu);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void initialiserFenetre(Jeu jeu){
		casesJeu = new GridLayout(jeu.getMap().getLargeur(),jeu.getMap().getHauteur(), -1, -1);
		panneau = new JPanel(casesJeu);
		casesApparence = new CaseApparence[jeu.getMap().getLargeur()][jeu.getMap().getHauteur()];

		panneau.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		this.add(panneau);
		//panneau.setBackground(Color.red);
		for(int i = 0; i < jeu.getMap().getLargeur(); i++){
			for(int j = 0; j < jeu.getMap().getHauteur(); j++){
				casesApparence[i][j]= new CaseApparence();
				casesApparence[i][j].setCaseJeu(jeu.getMap().getCase(i, j));
				panneau.add(casesApparence[i][j]);

			}
		}
	}
	
	public void update(){
		for(int i = 0; i <casesApparence.length; i++){
			for(int j = 0; j < casesApparence[0].length; j++){
				casesApparence[i][j].update();
			}
		}
	}

}
