package client;

public class Game {
	public static Map map;
	public GameObject player;
	public GameObject monster;
	
	public Game(Map map) {
		super();
		Game.map = map;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		Game.map = map;
	}
	
	public GameObject getPlayer() {
		return player;
	}
	public void setPlayer(GameObject player) {
		this.player = player;
	}

	public GameObject getMonster() {
		return monster;
	}

	public void setMonster(GameObject monster) {
		this.monster = monster;
	}

	//FIXME prevent multiple use of this method on the same object by either knowing each objects of the game or delegate it to tiles
	public boolean addObject(GameObject object, boolean isPlayer){
		if(isPlayer) player = object;
		else monster = object;
		return Game.map.getTile(object.getPosition()).addContainedObject(object);
	}
	public boolean addObject(GameObject object){
		return addObject(object, false);
	}
	
	public void show(){
		
	}
}
