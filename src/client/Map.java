package client;

public class Map {
	protected Tile[][] tiles;
	protected int width;
	protected int height;

	public Map(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		tiles = new Tile[width][height];
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				tiles[i][j] = new Tile(i, j);
			}
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Tile getTile(int x, int y){
		if(x >= 0 && y >= 0 && x < width && y < height){
			return tiles[x][y];
		}
		return null;
	}
	public Tile getTile(Point p){
		return getTile(p.getX(), p.getY());
	}
	
	public void show(){
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				tiles[i][j].show();
			}
		}
	}
}
