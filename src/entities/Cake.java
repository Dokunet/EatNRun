package entities;

import gui.Window;

public class Cake extends BaseEntity{

	public Cake(int x, int y, char[][] map) {
		super(x, y, 30, 30, map, 'C');

	}

	@Override
	public void draw(Window window) {
		window.drawImage("resources/images/cake.png", super.x, super.y);
	}

	

}
