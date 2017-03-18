package extension;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.OverlayLayout;

import client.Case;

public class CaseApparence extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8452935977350960850L;
	Case caseJeu;
	String icon;
	PersonnageApparence personnageApparence;
	OverlayLayout overlay;
	
	public Case getCaseJeu() {
		return caseJeu;
	}

	public void setCaseJeu(Case caseJeu) {
		this.caseJeu = caseJeu;
		update();
	}


	public void update() {
		if(caseJeu != null){
			//this.setText("0");
			this.SetCaseIcon();
			this.setIcon(new ImageIcon(icon));
			if(caseJeu.getPersonnage() != null){
				personnageApparence.setPersonnage(caseJeu.getPersonnage());
			}else{
				personnageApparence.setIcon(null);
			}
		}
	}
	
	

	public CaseApparence(){
		super();
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		personnageApparence = new PersonnageApparence();
		overlay = new OverlayLayout(this);
		this.setLayout(overlay);
		this.add(personnageApparence);
	}
	
	void SetCaseIcon(){
		switch(caseJeu.getNom()){
		case "Herbe":
			icon = "data/herbe.jpg";
			break;
		case "Eau" :
			icon = "data/eau.png";
			break;
		case "Terre" :
			icon = "data/terre.png";
			break;
		}
	}
}
