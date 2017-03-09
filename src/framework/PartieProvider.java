package framework;

import java.io.FileReader;
import java.util.List;
import java.util.Properties;
import java.lang.reflect.*;

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
	 
		public List<IExtensionDesc> getExtensionDescr(Class<?> contrainte) {

			// FIXME replace the following test code but do not load config files repeatedly
			/*
			if (constraint == IAfficheur.class)
				return Arrays.asList(new PluginDescr("affTest", "plugins.Afficheur", constraint));
			if (constraint == IPersonBuilder.class)
				return Arrays.asList(new PluginDescr("pBuildTest", "plugins.PersonBuilder", constraint));
			*/

			return null;
		}
		public List<IExtensionDesc> getExtensionDescr() {

			// FIXME replace the following test code but do not load config files repeatedly
			/*
			if (constraint == IAfficheur.class)
				return Arrays.asList(new PluginDescr("affTest", "plugins.Afficheur", constraint));
			if (constraint == IPersonBuilder.class)
				return Arrays.asList(new PluginDescr("pBuildTest", "plugins.PersonBuilder", constraint));
			*/

			return null;
		}

		public Object getExtensionForDescr(IExtensionDesc extension) {
			Object obj = null;

			try {
				ExtensionDesc mypl = (ExtensionDesc) extension;
				// Loading
				Class<?> cl = Class.forName(mypl.getNomClasse());
				// check constraint
				if (mypl.getContrainte().isAssignableFrom(cl)) obj = cl.newInstance();

			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {

				e.printStackTrace();
			}

			// retourner l'instance
			return obj;
		}

	 
	
	public Object getObjetByConfig(Class<?> contrainte, String config){
		Properties prop = new Properties();
		Object mon_objet = null;
		try {
			prop.load(new FileReader(config));
			
			Class<?> cl = Class.forName((String)prop.get("classe"));

			if(contrainte.isAssignableFrom(cl)){
				mon_objet = cl.newInstance();

				for(Object key : prop.keySet()){
					if(!key.equals("classe")){
						Method getter = cl.getMethod("get"+(String)key);
						Method m = cl.getMethod("set" + key, getter.getReturnType());
						try{
							if(getter.getReturnType().equals(int.class)){
								m.invoke(mon_objet, Integer.parseInt((String)prop.get(key)));
							}else if(getter.getReturnType().equals(double.class)){
								m.invoke(mon_objet, Double.parseDouble((String)prop.get(key)));
							}else{
								m.invoke(mon_objet, (String)prop.get(key));
							}
						}catch(Exception e){
							e.printStackTrace();
							System.out.println("Configuration incorrect");
						}
					}
					
				}
			}
	
		}
			
			
		
		catch (Exception e){
			e.printStackTrace();
			System.out.println("Bonjour, votre ordinateur a explosé");
		}
		return mon_objet;
	}
}

