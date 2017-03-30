package extension;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import client.interfaces.IPersonnage;

public class PersonnageApparence extends JLabel {
	
private static final long serialVersionUID = 446562574325842386L;

	private IPersonnage personnage;
	private String icon;
	

	public PersonnageApparence() {
		super();
	}

	public IPersonnage getPersonnage() {
		return personnage;
	}


	public void setPersonnage(IPersonnage personnage) {
		this.personnage = personnage;
		update();
	}


	private void update() {
		if(personnage != null){
			//this.setText("0");
			this.SetCaseIcon();
			this.setIcon(new ImageIcon(icon));
		}
		else{
			this.setIcon(null);;
		}
	}

	public String getIcone() {
		return this.icon;
	}


	public void setIcone(String icon) {
		this.icon = icon;
	}

	
	void SetCaseIcon(){
		File monFichier = new File("data/"+personnage.getNom()+".png");
		
		if(monFichier.exists()) 
		{
			icon ="data/"+personnage.getNom()+".png";
		}else{
			icon = "data/default.png";
		}
	}

	
}
