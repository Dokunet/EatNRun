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
	private int lives;
	private int cakeCount;
	private Obstacle map;
	private MultipleEntityHandler entityHandler;
	private Window window;
	private char[][][] allMaps;
	public char[][] currentMap;
	private boolean newGame = false;

	public Game(int width, int height, char[][][] map, Window window) {
		this.lives = 5;
		this.cakeCount = 0;
		this.window = window;
		this.width = width;
		this.height = height;
		this.mapNumber = map.length - 1;
		this.allMaps = map;
		this.currentMap = map[mapNumber];
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

	public void step() {
		int newMapNumber = this.finish.listener(mapNumber, player);
		int newLives = multyListener(entityHandler.getEnemies(), this.lives);
		int newCakeCount = multyListener(entityHandler.getCakes(), cakeCount);
		if (newMapNumber != mapNumber) {
			if (newMapNumber < 0) {
				drawGameOverScreen("You Won");
			} else {
				resetLevel(newMapNumber);
			}
		} else if (newLives != this.lives) {
			if (newLives <= 0) {
				drawGameOverScreen("You Lost");
			} else {
				resetLevel(newMapNumber);
			}
			this.lives = newLives;
		} else if (newCakeCount != cakeCount) {
			entityHandler.destroyCake(player.getX(), player.getY());
		}
		cakeCount = newCakeCount;
	}

	public void resetLevel(int newMapNumber) {
		this.mapNumber = newMapNumber;
		this.entityHandler = new MultipleEntityHandler(allMaps[mapNumber], window);
		this.finish = new Finish(allMaps[mapNumber]);
		this.map = new Obstacle(allMaps[mapNumber]);
		this.player = new Player(allMaps[mapNumber]);
		this.drawGame();
	}

	public int multyListener(BaseEntity[] entities, int amount) {
		int newAmount = amount;
		for (BaseEntity entity : entities) {
			if (entity != null) {
				newAmount = entity.listener(amount, player);
//				if (amount != newAmount && entity.getSymbol() == 'C') {
//					this.entityHandler.destroyCake(entity.getArrayIndex());
//					return newAmount;
//				}
			}
		}

		return newAmount;
	}

	public void drawGame() {
		this.map.draw(window);
		this.player.draw(window);
		this.finish.draw(window);
		this.entityHandler.drawEntities(window);
		window.setColor(250, 250, 250);
		window.setBold(true);
		window.setFontSize(15);
		window.drawStringCentered("Anzahl Leben: " + this.lives, 300, 25);
		window.setColor(250, 250, 250);
		window.setBold(true);
		window.setFontSize(15);
		window.drawStringCentered("Anzahl Kuchen: " + this.cakeCount * -1, 500, 25);
		window.setColor(0, 0, 0);
		window.setBold(true);
		window.setFontSize(13);
		if (this.newGame) {
			this.newGame = false;
		}

	}

	public void drawGameOverScreen(String message) {
		window.close();
		window = new Window("Game Over", 800, 600);
		window.setColor(255, 127, 0);
		window.setBold(true);
		window.setFontSize(50);
		window.drawStringCentered(message, 400, 300);
		window.open();
		window.waitUntilClosed();
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
