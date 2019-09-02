package com.oyosite.ticon.rawlib.material.properties;

import com.oyosite.ticon.rawlib.material.IMaterialProperty;

public class MatPropBool implements IMaterialProperty {

	public boolean value;
	
	@Override
	public Object value() {
		return value;
	}

	@Override
	public IMaterialProperty setValue(Object value) {
		if (value instanceof Boolean) this.value = (boolean) value;
		return this;
	}

}
