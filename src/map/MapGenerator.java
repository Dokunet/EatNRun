package map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MapGenerator {

	public char[][][] Maps;

	public MapGenerator() {
		getPathOfFiles();
	}

	public void getPathOfFiles() {
		final File folder = new File("resources/maps/");
		int numberOfMaps = folder.listFiles().length;
		readFiles(numberOfMaps, folder);
	}

	private void readFiles(int numberOfMaps, File folder) {
		BufferedReader br = null;
		this.Maps = new char[numberOfMaps][15][20];
		String line = null;
		File[] fileEntry = folder.listFiles();
		//for (final File fileEntry : folder.listFiles()) {
		for(int map = 0; map < numberOfMaps; map++)	{
		File file = new File(fileEntry[map].getAbsoluteFile().toString());
			try {
				br = new BufferedReader(new FileReader(file));

				//for (int map = 0; map < numberOfMaps; map++) {
					for (int col = 0; col < 15; col++) {
						try {
							line = br.readLine();
						} catch (IOException e) {
							e.printStackTrace();
						}
						for (int row = 0; row < 20; row++) {
							this.Maps[map][col][row] = line.charAt(row);
						}

					}
				//}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

	public char[][][] getMaps() {
		return this.Maps;
	}
}
