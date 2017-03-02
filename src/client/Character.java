package client;

public class Character extends GameObject{
	
	protected double hp; // Les points de vie du perso
	protected double strength;
	protected String name;
	
	public Character(double hp, double strength, String name, int x, int y) {
		super();
		this.hp = hp;
		this.strength = strength;
		this.name = name;
		setPosition(x, y);
	}
	
	public double getHp() {
		return hp;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}

	public double getStrength() {
		return strength;
	}

	public void setStrength(double strength) {
		this.strength = strength;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public boolean move(Direction direction){
		Point newPosition = getTileFromDirection(direction);
		
		if(Game.map.getTile(newPosition) == null) return false;
		
		if(Game.map.getTile(position).removeContainedObject(this)){
			position = newPosition;
			return Game.map.getTile(newPosition).addContainedObject(this);	
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Personnage [pv=" + hp + ", force=" + strength + ", nom=" + name
				+ ", position=" + position + "]";
	}
	
	
}
