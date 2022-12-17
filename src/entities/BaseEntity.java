package entities;

import gui.Window;

public class BaseEntity {
	protected int x;
	protected int y;
	protected int arrayIndex;
	protected char symbol;
	public int width;
	public int height;
	private char[][] map;

	public BaseEntity(int x, int y, int width, int height, char[][] map, char symbol) {
		this.symbol = symbol;
		this.map = map;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void move(int dx, int dy, int characterMarginRight, int characterMarginDown) {
		if (doesCollide(dx, dy, characterMarginRight, characterMarginDown, '#')) {
			return;
		}
		this.y = dy;
		this.x = dx;
	}

	public void draw(Window window) {
		window.setColor(255, 0, 0);
		window.fillRect(this.x, this.y, this.width, this.height);
	}

	public boolean doesCollide(int dx, int dy, int characterMarginRight, int characterMarginDown, char object) {
		int xIndex = dx / 40;
		int yIndex = dy / 40;
		int xIndexAddedMargin = (dx + characterMarginRight) / 40;
		int yIndexAddedMargin = (dy + characterMarginDown) / 40;
		if (this.map[yIndex][xIndex] == object || this.map[yIndexAddedMargin][xIndexAddedMargin] == object
				|| this.map[yIndex][xIndexAddedMargin] == object || this.map[yIndexAddedMargin][xIndex] == object) {
			System.out.println("xIndex: " + xIndex + " yIndex: " + yIndex + " CrackXIndex: " + xIndexAddedMargin
					+ " crackYIndex: " + yIndexAddedMargin);
			return true;
		}

		return false;
	}

	public int listener(int amount, Player player) {
		if (this.symbol == 'N' || this.symbol == 'E' || this.symbol == 'W' || this.symbol == 'S' ) {
			if (player.doesCollide(player.x + 15, player.y + 20, 5, 5, 'N')
					|| player.doesCollide(player.x + 15, player.y + 20, 5, 5, 'S')
					|| player.doesCollide(player.x + 15, player.y + 20, 5, 5, 'W')
					|| player.doesCollide(player.x + 15, player.y + 20, 5, 5, 'E')) {
				amount--;
			}
		} else {
			if (player.doesCollide(player.x + 15, player.y + 20, 5, 5, this.symbol)) {
				amount--;
			}
		}
		return amount;
	}

	public char getSymbol() {
		return this.symbol;
	}

	public int getArrayIndex() {
		return this.arrayIndex;
	}

}
