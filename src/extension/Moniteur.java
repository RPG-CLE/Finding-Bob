package extension;
import framework.IMoniteur;;
public class Moniteur implements IMoniteur {

	@Override
	public void notifier(String s) {
		
		System.out.println("Le plugin "+s+" a �t� charg�");
		
	}

	@Override
	public void notifierAutorun(String s) {
		
		System.out.println("Le plugin "+s+" (autorun) a été lancé.");
		
	}

	
	
}
