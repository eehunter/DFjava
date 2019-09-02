package com.ticon.oyosite.eternityspath;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class RenderEngine {
	private static Map<String, Tile> tileMap = new HashMap<String, Tile>();;
	
	public static void setTile(int x, int y, Tile tile) {
		RenderEngine.tileMap.put(x + "-" + y, tile);
	}
	
	public static Tile getTile(int x, int y) {
		return RenderEngine.tileMap.get(x + "-" + y);
	}
	
	public static void renderScene() {
		MainScreen.batch.setProjectionMatrix(MainScreen.camera.combined);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		MainScreen.batch.begin();
		for(int x = 0; x < 96; x++) {
			for(int y = 0; y < 55; y++) {
				RenderEngine.renderTile(x, y, x * 20, y * 20);
			}
		}
		MainScreen.batch.end();
		MainScreen.camera.update();
	}
	
	public static void renderTile(int x, int y, int locX, int locY) {
		Tile tile = RenderEngine.getTile(x, y);
		//if (x == 1 && y == 1)System.out.println(tile.character);
		MainScreen.font.setColor(tile.bgCol);
		MainScreen.font.draw(MainScreen.batch, "█", locX, locY);
		MainScreen.font.setColor(tile.textCol);
		MainScreen.font.draw(MainScreen.batch, "" + tile.character, locX, locY);
	}
}