package gameLogic;

import gui.Color;
import gui.Window;
import map.MapGenerator;
import obstacles.Obstacle;
import entities.BaseEntity;

import entities.*;

public class Game {
	private int width;
	private int height;
	private int mapNumber;
	private Enemy enemy;
	private Player player;
	private Finish finish;
	private Obstacle map;
	private MultipleEntityHandler entityHandler;
	private Window window;
	private char[][][] allMaps;
	private boolean newGame = false;

	public Game(int width, int height, char[][][] map, Window window) {
		this.window = window;
		this.width = width;
		this.height = height;
		this.mapNumber = map.length - 1;
		this.allMaps = map;
		this.entityHandler = new MultipleEntityHandler(map[mapNumber], window);
		this.map = new Obstacle(map[mapNumber]);
		this.player = new Player(map[mapNumber]);
		this.finish = new Finish(map[mapNumber]);
		
	}

	public void handleEvents() {
		if (window.isKeyPressed("up")) {
			player.moveUp();
		} else if (window.isKeyPressed("down")) {
			player.moveDown();
		} else if (window.isKeyPressed("left")) {
			player.moveLeft();
		} else if (window.isKeyPressed("right")) {
			player.moveRight();
		}

	}

	public boolean step() {

		int newMapNumber = this.finish.listener(mapNumber, player);
		
		multyListener(entityHandler.getEnemies());
		multyListener(entityHandler.getCakes());
	
		if (newMapNumber != mapNumber) {
			if (newMapNumber < 0) {
				return true;
			}
			resetLevel(newMapNumber);
		}

		return false;
	}
	
	public void resetLevel(int newMapNumber) {
		this.mapNumber = newMapNumber;
		this.entityHandler = new MultipleEntityHandler(allMaps[mapNumber], window);
		this.map = new Obstacle(allMaps[mapNumber]);
		this.player = new Player(allMaps[mapNumber]);
		this.drawGame();
	}
	
	public void multyListener(BaseEntity[] entities) {
		for (BaseEntity entity : entities) {
			entity.listener(3,player);
		}
	}

	public void drawGame() {
		this.map.draw(window);
		
		this.player.draw(window);
		this.finish.draw(window);
		this.entityHandler.drawEntities(window);
		window.setColor(0, 0, 0);
		window.setBold(true);
		window.setFontSize(13);
		if (this.newGame) {

			this.newGame = false;
		}

	}

}


// this.ball.step();
// if ((this.ball.x == this.playerLeft.x + 10 && this.ball.y >=
// this.playerLeft.y
// && this.ball.y <= this.playerLeft.y + 90)
// || (this.ball.x == this.playerRight.x && this.ball.y >= this.playerRight.y
// && this.ball.y <= this.playerRight.y + 90)) {
// this.ball.bounceOfVertical();
// } else if (this.ball.y == 0 || this.ball.y == 600) {
// this.ball.bounceOfHorizontal();
// } else if (this.ball.x < 0){
// this.playerRight.incScore();
// this.newGame = true;
// } else if (this.ball.x > 800){
// this.playerLeft.incScore();
// this.newGame = true;
// }

// // TODO Einen Zeitschritt prozessieren, also den Ball bewegen und Kollisionen
// behandeln.
