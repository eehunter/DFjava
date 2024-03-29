package com.oyosite.ticon.rawlib.item;

import java.util.HashMap;
import java.util.Map;

import com.oyosite.ticon.rawlib.material.Material;

public class Item {
	
	public final Map<String, Material> MATERIALS = new HashMap<String, Material>();

	public String id;
	public String name;
	public String pluName;
	public String adjName;
	
	/**
	 * Warning! DO NOT USE THIS CONSTRUCTER! IT IS ONLY FOR SUBCLASSES.
	 */
	public Item() {
		
	}
	
	public Item(String id, String name, String pluName, String adjName, Map<String, Material> materials) {
		this.id = id;
		this.name = name;
		this.pluName = pluName;
		this.adjName = adjName;
		this.MATERIALS.putAll(materials);
	}

}
