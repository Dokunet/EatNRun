package entities;

import gui.Window;

public class Player extends BaseEntity {
	private int score;

	public Player(char[][] map) {
		super(0, 0, 50, 50);
		int x = 0;
		int y = 0;
		for (int col = 0; col < map.length; col++) {
			for (int row = 0; row < map[col].length; row++) {
				if (map[col][row] == 'P') {
					y = col * 50;
					x = row * 50 ;
				}
			}
		}
		super.x = x;
		super.y = y;
	}

	@Override
	public void draw(Window window) {

		window.drawImage("resources/images/hero.png", super.x, super.y);
		// window.fillRect(super.x, super.y, 2);
	}

	public void moveUp() {
		super.move(super.x, super.y - 6);
	}

	public void moveDown() {
		super.move(super.x, super.y + 6);
	}

	public void moveLeft() {
		super.move(super.x - 6, super.y);
	}

	public void moveRight() {
		super.move(super.x + 6, super.y);
	}

	public void incScore() {
		this.score += 1;
	}

	public int getScore() {
		return this.score;
	}
}