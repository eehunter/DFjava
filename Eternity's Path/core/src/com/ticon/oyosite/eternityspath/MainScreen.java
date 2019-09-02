package com.ticon.oyosite.eternityspath;

import java.util.Random;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MainScreen implements Screen {
	public static Random random;
	public static OrthographicCamera camera;
	public static FreeTypeFontGenerator generator;
	public static FreeTypeFontParameter parameter;
	public static BitmapFont font;
	public static SpriteBatch batch;
	public static ShapeRenderer shapes;	
	public MainScreen() {
		random = new Random();
		for(int x = 0; x < 96; x++) {
			for(int y = 0; y < 55; y++) {
				RenderEngine.setTile(x, y, new Tile('a', new Color(1, 0, 0, 1), new Color(random.nextFloat(), random.nextFloat(), random.nextFloat(), 1), (double) 1));
			}
		}
		camera = new OrthographicCamera(960, 540);
		camera.setToOrtho(false, 1920, 1080);
		generator = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
		parameter = new FreeTypeFontParameter();
		parameter.size = 20;
		parameter.characters = "☺☻♥♦♣♠•◘○♂♀♪♫☼►◄↕‼¶§▬↨↑↓→←∟↔▲▼!\\\"#$%&\\'()*+,-./1234567890:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\\\]^_`abcdefghijklmnopqrstuvwxyz{|}~⌂ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜ¢£¥₧ƒáíóúñÑªº¿⌐¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╪╫┘┌█▄▌▐▀αßΓπΣσµτΦΘΩδ∞φε∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■ ";
		parameter.magFilter = TextureFilter.Linear;
		parameter.minFilter = TextureFilter.Linear;
		font = generator.generateFont(parameter);
		generator.dispose();
		batch = new SpriteBatch();
		shapes = new ShapeRenderer();
		Gdx.graphics.setTitle("Eternity's Path Pre-Alpha");
	}

	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
		RenderEngine.renderScene();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		
	}
	
	
}