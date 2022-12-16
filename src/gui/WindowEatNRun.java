package gui;

import gui.Window;
import map.MapGenerator;
import gameLogic.*;
public class WindowEatNRun {
    private static int WIDTH = 1000;
    private static  int HEIGHT = 750;

    public static void main(String[] args) {
    	
    	MapGenerator mg = new MapGenerator();
        Game game = new Game(WIDTH, HEIGHT, mg.getMaps());

        Window window = new Window("Eat and RUN", WIDTH, HEIGHT);
        window.open();
        
        // Game loop
    	
        while (window.isOpen()) {
            game.handleEvents(window);
            if(game.step()) {
            	break;
            };
            game.drawGame(window);
            window.refreshAndClear(20);
        }
    }


    
}
