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
    private boolean newGame = false;

    public Game(int width, int height, char[][][] map) {
        this.width = width;
        this.height = height;
        this.mapNumber = map.length;
        this.map = new Obstacle(map[0]);
        this.player = new Player(map[0]);
        this.finish = new Finish(map[0]);
       

    }

    public void handleEvents(Window window) {
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
    	
    	mapNumber = this.finish.listener(mapNumber, player);
    	
    	if(mapNumber < 0) {
    		return true;
    	}
    	
    	return false;
        //this.ball.step();
         //if ((this.ball.x == this.playerLeft.x + 10 && this.ball.y >= this.playerLeft.y
           //      && this.ball.y <= this.playerLeft.y + 90)
        //     || (this.ball.x == this.playerRight.x && this.ball.y >= this.playerRight.y
        //         && this.ball.y <= this.playerRight.y + 90)) {
        //     this.ball.bounceOfVertical();
        // } else if (this.ball.y == 0 || this.ball.y == 600) {
        //     this.ball.bounceOfHorizontal();
        // } else if (this.ball.x < 0){
        //     this.playerRight.incScore();
        //     this.newGame = true;
        // } else if (this.ball.x > 800){
        //     this.playerLeft.incScore();
        //     this.newGame = true;
        // }

        // // TODO Einen Zeitschritt prozessieren, also den Ball bewegen und Kollisionen
        // behandeln.
    }

    public void drawGame(Window window) {
    	this.map.draw(window);

       // this.playerLeft.draw(window);
        this.player.draw(window);
        this.finish.draw(window);
        window.setColor(0, 0, 0);
        window.setBold(true);
        window.setFontSize(13);
      //  window.drawStringCentered(playerLeft.getScore() + ":" + playerRight.getScore(), 400, 50);
        if (this.newGame){
       
            this.newGame = false;
        }

    }
    
}
