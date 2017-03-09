package framework;


public class ExtensionDesc implements IExtensionDesc {
	public enum Etat{NONCHARGE, ENACTIVITE, ENECHEC};

	private Etat etat;
	private String nom;
	private String nomClasse;
	private String description;
	private Class<?> contrainte;
	
	public ExtensionDesc(Etat etat, String nom, String nomClasse,
			String description, Class<?> contrainte) {
		super();
		this.etat = etat;
		this.nom = nom;
		this.nomClasse = nomClasse;
		this.description = description;
		this.contrainte = contrainte;
	}
	
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
		return this.nom;
	}

	@Override
	public void setNom(String nom) {
		this.nom = nom;
		
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public void setDescription(String Desc) {
		this.description = Desc;
		
	}

	@Override
	public Etat getEtat() {
		return this.etat;
	}

	@Override
	public void setEtat(Etat etat) {
		this.etat = etat;
		
	}

}
