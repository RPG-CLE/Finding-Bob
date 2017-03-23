package framework;

/**
 * Classe permettant de lancer les extensions autorun en parallèle avec des threads.
 * 
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vallée
 *
 */


public class ThreadAutorun extends Thread {
	  private IExtensionDesc exten;
	  
	  /**
	   * Constructeur de la classe 
	   * @param exten : le descripteur de l'extension à autorun
	   */
	  public ThreadAutorun(IExtensionDesc exten) {
		    this.exten = exten;
	}
	/**
	 * Run l'extension décrite par l'attribut exten (IExtensionDesc) de la classe.
	 *   
	 */
	  public void run() {
			PartieProvider.getInstance().getObjetByDesc(exten);
	  }
	}
