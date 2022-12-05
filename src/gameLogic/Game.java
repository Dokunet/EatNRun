package gameLogic;
import gui.Window;
import map.MapGenerator;
import obstacles.Obstacle;
import entities.BaseEntity;
import entities.*;

public class Game {
    private int width;
    private int height;
    private BaseEntity north;
    private BaseEntity south;
    private BaseEntity west;
    private BaseEntity east;
    private Enemy ball;
    private Player player;
    private Obstacle map;
    private boolean newGame = false;

    public Game(int width, int height, char[][][] map) {
        this.width = width;
        this.height = height;
        
        this.map = new Obstacle(map[0]);
        this.player = new Player(400, 300);
        this.ball = new Enemy(400, 300);
        this.north = new BaseEntity(1, 1, 800, 1);
        this.south = new BaseEntity(0, 599, 800, 1);
        this.west = new BaseEntity(1, 1, 1, 600);
        this.east = new BaseEntity(799, 1, 1, 600);
        
        // TODO Ball und Spieler erzeugen

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

    public void step() {
       // this.ball.step();
        // if ((this.ball.x == this.playerLeft.x + 10 && this.ball.y >= this.playerLeft.y
        //         && this.ball.y <= this.playerLeft.y + 90)
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
        this.ball.draw(window);
       // this.playerLeft.draw(window);
        this.player.draw(window);
        this.north.draw2(window);
        this.south.draw2(window);
        this.east.draw(window);
        this.west.draw(window);
        window.setColor(0, 0, 0);
        window.setBold(true);
        window.setFontSize(13);
      //  window.drawStringCentered(playerLeft.getScore() + ":" + playerRight.getScore(), 400, 50);
        if (this.newGame){
            this.ball =  new Enemy(400, 300);
            this.newGame = false;
        }

    }
}
