package framework;

import framework.ExtensionDesc.Etat;

/**
 * Interface IExtensionDesc pour IExtension Descriptor
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vallée
 *
 */
public interface IExtensionDesc {

	
	/**
	 * Retourne le nom de l'extension 
	 * 
	 * @return la valeur de l'attribut nom de la classe
	 */
	String getNom();
	

	/**
	 * Entregistre le nom de l'extension décrite,
	 * remplace toute autre valeur précédente
	 * 
	 * @param nom le nom qu'on veut donner à l'extension
	 */
	void setNom(String nom);
	
	/**
	 * Retourne le nom de l'extension 
	 * 
	 * @return la valeur de l'attribut nom de la classe
	 */
	int getPriorite();
	

	/**
	 * Entregistre le nom de l'extension décrite,
	 * remplace toute autre valeur précédente
	 * 
	 * @param nom le nom qu'on veut donner à l'extension
	 */
	void setPriorite(int prio);
	
	
	
	/** 
	 * Retourne le nom de la classe de l'extension décrite
	 * 
	 * @return la valeur de l'attribut nom de la classe
	 */
	String getNomClasse();

	/** 
	 * Enregistre la valeur du nom de la classe décrite, 
	 * remplace toute autre valeur précédente
	 * 
	 * @param nomClasse le nom qu'on veut donner à la classe
	 */
	void setNomClasse(String nomClasse);
	
	/** 
	 * Retourne la classe dont dérive la classe décrite par l'extension
	 * 
	 * @return la classe en question
	 */
	Class<?> getContrainte();
	
	/** 
	 * Enregistre une nouvelle classe dont dérive la classe de l'extension,
	 * remplace toute autre valeur précédente
	 * 
	 * @param contrainte la classe désirée
	 */
	void setContrainte(Class<?> contrainte);
	
	
	/**
	 * Retourne la description de l'extension
	 * 
	 * @return la valeur de l'attribut description
	 */
	String getDescription();
	
	/** 
	 * Enregistre une nouvelle description de l'extension,
	 * remplace toute autre valeur précédente
	 * 
	 * @param desc la description souhaitée
	 */
	void setDescription(String desc);
	
	/**
	 * Retourne l'état de l'extension
	 * 
	 * @return la valeur de l'attribut etat parmi NONCHARGE, ENACTIVITE, ENECHEC
	 */
	Etat getEtat();
	
	/** 
	 * Enregistre un nouvel état de l'extension,
	 * remplace toute autre valeur précédente
	 * 
	 * @param etat l'état souhaité parmi NONCHARGE, ENACTIVITE, ENECHEC
	 */
	void setEtat(Etat etat);
	/**
	 * Précise si l'extension est lancée au chargement ou non
	 * 
	 * @return true si l'extesnion esst lancée au chargement, false sinon
	 */
	boolean isAutoRun();

	/**
	 * Retourne la valeur de l'attribut autoRun de l'extension, qui détermine si 
	 * l'extension est chargée ou non.
	 * 
	 * @return la valeur de l'attribut autoRun
	 */
	String getAutoRun();
	/** 
	 * Enregistre une nouvelle valeur d'autoRun de l'extension,
	 * remplace toute autre valeur précédente.
	 * 
	 * @param autorun la valeur souhaitée pour autoRun : 
	 * true" si elle doit se lancer au chargement, "false" sinon.
	 */
	void setAutoRun(String autorun);

}
