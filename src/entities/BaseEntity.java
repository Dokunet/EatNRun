package entities;

import gui.Window;

public class BaseEntity {
	protected int x;
	protected int y;
	public int width;
	public int height;
	private char[][] map;

	public BaseEntity(int x, int y, int width, int height, char[][] map) {
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

	public void draw2(Window window) {
		window.setColor(0, 255, 0);
		window.fillRect(this.x, this.y, this.width, this.height);
	}

	public boolean intersects(BaseEntity other) {
		return x - width / 2 < other.x + other.width / 2 && x + width / 2 > other.x - other.width / 2
				&& y - height / 2 < other.y + other.height / 2 && y + height / 2 > other.y - other.height / 2;
	}

	public boolean doesCollide(int dx, int dy, int characterMarginRight, int characterMarginDown, char object) {
		int xIndex = dx / 50;
		int yIndex = dy / 50;
		int xIndexAddedMargin = (dx + characterMarginRight) / 50;
		int yIndexAddedMargin = (dy + characterMarginDown) / 50;
		if (this.map[yIndex][xIndex] == object || this.map[yIndexAddedMargin][xIndexAddedMargin] == object
		 || this.map[yIndex][xIndexAddedMargin] == object || this.map[yIndexAddedMargin][xIndex] == object) {	
			return true;
		}

		return false;
	}

}
