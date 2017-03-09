package extension;
import framework.IMoniteur;;
public class Moniteur implements IMoniteur {

	@Override
	public void notifier(String s) {
		
		System.out.println("Le plugin "+s+" a été chargé");
		
	}

	
	
}
