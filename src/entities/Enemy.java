package entities;

import gui.WindowEatNRun;
import gui.Window;
public class Enemy extends BaseEntity{
    
    private int vx;
    private int vy;

    public Enemy(int x, int y) {
        super(x, y, 30, 30);
        
        double signX = Math.random() > 0.5 ? 1 : -1;
        double signY = Math.random() > 0.5 ? 1 : -1;
    
        this.vx = (int) (signX * (2 + (Math.random() * 4)));
        this.vy = (int) (signY * (2 + (Math.random() * 4)));
    }
    @Override
    public void draw(Window window){
        window.setColor(0,0,0);
        window.fillRect(super.x, super.y, 50, 50);
    }

    public void step(){
        super.move(super.x + this.vx, super.y + this.vy);
    }

    public void bounceOfHorizontal(){
        this.vy = this.vy * -1;
    }

    public void bounceOfVertical(){
        this.vx = this.vx * -1;
    }
}
