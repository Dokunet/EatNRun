package entities;

import gui.WindowEatNRun;
import gui.Window;

public class Enemy extends BaseEntity {

	private int vx;
	private int vy;
	private char direction;
	private Player player;

	public Enemy(int x, int y, char[][] map, char direction) {
		super(x, y, 30, 30, map, direction);
		super.symbol = direction;
		this.direction = direction;

	}

	@Override
	public void draw(Window window) {
		window.drawImage("resources/images/monster.png", super.x, super.y);
	}

	public void step() {
		// super.move(super.x + this.vx, super.y + this.vy)
	}

	public void bounceOfHorizontal() {
		this.vy = this.vy * -1;
	}

	public void bounceOfVertical() {
		this.vx = this.vx * -1;
	}


}
