package com.oyosite.ticon.rawlib.unit;

import com.oyosite.ticon.rawlib.core.GameObjectRegistry;
import com.oyosite.ticon.rawlib.creature.Caste;
import com.oyosite.ticon.rawlib.creature.CreatureType;
import com.oyosite.ticon.rawlib.world.loader.WorldStorage;

public class UnitCreature implements IUnit {
	
	public String position;
	public CreatureType creature;
	public Caste caste;
	//public ArrayList<Modifier> modifiers;
	
	public UnitCreature(CreatureType creature, Caste caste) {
		this.creature = creature;
		this.caste = caste;
	}
	
	public UnitCreature(String creatureID) {
		this.creature = GameObjectRegistry.CREATURETYPES.get(creatureID);
	}

	@Override
	public void setPos(long x, long y, long z) {
		boolean cont = true;
		int index = 1;
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
