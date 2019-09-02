package com.oyosite.ticon.rawlib.material;

public class Material {
	
	public IMaterialSource source;
	public MaterialType type;
	
	public Material(IMaterialSource source, MaterialType type) {
		this.source = source;
		this.type = type;
	}

}
