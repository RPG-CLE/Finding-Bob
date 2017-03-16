package framework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;

import framework.ExtensionDesc.Etat;

public class PartieProvider extends Observable {
	private List<IExtensionDesc> extenstionDescripteurs;
	static PartieProvider _instance;
	
	private PartieProvider(){
		getExtensionDescr();
	}
	
	public List<IExtensionDesc> getList(){
		return extenstionDescripteurs;
	}
	public List<IExtensionDesc> getExtenstionDescripteurs() {
		return extenstionDescripteurs;
	}
	
	
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
	 
			
			 private List<String> getExtensionsFileNames(String directoryName){
				String path = getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + directoryName;
				File folder = new File(path);
				File[] listOfFiles = folder.listFiles();
				List<String> fileNameStrings = new ArrayList<String>();

				for (int i = 0; i < listOfFiles.length; i++) {
					if (listOfFiles[i].isFile()) {
						fileNameStrings.add("src/"+directoryName + "/" + listOfFiles[i].getName());
				    }
				}
				    
				return fileNameStrings;
			}
			
			// Recuperer tous les descripteur des plugins
	private void getExtensionDescr() {
		List<IExtensionDesc> listDescs = new ArrayList<IExtensionDesc>();
		//recup les fichiers du dossier
		for (String config: getExtensionsFileNames("extension/extensionsConfigs")) {
			Properties prop = new Properties();
			IExtensionDesc desc = null;//new ExtensionDesc(etat, nom, nomClasse, description, contrainte
			
			try {
				prop.load(new FileReader(config));
				Class<?> contrainte = Class.forName(prop.getProperty("Contrainte"));
				desc = new ExtensionDesc(ExtensionDesc.Etat.NONCHARGE, prop.getProperty("Nom"), prop.getProperty("NomClasse"), prop.getProperty("Description"), contrainte, prop.getProperty("AutoRun"));
				listDescs.add(desc);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		extenstionDescripteurs = listDescs;
	}

	private void setDescripteurEtat(IExtensionDesc desc, Etat etat){
		 extenstionDescripteurs.get(extenstionDescripteurs.indexOf(desc)).setEtat(etat);
	}
	 
	private IExtensionDesc getDescripteurParNom(String nom){
		for(IExtensionDesc d : extenstionDescripteurs){
			 if(d.getNom().equals(nom))
				 return d;
		}
		 
		return null;
	}
	
	public Object getObjetByConfig(Class<?> contrainte, String config){
		Properties prop = new Properties();
		Object mon_objet = null;
		try {
			prop.load(new FileReader(config));
			
			Class<?> cl = Class.forName((String)prop.get("classe"));

			if(contrainte.isAssignableFrom(cl)){
				mon_objet = cl.newInstance();
				_instance.setChanged();
				_instance.notifyObservers("une instance de "+cl.getName()+" a été chargé ");
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
	
		
	public Object getObjetByDesc(IExtensionDesc desc){
		Object mon_objet = null;
		
		try {
			Class<?> cl = Class.forName((String)desc.getNomClasse());
			if(desc.getContrainte().isAssignableFrom(cl)){
				mon_objet = cl.newInstance();
			}
			_instance.setChanged();
			_instance.notifyObservers("une instance de "+cl.getName()+" a été chargé. ");
			
			if(desc.getContrainte().equals(Observer.class)){
				System.out.println("test");
				_instance.addObserver((Observer) mon_objet);
			}
			
			if (desc.isAutoRun()){
				if(!(cl.getAnnotation(MethodAutorun.class)==null)){
					System.out.println("test");
					_instance.setChanged();
					_instance.notifyObservers("une instance de "+cl.getName()+" lancé. ");
					Method m = cl.getMethod((String) cl.getAnnotation(MethodAutorun.class).run());
					m.invoke(mon_objet);
				}
			}
		}
		catch (Exception e){
			return null;
		}
		return mon_objet;
	}
			
			
		
		
}

