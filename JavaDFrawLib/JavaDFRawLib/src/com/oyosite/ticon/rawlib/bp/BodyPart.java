package com.oyosite.ticon.rawlib.bp;

import java.util.HashMap;
import java.util.Map;

import com.oyosite.ticon.rawlib.material.Material;

public class BodyPart {
	
	public final Map<String, Material> MATERIALS = new HashMap<String, Material>();
	public final String name;
	public final String id;
	public boolean think = false;
	public boolean breath = false;
	public boolean circulate = false;
	public boolean eat = false;
	public boolean internal = false;
	public int relSize = 100;
	
	public BodyPart(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public void setBaseMaterial(Material mat) {
		MATERIALS.put("base", mat);
	}
	
	public void addMaterial(String key, Material mat) {
		MATERIALS.put(key, mat);
	}
	
	public void setThink(boolean think) {
		this.think = think;
	}
	
	public void setBreath(boolean breath) {
		this.breath = breath;
	}
	
	public void setCirculte(boolean circulate) {
		this.circulate = circulate;
	}
	
	public void setEat(boolean eat) {
		this.eat = eat;
	}
	
	public void setInternal(boolean internal) {
		this.internal = internal;
	}
	
	public void setRelSize(int relSize) {
		this.relSize = relSize;
	}
	
	
	
	

}