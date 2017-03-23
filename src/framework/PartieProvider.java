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
	/**
	 * @brief Constructeur par dÈfaut. Appelle getExtension pour le pattern singleton.
	 */
	private PartieProvider(){
		initExtensionDescr();
	}
	/**
	 * @brief Accesseur ‡ l'attribut extensionDescripteur de la classe.
	 * @return List<IExtensionDesc> : la liste des descripteur des extensions.
	 */
	public List<IExtensionDesc> getList(){
		return extenstionDescripteurs;
	}


	/**
	 * @brief Accesseur ‡ l'attribut _instance de la classe. S'assure qu'il n'existe qu'une seul instance
	 * de l'attribut _instance en mÍme temps (singleton)
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
	 * @brief Va chercher le nom de tout les fichier d'extension d'un dossier donnÈe en paramËtre
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
	 * @brief Initialise l'attribut extenstionDescripteurs avec la liste des descripteurs des extensions
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
	 * @brief Change l'attribut Ètat d'un des descripteurs de pluggin. Etat possible : NONCHARGE, ENACTIVITE, ENECHEC
	 * @param desc : le descripteur d'on on veut changer l'Ètat
	 * @param etat : le nouvelle Ètat du descripteur
	 */
	private void setDescripteurEtat(IExtensionDesc desc, Etat etat){
		extenstionDescripteurs.get(extenstionDescripteurs.indexOf(desc)).setEtat(etat);
	}

	/**
	 * @brief Get un descripteur de la liste de descripteur via sont nom
	 * @param nom : le nom du descripteur
	 * @return etat : le nouvelle Ètat du descripteur
	 */
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
				_instance.notifyObservers("une instance de "+cl.getName()+" a √©t√© charg√© ");
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
			System.out.println("Bonjour, votre ordinateur a explos√©");
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
			_instance.notifyObservers("une instance de "+cl.getName()+" a √©t√© charg√©. ");

			if(desc.getContrainte().equals(Observer.class)){
				System.out.println("test");
				_instance.addObserver((Observer) mon_objet);
			}

			if (desc.isAutoRun()){
				if(!(cl.getAnnotation(MethodAutorun.class)==null)){
					System.out.println("test");
					_instance.setChanged();
					_instance.notifyObservers("une instance de "+cl.getName()+" lanc√©. ");
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

