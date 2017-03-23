package framework;

/**
 * Classe permettant de lancer les extensions autorun en parall�le avec des threads.
 * 
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vall�e
 *
 */


public class ThreadAutorun extends Thread {
	  private IExtensionDesc exten;
	  
	  /**
	   * Constructeur de la classe 
	   * @param exten : le descripteur de l'extension � autorun
	   */
	  public ThreadAutorun(IExtensionDesc exten) {
		    this.exten = exten;
	}
	/**
	 * Run l'extension d�crite par l'attribut exten (IExtensionDesc) de la classe.
	 *   
	 */
	  public void run() {
			PartieProvider.getInstance().getObjetByDesc(exten);
	  }
	}
