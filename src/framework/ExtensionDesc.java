package framework;


public class ExtensionDesc implements IExtensionDesc {
	public enum Etat{NONCHARGE, ENACTIVITE, ENECHEC};
	
	private Etat etat;
	private String nom;
	private String nomClasse;
	private String Description;
	private Class<?> contrainte;
	
	public String getNomClasse() {
		return nomClasse;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}

	public Class<?> getContrainte() {
		return contrainte;
	}

	public void setContrainte(Class<?> contrainte) {
		this.contrainte = contrainte;
	}

	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNom(String nom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDescription(String Desc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Etat getEtat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEtat(Etat etat) {
		// TODO Auto-generated method stub
		
	}

}
