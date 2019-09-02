package com.ticon.oyosite.eternityspath;

import com.badlogic.gdx.graphics.Color;

public class Tile {
	public char character;
	public Color textCol;
	public Color bgCol;
	public double alpha;
	
	public Tile(char character, Color textCol, Color bgCol, double alpha) {
		this.character = character;
		this.textCol = textCol;
		this.bgCol = bgCol;
		this.alpha = alpha;
	}
}