package framework;

import java.io.FileReader;
import java.util.Properties;

import client.IAJ;
import client.Jeu;
import client.Map;
import client.Personnage;
import extension.ActionJeu;

public class ChargeurPartie {
	public static Jeu charger(){
		Personnage principal = new Personnage(10, 2, "Robert", 0, 0);
		Personnage vilain = new Personnage(10, 1, "Vilain", 3, 3);
		Map map = new Map(5,5);
		return new Jeu(principal, map, vilain);
	}
	public static IAJ chargerAction(String config){
		Properties prop = new Properties();
		Object mon_objet;
		try {
			prop.load(new FileReader(config));
			
			Class<?> cl = Class.forName((String)prop.get("IAJ"));
			
			mon_objet = cl.newInstance();
			
			
			return (IAJ) mon_objet;
			
		} 
		catch (Exception e){
			e.printStackTrace();
			System.out.println("Bonjour, votre ordinateur a explosé");
		}
		return null;
	}
}
