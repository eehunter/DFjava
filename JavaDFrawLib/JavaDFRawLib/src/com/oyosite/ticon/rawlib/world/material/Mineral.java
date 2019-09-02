package com.oyosite.ticon.rawlib.world.material;

import com.oyosite.ticon.rawlib.material.IMaterialSource;

public class Mineral implements IMaterialSource {
	
	public final String name;
	
	public Mineral(String name) {
		this.name = name;
	}

	@Override
	public String name() {
		return name;
	}

}
