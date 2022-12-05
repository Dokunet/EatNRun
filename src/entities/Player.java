package entities;

import gui.Window;


public class Player extends BaseEntity {
    private int score;
    public Player(int x, int y) {
        super(x, y, 50, 200);
    }
    @Override
    public void draw(Window window){
 
        window.drawImage("resources/images/hero.png", super.x , super.y);
     //   window.fillRect(super.x, super.y, 2);
    }
    public void moveUp(){
        super.move(super.x, super.y - 6 );
    }

    public void moveDown(){
        super.move(super.x, super.y + 6 );
    }

    public void moveLeft(){
        super.move(super.x - 6, super.y );
    }

    public void moveRight(){
        super.move(super.x + 6, super.y );
    }

    public void incScore(){
        this.score += 1;
    }

    public int getScore(){
        return this.score;
    }
}