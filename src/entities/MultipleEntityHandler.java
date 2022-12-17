package entities;

import gui.Window;

public class MultipleEntityHandler {

	private Enemy[] enemies;
	private Cake[] cakes;
	private int numberOfCakes;
	private int numberOfEnemies;
	private char[][] map;
	private Window window;
	private int cakeToDelete;

	public MultipleEntityHandler(char[][] map, Window window) {
		this.map = map;
		int x = 0;
		int y = 0;
		this.window = window;
		for (int col = 0; col < map.length; col++) {
			for (int row = 0; row < map[col].length; row++) {
				if (map[col][row] == 'E' || map[col][row] == 'N' || map[col][row] == 'S' || map[col][row] == 'W') {
					numberOfEnemies++;
				} else if (map[col][row] == 'C') {
					numberOfCakes++;
				}
			}

		}
		initializeEntities();

	}

	public void initializeEntities() {
		enemies = new Enemy[numberOfEnemies];
		cakes = new Cake[numberOfCakes];
		int enemyNumber = 0;
		int cakeNumber = 0;

		for (int col = 0; col < map.length; col++) {
			for (int row = 0; row < map[col].length; row++) {
				if (map[col][row] == 'E' || map[col][row] == 'N' || map[col][row] == 'S' || map[col][row] == 'W') {
					enemies[enemyNumber] = new Enemy(row * 40, col * 40, this.map, map[col][row]);
					enemyNumber++;
				} else if (map[col][row] == 'C') {
					cakes[cakeNumber] = new Cake(row * 40, col * 40, this.map, cakeNumber);
					cakeNumber++;
				}
			}
		}

	}

	public void destroyCake(int x, int y) {
		int xIndex = x / 40;
		int yIndex = y / 40;
		int xIndexAddedMargin = (x + 30) / 40;
		int yIndexAddedMargin = (y + 40) / 40;
		for (int i = 0; i < cakes.length; i++) {
			if (cakes[i] != null) {
				if (((cakes[i].x / 40) == xIndex && (cakes[i].y / 40) == yIndex)) {
					cakes[i] = null;
					this.map[yIndex][xIndex] = ' ';
				} else if ((cakes[i].x / 40) == xIndexAddedMargin && (cakes[i].y / 40) == yIndex) {
					cakes[i] = null;
					this.map[yIndex][xIndexAddedMargin] = ' ';
				} else if ((cakes[i].x / 40) == xIndex && (cakes[i].y / 40) == yIndexAddedMargin) {
					cakes[i] = null;
					this.map[yIndexAddedMargin][xIndex] = ' ';
				} else if ((cakes[i].x / 40) == xIndexAddedMargin && (cakes[i].y / 40) == yIndexAddedMargin) {
					cakes[i] = null;
					this.map[yIndexAddedMargin][xIndexAddedMargin] = ' ';
				}
			}
		}
//		if (this.map[yIndex][xIndex] == object || this.map[yIndexAddedMargin][xIndexAddedMargin] == object
//		 || this.map[yIndex][xIndexAddedMargin] == object || this.map[yIndexAddedMargin][xIndex] == object

	}

	public void drawEntities(Window window) {
		for (Enemy enemy : enemies) {
			enemy.draw(window);
		}
		for (Cake cake : cakes) {
			if (cake != null) {
				cake.draw(window);
			}
		}
	}
	
	public void enemyMovement() {
		for (Enemy enemy : enemies) {
			enemy.step();
		}
	}

	public Enemy[] getEnemies() {
		return enemies;
	}

	public Cake[] getCakes() {
		return cakes;
	}

}
