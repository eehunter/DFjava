package com.oyosite.ticon.rawlib.core.datatypes;

public class FixedInt {
	
	public int value = 0;
	public boolean set = false;
	
	public void set(int value) {
		if (!set) {set = true; this.value = value;}
	}
	
	public void set(int value, boolean force) {
		if (force || !set) {set = true; this.value = value;}
	}

}
