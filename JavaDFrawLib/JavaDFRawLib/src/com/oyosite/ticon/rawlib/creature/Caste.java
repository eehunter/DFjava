package com.oyosite.ticon.rawlib.creature;

import com.oyosite.ticon.rawlib.core.datatypes.FixedBool;
import com.oyosite.ticon.rawlib.item.ItemEgg;

public class Caste {
	
	public FixedBool male = new FixedBool();
	public FixedBool female = new FixedBool();
	public int g_length;
	public int i_length;
	public int restricted = 0;
	public ItemEgg egg = null;
	public FixedBool flier = new FixedBool();
	public FixedBool sapient = new FixedBool();
	public FixedBool playable = new FixedBool();
	public int damage_limit = 0;
	public int weight = 200;
	
	public Caste() {
		
	}
	
	public void setMale(boolean male) {
		this.male.set(male);
	}
	
	public void setFemale(boolean female) {
		this.female.set(female);
	}
	
	public void setEggItem(ItemEgg eggItem) {
		this.egg = eggItem;
	}
	public void setFlier(boolean flier) {
		this.flier.set(flier);
	}
	public void setSapient(boolean sapient) {
		this.sapient.set(sapient);
	}
	public void setPlayable(boolean playable) {
		this.playable.set(playable);
	}
	public void setDamageLimit(int damage_limit) {
		this.damage_limit = damage_limit;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void setRestricted(int restricted) {
		this.restricted = restricted;
	}
	
	public ItemEgg getEggItem() {
		return this.egg;
	}
	
	

}
