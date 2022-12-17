package entities;

import gui.Window;

public class Player extends BaseEntity {
	public Player(char[][] map) {
		super(0, 0, 40, 40, map, 'P');
		int x = 0;
		int y = 0;
		for (int col = 0; col < map.length; col++) {
			for (int row = 0; row < map[col].length; row++) {
				if (map[col][row] == 'P') {
					y = col * 40;
					x = row * 40;
				}
			}
		}
		super.x = x;
		super.y = y;
	}

	@Override
	public void draw(Window window) {
		window.drawImage("resources/images/hero.png", super.x, super.y);
	}

	public void moveUp() {

		super.move(super.x, super.y - 4, 20, 0);
	}

	public void moveDown() {
		super.move(super.x, super.y + 4, 20, 30);
	}

	public void moveLeft() {
		super.move(super.x - 4, super.y, 0, 30);
	}

	public void moveRight() {
		super.move(super.x + 4, super.y, 20, 30);
	}

	public int getX() {
		return super.x;
	}

	public int getY() {
		return super.y;
	}
}