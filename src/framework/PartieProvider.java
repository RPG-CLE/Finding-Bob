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


/**
 * Classe PartieProvider qui gère l'initialisations des objets avec les fichiers de config
 * 
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vallée
 */

public class PartieProvider extends Observable {
	private List<IExtensionDesc> extenstionDescripteurs;
	static PartieProvider _instance;
	/**
	 * Constructeur par défaut. Appelle getExtension pour le pattern singleton.
	 * 
	 */
	private PartieProvider(){
		initExtensionDescr();
	}
	/**
	 * Accesseur à l'attribut extensionDescripteur de la classe.
	 * 
	 * @return List<IExtensionDesc> : la liste des descripteur des extensions.
	 */
	public List<IExtensionDesc> getList(){
		return extenstionDescripteurs;
	}


	/**
	 * Accesseur à l'attribut _instance de la classe. S'assure qu'il n'existe qu'une seul instance
	 * de l'attribut _instance en même temps (singleton)
	 * 
	 * @return PartieProvider : l'instance du partie provider de la classe.
	 */
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

	/**
	 * Va chercher le nom de tout les fichier d'extension d'un dossier donnée en paramètre
	 * 
	 * @param String directoryName : le nom du dossier
	 * @return List<String> : la liste de tout les nom des extensions de directoryName.
	 */
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

	/**
	 * Initialise l'attribut extenstionDescripteurs avec la liste des descripteurs des extensions
	 * du dossier(package) extension/extensionsConfigs
	 */
	private void initExtensionDescr() {
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

	/**
	 * Change l'attribut état d'un des descripteurs de pluggin. Etat possible : NONCHARGE, ENACTIVITE, ENECHEC.
	 * 
	 * @param desc : le descripteur d'on on veut changer l'état
	 * @param etat : le nouvelle état du descripteur
	 */
	private void setDescripteurEtat(IExtensionDesc desc, Etat etat){
		extenstionDescripteurs.get(extenstionDescripteurs.indexOf(desc)).setEtat(etat);
	}

	/**
	 * Get un descripteur dans liste de descripteur via sont nom
	 * 
	 * @param nom : le nom du descripteur
	 * @return IExtensionDesc : le descripteur rechercher. Retourne null si le descripteur n'est pas dans la liste
	 */
	private IExtensionDesc getDescripteurParNom(String nom){
		for(IExtensionDesc d : extenstionDescripteurs){
			if(d.getNom().equals(nom))
				return d;
		}

		return null;
	}

	/**
	 * Crée un objet d'une classe donnée et l'initialise via sa config. 
	 * Notifie l'utilisateur qu'une instance de l'objet a été chargé.
	 * 
	 * @param contrainte : la classe de l'objet qu'on veut crée
	 * @param config : le path du fichier de config
	 * @return Objet : L'objet de la classe "contrainte" initialisé.  
	 * Si le fichier de config n'a pas a classe "contrainte" retourne null. 
	 * Si les données pour initialisé l'objet ne sont pas trouvé retourne l'objet non initialisé.
	 */
	public Object getObjetByConfig(Class<?> contrainte, String config){
		Properties prop = new Properties();
		Object mon_objet = null;
		try {
			prop.load(new FileReader(config));

			Class<?> cl = Class.forName((String)prop.get("classe"));

			if(contrainte.isAssignableFrom(cl)){
				mon_objet = cl.newInstance();
				_instance.setChanged();
				_instance.notifyObservers("une instance de "+cl.getName()+" a Ã©tÃ© chargÃ© ");
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
			System.out.println("Bonjour, votre ordinateur a explosÃ©");
		}
		return mon_objet;
	}


	/**
	 * Crée un objet via un descripteur donnée. 
	 * Notifie l'utilisateur qu'une instance de l'objet a été chargé.
	 * 
	 * @param desc : le descripteur du plugin de l'objet qu'on veut charger.
	 * @return Objet : objet du type fourni par le descripteur et intialisé avec le fichier de config indiqué par le descripteur.
	 * Si le fichier de config n'a pas a classe indiqué dans le descripteur retourne null. 
	 * Si les données pour initialisé l'objet ne sont pas trouvé retourne l'objet non initialisé.
	 */
	public Object getObjetByDesc(IExtensionDesc desc){
		Object mon_objet = null;

		try {
			Class<?> cl = Class.forName((String)desc.getNomClasse());
			if(desc.getContrainte().isAssignableFrom(cl)){
				mon_objet = cl.newInstance();
			}
			_instance.setChanged();
			_instance.notifyObservers("une instance de "+cl.getName()+" a Ã©tÃ© chargÃ©. ");

			if(desc.getContrainte().equals(Observer.class)){
				System.out.println("test");
				_instance.addObserver((Observer) mon_objet);
			}

			if (desc.isAutoRun()){
				if(!(cl.getAnnotation(MethodAutorun.class)==null)){
					System.out.println("test");
					_instance.setChanged();
					_instance.notifyObservers("une instance de "+cl.getName()+" lancÃ©. ");
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

