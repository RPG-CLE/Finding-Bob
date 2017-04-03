package framework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Classe contenant le main à lancer pour démarrer le jeu
 * 
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vallée
 *
 */


public class MainFramework {

	public static void main(String[] args) throws InterruptedException {
		List<Integer> priorites = new ArrayList<Integer>();
		
		List<IExtensionDesc> listExtentions =  PartieProvider.getInstance().getList();
		int max_prio=0;
		
		for(IExtensionDesc exten : listExtentions){
			if(!priorites.contains(exten.getPriorite())){
				priorites.add(exten.getPriorite());
			}
		}
		while(priorites.size()!=0){
			max_prio=0;
			for(int prio : priorites){
				if(prio>max_prio){
					max_prio=prio;
				}
			}
			for(IExtensionDesc exten : listExtentions){
				if(exten.isAutoRun()){
					if(exten.getPriorite()==max_prio){
						System.out.println("Lancement de l'autorun : "+exten.getNom()+"avec une priorité de : "+exten.getPriorite()+".");
						ThreadAutorun t = new ThreadAutorun(exten) ;
						t.start();

					}
				}
			}

			int pos = 0;
			boolean trouve=false;
			for(int prio : priorites){
				if(prio==max_prio){
					trouve =true;
				}
				if(!trouve){
					pos++;	
				}
			}		
			priorites.remove(pos);
			
			if(max_prio>0){
				TimeUnit.SECONDS.sleep(1);							
			}
		}
		
	}

}
