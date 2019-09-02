package com.oyosite.ticon.rawlib.material.properties;

import com.oyosite.ticon.rawlib.material.IMaterialProperty;

public class MatPropInt implements IMaterialProperty{
	
	public int value;

	@Override
	public Object value() {
		return value;
	}

	@Override
	public IMaterialProperty setValue(Object value) {
		if (value instanceof Integer) this.value = (int) value;
		return this;
	}

}
