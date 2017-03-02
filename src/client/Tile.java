package client;

import java.util.HashSet;
import java.util.Set;

public class Tile extends GameObject{	
	protected Set<GameObject> containedObjects = new HashSet<GameObject>();
	
	public Tile(int x, int y){
		setPosition(x, y);
	}
	
	public boolean addContainedObject(GameObject object){
		return containedObjects.add(object);
	}
	
	public boolean removeContainedObject(GameObject object){
		return containedObjects.remove(object);
	}
	
	public boolean containsObject(GameObject object){
		return containedObjects.contains(object);
	}
}
