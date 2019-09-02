package com.oyosite.ticon.rawlib.unit;

import com.oyosite.ticon.rawlib.creature.Caste;
import com.oyosite.ticon.rawlib.creature.CreatureType;

public class UnitPlayer extends UnitCreature{
	
	public static String playerPos;

	public UnitPlayer(CreatureType creature, Caste caste) {
		super(creature, caste);
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void onUpdate() {
		super.onUpdate();
		this.playerPos = position;
		
	}

}
