package entities;

import gui.Window;

public class Finish extends BaseEntity {
	
	private int col;
	private int row;
	
	public Finish(char[][] map) {
		super(0, 0, 50, 50, map);
		for (int col = 0; col < map.length; col++) {
			for (int row = 0; row < map[col].length; row++) {
				if (map[col][row] == 'F') {
					y = col * 50;
					x = row * 50;
				}
			}
		}
	}
	
	@Override
	public void draw(Window window) {

		window.drawImage("resources/images/finish.png", super.x, super.y);
		// window.fillRect(super.x, super.y, 2);
	}
	
	public int listener(int mapNumber, Player player) {
		
		if(player.doesCollide(row, col, 50, 50, 'F')) {
			System.out.println("yaaay");
		}
		
		return mapNumber;
	}

}
