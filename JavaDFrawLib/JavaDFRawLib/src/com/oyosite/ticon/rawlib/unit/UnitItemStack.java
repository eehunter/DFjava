package com.oyosite.ticon.rawlib.unit;

import com.oyosite.ticon.rawlib.world.loader.WorldStorage;

public class UnitItemStack implements IUnit{

	public String position;

	@Override
	public void setPos(long x, long y, long z) {
		boolean cont = true;
		int index = 0;
		while (cont) {
			if (WorldStorage.worldMap.get(x+"_"+y+'_'+z+"_"+index) != null) {
				index++;
			}else {
				cont = false;
			}
			
		}
		WorldStorage.worldMap.put(position, null);
		position = x+"_"+y+'_'+z+"_"+index;
		WorldStorage.worldMap.put(position, this);
	}

	@Override
	public void onUpdate() {
		
	}

}
