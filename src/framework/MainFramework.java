package framework;

import java.util.List;

public class MainFramework {
	public static void main(String[] args) {
//		TODO revoir l'ajout autorun
//      FUTUR FONCTIONNALITE AUTORUN
//
		List<IExtensionDesc> listExtentions =  PartieProvider.getInstance().getList();
		for(IExtensionDesc exten : listExtentions){
			if(exten.isAutoRun()){
				IApplication app = (IApplication) PartieProvider.getInstance().getObjetByDesc(exten.getContrainte(), exten);
				app.lancer();
			}
		}
	}
}
