package framework;

import java.io.FileReader;
import java.util.Properties;

public class PartieProvider {
	static PartieProvider _instance;
	
 // make singleton
	 public static PartieProvider getInstance() {
	        if (_instance == null) {
	            synchronized (PartieProvider.class) {
	                if (_instance == null) {
	                    _instance = new PartieProvider();
	                }
	            }
	        }
	        return _instance;
	    }
	
	public Object getObjetByConfig(Class<?> contrainte, String config){
		Properties prop = new Properties();
		Object mon_objet = null;
		try {
			prop.load(new FileReader(config));
			
			Class<?> cl = Class.forName((String)prop.get("classe"));

			if(contrainte.isAssignableFrom(cl)){
				mon_objet = cl.newInstance();
				//TODO Remplir extension
			}
	
		}
			
			
		
		catch (Exception e){
			e.printStackTrace();
			System.out.println("Bonjour, votre ordinateur a explosé");
		}
		return mon_objet;
	}
}

