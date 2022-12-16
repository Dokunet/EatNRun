package entities;

import gui.Window;

public class MultipleEntityHandler {

	private Enemy[] enemies;
	private Cake[] cakes;
	private int numberOfCakes;
	private int numberOfEnemies;
	private char[][] map;
	private Window window;

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
					cakes[cakeNumber] = new Cake(row * 40, col * 40, this.map);
					cakeNumber++;
				}
			}
		}

	}

	public void drawEntities(Window window) {
		for (Enemy enemy : enemies) {
			enemy.draw(window);
		}
		for (Cake cake : cakes) {
			cake.draw(window);
		}
	}

	public Enemy[] getEnemies() {
		return enemies;
	}

	public Cake[] getCakes() {
		return cakes;
	}

}
