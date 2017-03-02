package framework;

import java.io.FileReader;
import java.util.Properties;

import client.IAJ;
import client.Game;
import client.Map;
import client.Character;
import extension.ActionJeu;

public class GameLoader {
	public static Game load(){
		Game game = null;
		Map map = null;
		
		Character principal = new Character(10, 2, "Robert", 0, 0);
		Character vilain = new Character(10, 1, "Vilain", 3, 3);
		
		map = new Map(5,5);

		game = new Game(map);
		game.addObject(principal, true);
		game.addObject(vilain);
		
		return game;
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
