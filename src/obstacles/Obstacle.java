package obstacles;

import gui.Window;

public class Obstacle {

	private char[][] mapOutline;
	

	public Obstacle(char[][] mapOutline) {
		this.mapOutline = mapOutline;
	}

	public void draw(Window window) {
		for (int col = 0; col < mapOutline.length; col++) {
			for (int row = 0; row < mapOutline[col].length; row++) {
				if (mapOutline[col][row] == '#') {
					drawCube(row, col, window);
				}
			}
		}
	}

	private void drawCube(int x, int y, Window window) {
		window.setColor(0, 0, 0);
		window.fillRect(x*50, y*50, 50, 50 );
	}
	

}
