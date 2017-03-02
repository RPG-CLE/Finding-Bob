package client;

/**
 * Base class for all game objects
 * Define basic properties and behavior for all objects contained in the game 
 *
 */
public class GameObject {
	protected boolean passable;
	
	protected ISkin skin;
	protected Point position;
	
	public Point getPosition() {
		return position;
	}
	
	public int getX() {
		return position.getX();
	}
	public int getY() {
		return position.getY();
	}
	
	public void setPosition(int x, int y) {
		this.position = new Point(x, y);
	}
	public void setPosition(Point position) {
		this.position = position;
	}
	
	public Point getTileFromDirection(Direction direction){
		return GameObject.getPointFromPointDirection(this.position, direction);
	}
	
	public static Point getPointFromPointDirection(Point point, Direction direction){
		Point p = new Point(point.getX(), point.getY());
		switch(direction){
		case LEFT:
			p.setX(p.getX() -1);
			break;
		case DOWN:
			p.setY(p.getY() -1);
			break;
		case RIGHT:
			p.setX(p.getX() +1);
			break;
		case UP:
			p.setY(p.getY() +1);
			break;
		}
		return p;
	}
	
	public void show(){
		//skin.
	}
}
