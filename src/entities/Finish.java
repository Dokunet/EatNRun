package entities;

import gui.Window;

public class Finish extends BaseEntity {

	public Finish(char[][] map) {
		super(0, 0, 40, 40, map, 'F');
		for (int col = 0; col < map.length; col++) {
			for (int row = 0; row < map[col].length; row++) {
				if (map[col][row] == 'F') {
					y = col * 40;
					x = row * 40;
				}
			}
		}
	}
	
	@Override
	public void draw(Window window) {
		window.drawImage("resources/images/finish.png", super.x, super.y);
	}

}
