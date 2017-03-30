package framework;


/**
 * Class ExtensionDesc pour Extension Descriptor
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vallée
 *
 */
public class ExtensionDesc implements IExtensionDesc {
	public enum Etat{NONCHARGE, ENACTIVITE, ENECHEC};

	private Etat etat;
	private String nom;
	private String nomClasse;
	private String description;
	private Class<?> contrainte;
	private String autoRun = "false";
	private int priorite = 0;
	/**
	 * Constructeur par défaut
	 */
	public ExtensionDesc(){}
	
	
	/**
	 * Constructeur prenant les paramètres pour donner les valeurs des attributs : 
	 * etat, nom, nomClasse, description et contrainte.
	 * 
	 * @param etat l'état de l'extension parmi NONCHARGE, ENACTIVITE, ENECHEC
	 * @param nom nom de l'extension
	 * @param nomClasse nom de la classe de l'extension
	 * @param description description de l'extension
	 * @param contrainte interface ou classe de laquelle elle dérive
	 */
	public ExtensionDesc(Etat etat, String nom, String nomClasse,
			String description, Class<?> contrainte) {
		super();
		this.etat = etat;
		this.nom = nom;
		this.nomClasse = nomClasse;
		this.description = description;
		this.contrainte = contrainte;
	}
	
	
	/**
	 * Constructeur prenant les paramètres pour donner les valeurs des attributs : 
	 * etat, nom, nomClasse, description, contrainte et autoRun.
	 * 
	 * @param etat l'état de l'extension parmi NONCHARGE, ENACTIVITE, ENECHEC
	 * @param nom nom de l'extension
	 * @param nomClasse nom de la classe de l'extension
	 * @param description description de l'extension
	 * @param contrainte interface ou classe de laquelle elle dérive
	 * @param autoRun booléen qui décide si l'extension est lancée au début ou non
	 */
	public ExtensionDesc(Etat etat, String nom, String nomClasse,
			String description, Class<?> contrainte, String autoRun) {
		super();
		this.etat = etat;
		this.nom = nom;
		this.nomClasse = nomClasse;
		this.description = description;
		this.contrainte = contrainte;
		this.autoRun =  autoRun;
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
	public int getPriorite() {
		return this.priorite;
	}

	@Override
	public void setPriorite(int prio) {
		this.priorite = prio;
		
	}

	@Override
	public String getNomClasse() {
		return nomClasse;
	}

	@Override
	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}
	
	@Override
	public Class<?> getContrainte() {
		return contrainte;
	}
	

	@Override
	public void setContrainte(Class<?> contrainte) {
		this.contrainte = contrainte;
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
	@Override
	public String getAutoRun(){
		return autoRun;
	}

	@Override
	public boolean isAutoRun() {
		return autoRun.equals("true");
	}

	@Override
	public void setAutoRun(String autorun) {
		this.autoRun = autorun;
	}

}
