package extension;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreJeu extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -478208599359849405L;
	JPanel panneau;
	GridLayout casesJeu; 

	public FenetreJeu(String nomJeu) {
		super(nomJeu);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void initialiserFenetre(int tailleX, int tailleY){
		casesJeu = new GridLayout(tailleX, tailleY, -1, -1);
		panneau = new JPanel(casesJeu);
		panneau.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		this.add(panneau);
		//panneau.setBackground(Color.red);
		for(int i = 0; i < tailleX; i++){
			for(int j = 0; j < tailleY; j++){
				//CaseApparence caseApparence = new CaseApparence();
				JLabel label = new JLabel(i+"*"+j);
				label.setBorder(BorderFactory.createLineBorder(Color.black));
				panneau.add(label);
				
				
			}
		}
	}

}
