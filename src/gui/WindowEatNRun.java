package gui;

import gui.Window;
import map.MapGenerator;
import gameLogic.*;

public class WindowEatNRun {
	private static int WIDTH = 800;
	private static int HEIGHT = 600;

	public static void main(String[] args) {

		MapGenerator mg = new MapGenerator();

		Window window = new Window("Eat and RUN", WIDTH, HEIGHT);
		window.open();
		Game game = new Game(WIDTH, HEIGHT, mg.getMaps(), window);

		// Game loop

		while (window.isOpen()) {
			game.handleEvents();
			if (game.step()) {
				window.close();
			}
			;
			game.drawGame();
			window.refreshAndClear(20);
		}
	}

}
