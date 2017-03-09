package framework;

import java.util.List;

public class MainFramework {
	public static void main(String[] args) {
//		TODO revoir l'ajout autorun
//      FUTUR FONCTIONNALITE AUTORUN
//
		List<IExtensionDesc> listExtentions =  PartieProvider.getInstance().getList();
		System.out.println("taille liste : "+listExtentions.size());
		for(IExtensionDesc exten : listExtentions){
			System.out.println("Autorun : "+exten.getNomClasse());
			System.out.println("Autorun : "+exten.getAutoRun());
			if(exten.isAutoRun()){
				IApplication app = (IApplication) PartieProvider.getInstance().getObjetByConfig(exten.getContrainte(), exten.getNomClasse());
				app.lancer();
			}
		}
	}
}
