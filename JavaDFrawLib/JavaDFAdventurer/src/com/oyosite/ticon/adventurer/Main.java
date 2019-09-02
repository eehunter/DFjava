package com.oyosite.ticon.adventurer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import com.badlogic.gdx.graphics.Color;
import com.oyosite.ticon.rawlib.core.GameObjectRegistry;
import com.oyosite.ticon.rawlib.core.RawStorageBase;
import com.oyosite.ticon.rawlib.material.Material;
import com.oyosite.ticon.rawlib.unit.UnitPlayer;
import com.oyosite.ticon.rawlib.world.loader.WorldStorage;
import com.oyosite.ticon.rawlib.xml.XmlReader;
import com.ticon.oyosite.eternityspath.RenderEngine;
import com.ticon.oyosite.eternityspath.Tile;
import com.ticon.oyosite.eternityspath.desktop.DesktopLauncher;


public class Main {
	
	public static Display f = new Display();
	public static int w = 600;
	public static int h = 400;
	public static BufferedImage img;
	public static RawStorageBase raws = new RawStorageBase();
	public static XmlReader reader = new XmlReader("raw"+File.separator);
	
	@SuppressWarnings("static-access")
	public static void main(final String[] args) {
		/*f.setSize(w, h);
		f.setResizable(true);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Eternity's Path");*/
		
		//MainScreen.parameter.characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789.:,;\'\"()!?+-*/=â–ˆ█▓▒░│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═♠╬╧╨╤╥╙╘╒╓♣╪╫┘◘┌";
		
		
		img = null;
		try {
		    img = ImageIO.read(new File("src"+File.separator+"icon.png"));
			f.setIconImage(img);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Document xml = reader.readFile("something.xml");
		//System.out.println(xml.toString());
		//System.out.println(reader.readFile("creaturesmain.xml").toString());
		System.out.println(xml.getElementsByTagName("test").item(0).getTextContent());
		try {
			File[] rawFiles = new File("raw"+File.separator).listFiles();
			for (int i = 0; i < rawFiles.length; i++) {
				Document gamedata = reader.readFile(rawFiles[i].getName());
				raws.injectGameData(gamedata);
			}
		}catch (Exception e) {
		}
		GameObjectRegistry.registerGameObjects(raws);
		Transformer transformer;
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
			Result output = new StreamResult(new File("output3.xml"));
			Source input = new DOMSource(raws.gameDataTemplates);
			transformer.transform(input, output);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
		
		GameObjectRegistry.CREATURETYPES.forEach((k,v)->{
			v.CASTES.forEach((l, w)->{
				System.out.println("Caste Name: "+l);
				if (w.egg != null) {
					System.out.println("Egg: " + w.egg.name);
					System.out.println("Egg Shell: " + w.egg.MATERIALS.get("shell_mat").source.name() + " " + w.egg.MATERIALS.get("shell_mat").type.name + " " + w.egg.MATERIALS.get("shell_mat").type.heatDamagePoint);
				}
				
			});
			
			
			
			
		});
		
		WorldStorage world = new WorldStorage(0);
		world.loadTile(1, 35, 0);
		//System.out.println(world.getAdjacentTiles(0, 35, 0)[0]);
		
		UnitPlayer player = new UnitPlayer(GameObjectRegistry.CREATURETYPES.get("dragon"), GameObjectRegistry.CREATURETYPES.get("dragon").CASTES.get("immortal"));
		long startY = -20000;
		int startIndex = -100;
		while (startY == -20000) {
			world.loadTile(0, startIndex, 0);
			System.out.println(world.getTileObject(0, startIndex, 0));
			System.out.println(startIndex);
			if (world.getTileObject(0, startIndex, 0) == null) {
				startY = startIndex;
			}
			startIndex++;
		}
		player.setPos(0, startY, 0);
		world.loadArea(-100, startY-5, -100, 100, startY+5, 100);
		
		world.worldMap.forEach((k, v)->{if (k != null) {
			long x = 0, y = 0, z = 0, px = 0, py = 0, pz = 0, rx = 0, ry = 0, rz = 0;
			//System.out.println(k);
			String[] coords = k.split("_");
			String[] ppos = player.position.split("_");
			px = Long.parseLong(ppos[0]);
			py = Long.parseLong(ppos[1]);
			pz = Long.parseLong(ppos[2]);
			x = Long.parseLong(coords[0]);
			y = Long.parseLong(coords[1]);
			z = Long.parseLong(coords[2]);
			rx = px-x-50;
			ry = py-y;
			rz = pz-z-50;
			if (y == Long.parseLong(ppos[1])) {
			System.out.println("rx: "+rx);
			System.out.println("rz: "+rz);
			System.out.println(coords[3].equalsIgnoreCase("0"));
			//System.out.println(y == Long.parseLong(ppos[1]));
			System.out.println(rz<55 && rz>0);
			System.out.println(rx<96 && rx>0);}
			//System.out.println(coords[3]);
			//System.out.println(coords[3].equalsIgnoreCase("0"));
			//System.out.println(y == Long.parseLong(ppos[1]));
			
			
			if (coords[3].equalsIgnoreCase("0") && y == Long.parseLong(ppos[1]) && rx<96 && rx>0 && rz<55 && rz>0 ) {
				System.out.println("set a tile");
				Color color = new Color(((Material)world.getTileObject(x, y, z)).type.color.getRed()/255, ((Material)world.getTileObject(x, y, z)).type.color.getGreen()/255, ((Material)world.getTileObject(x, y, z)).type.color.getBlue()/255, 1.0f);
				Color bgColor = new Color(((Material)world.getTileObject(x, y, z)).type.bgColor.getRed()/255, ((Material)world.getTileObject(x, y, z)).type.bgColor.getGreen()/255, ((Material)world.getTileObject(x, y, z)).type.bgColor.getBlue()/255, 1.0f);
				System.out.println("set a tile");
				RenderEngine.setTile((int)rx, (int)rz, new Tile(((Material)world.getTileObject(x, y, z)).type.character, color, bgColor, 0.0d));
			
		}}});
		RenderEngine.setTile(1, 1, new Tile('▓', new Color(1, 1, 1, 1), new Color(0, 0, 0, 1), 0.0d));
		//RenderEngine.renderScene();
		System.out.println(RenderEngine.getTile(1, 1).character);
		System.out.println(startY);

		DesktopLauncher.main(args);
		
		//System.out.println(NoiseMapGenerator.noise(120.357, 0.264, 0.252));
		//System.out.println(raws.gameDataCreatures.getDocumentElement().getTextContent());
		/*NodeList creatureNodes = raws.gameDataCreatures.getDocumentElement().getElementsByTagName("creature");
	    for(int i=0; i<creatureNodes.getLength(); i++) {
	    	NodeList childNodes = creatureNodes.item(i).getChildNodes();
	    	//System.out.println(creatureNodes.item(i).getChildNodes().item(1).getTextContent());//(creatureNodes.item(i).getTextContent())+"bla");
	    	for(int j=0; j<childNodes.getLength(); j++) {
	    		//System.out.println(childNodes.item(j).getNodeName());
	    		if (childNodes.item(j).getNodeName().equals("name")) {
	    			System.out.println((childNodes.item(j).getTextContent())/*+"bla"*//*);
	    		}
	    	}
	    }*/
	}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

}