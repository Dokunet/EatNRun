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
		if (direction == 'N') {
			this.vy = -1;
			this.vx = 0;
		} else if (direction == 'S') {
			this.vy = 1;
			this.vx = 0;
		} else if (direction == 'E') {
			this.vx = 1;
			this.vy = 0;
		} else if (direction == 'W') {
			this.vx = -1;
			this.vy = 0;
		}

	}

	@Override
	public void draw(Window window) {
		window.drawImage("resources/images/monster.png", super.x, super.y);
	}

	public void step() {
		if(super.doesCollide(super.x, super.y, 39, 39, '#')) {
			this.vx = this.vx * -1;
			this.vy = this.vy * -1;
		}
		 super.move(super.x + this.vx, super.y + this.vy);
	}

	public void bounceOfHorizontal() {
		this.vy = this.vy * -1;
	}

	public void bounceOfVertical() {
		this.vx = this.vx * -1;
	}


}
