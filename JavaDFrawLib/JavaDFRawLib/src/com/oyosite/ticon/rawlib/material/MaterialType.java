package com.oyosite.ticon.rawlib.material;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class MaterialType {
	

	public final String id;
	public final String name;
	public final String pluName;
	public final String adjName;
	public final Map<String, IMaterialProperty> properties = new HashMap<String, IMaterialProperty>();
	public char character = '▓';
	public Color color = Color.WHITE;
	public Color bgColor = Color.BLACK;
	public int meltingPoint = 200;
	public int boilingPoint = 2000;
	public int heatDamagePoint = 100;
	
	public MaterialType(String id, String name, String pluName, String adjName) {
		this.id = id;
		this.name = name;
		this.pluName = pluName;
		this.adjName = adjName;
	}
	
	public void setProperty(String name, IMaterialProperty property) {
		properties.put(name, property);
	}
	
	public IMaterialProperty getProperty(String name) {
		return properties.get(name);
	}
	
	

}
