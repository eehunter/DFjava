package com.oyosite.ticon.rawlib.item;

import java.util.HashMap;
import java.util.Map;

import com.oyosite.ticon.rawlib.creature.CreatureType;
import com.oyosite.ticon.rawlib.material.Material;
import com.oyosite.ticon.rawlib.material.MaterialType;

public class ItemEgg extends Item {
	
	public CreatureType creatureType;
	public Map<String, MaterialType> materials = new HashMap<>();

	public ItemEgg(String id, String name, String pluName, String adjName, MaterialType shellMaterial, MaterialType yolkMaterial, MaterialType whiteMaterial) {
		
		materials.put("shell_mat", shellMaterial);
		materials.put("yolk_mat", yolkMaterial);
		materials.put("white_mat", whiteMaterial);
		this.id = id;
		this.name = name;
		this.pluName = pluName;
		this.adjName = adjName;
		
		
	}
	
	public void setCreatureType(CreatureType type) {
		this.creatureType = type;
		materials.forEach((k, v)->{this.MATERIALS.put(k, new Material(this.creatureType, v));});
	}
	
	

}