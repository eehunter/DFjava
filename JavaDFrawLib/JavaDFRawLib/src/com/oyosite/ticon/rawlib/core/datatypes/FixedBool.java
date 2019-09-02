package com.oyosite.ticon.rawlib.core.datatypes;

public class FixedBool {
	
	public boolean value = false;
	public boolean set = false;
	
	public void set(boolean value) {
		if (!set) {set = true; this.value = value;}
	}
	
	public void set(boolean value, boolean force) {
		if (force || !set) {set = true; this.value = value;}
	}

}
