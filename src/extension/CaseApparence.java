package extension;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import client.Case;

public class CaseApparence extends JLabel {
	Case caseJeu;
	
	
	
	public Case getCaseJeu() {
		return caseJeu;
	}

	public void setCaseJeu(Case caseJeu) {
		this.caseJeu = caseJeu;
		update();
	}


	public void update() {
		if(caseJeu != null)
		this.setText(caseJeu.getNom());
	}

	public CaseApparence(){
		super();
		this.setBorder(BorderFactory.createLineBorder(Color.black));

	}
}
