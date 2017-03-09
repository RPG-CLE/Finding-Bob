package framework;

import framework.ExtensionDesc.Etat;

public interface IExtensionDesc {

	String getNom();
	void setNom(String nom);
	void setNomClasse(String nomClasse);
	String getNomClasse();
	Class<?> getContrainte();
	String getDescription();
	void setDescription(String Desc);
	Etat getEtat();
	void setEtat(Etat etat);
	boolean isAutoRun();
	String getAutoRun();
	void setAutoRun(String autorun);

}
