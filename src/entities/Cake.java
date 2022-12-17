package entities;

import gui.Window;

public class Cake extends BaseEntity{
	
	public Cake(int x, int y, char[][] map, int arrayIndex) {
		super(x, y, 30, 30, map, 'C');
		super.arrayIndex = arrayIndex;
	}

	@Override
	public void draw(Window window) {
		window.drawImage("resources/images/cake.png", super.x, super.y);
	}
	
	

	

}
