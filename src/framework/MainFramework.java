package framework;

import java.util.List;

/**
 * Classe contenant le main à lancer pour démarrer le jeu
 * 
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vallée
 *
 */


public class MainFramework {

	public static void main(String[] args) {

		List<IExtensionDesc> listExtentions =  PartieProvider.getInstance().getList();
		for(IExtensionDesc exten : listExtentions){
			if(exten.isAutoRun()){
				ThreadAutorun t = new ThreadAutorun(exten) ;
				t.start();
			}
		}
		
	}

}
