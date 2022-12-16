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
	private Obstacle map;
	private MultipleEntityHandler entityHandler;
	private Window window;
	private char[][][] allMaps;
	private boolean newGame = false;

	public Game(int width, int height, char[][][] map, Window window) {
		this.lives = 5;
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
		int newLives = multyListener(entityHandler.getEnemies(), this.lives);
		int newCakeCount = multyListener(entityHandler.getCakes(), 0);

		if (newMapNumber != mapNumber) {
			resetLevel(newMapNumber);
			if (newMapNumber < 0) {
				window.close();
				window = new Window("Game Over", 800, 600);
				window.setColor(255, 127, 0);
				window.setBold(true);
				window.setFontSize(50);
				window.drawStringCentered("You Won", 400, 300);
				window.open();
				window.waitUntilClosed();
			} 
		} else if (newLives != this.lives) {
			resetLevel(newMapNumber);
			if (newLives <= 0) {
				//this.drawLosingScreen();
				window.close();
				window = new Window("Game Over", 800, 600);
				window.setColor(255, 127, 0);
				window.setBold(true);
				window.setFontSize(50);
				window.drawStringCentered("You Lost", 400, 300);
				window.open();
				window.waitUntilClosed();
			}
			this.lives = newLives;
			System.out.println(this.lives);
		}

		return false;
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
			newAmount = entity.listener(amount, player);
		}
		return newAmount;
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

	public void drawWinningScreen() {
		
		window.drawStringCentered("YOU WIN", 100, 100);
	}
	
	public void drawLosingScreen() {
		window.setColor(255, 255, 255);
		window.drawRect(0, 0, 800, 600);
		window.drawStringCentered("YOU LOOSE", 100, 100);
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
