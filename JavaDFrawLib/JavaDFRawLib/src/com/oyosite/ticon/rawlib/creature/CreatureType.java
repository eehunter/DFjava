package com.oyosite.ticon.rawlib.creature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.oyosite.ticon.rawlib.bp.BodyPart;
import com.oyosite.ticon.rawlib.material.IMaterialSource;

public class CreatureType implements IMaterialSource{
	
	public final ArrayList<BodyPart> BODY_PARTS = new ArrayList<BodyPart>();
	/**Do not add to directly. Use addCaste(caste);*/
	public final Map<String, Caste> CASTES = new HashMap<String, Caste>();
	public final String id;
	public final String name;
	public final String pluName;
	public final String adjName;
	public boolean flier;
	public boolean sapient;
	public boolean playable;
	public int damage_limit = 0;
	
	public CreatureType(String id, String name, String pluName, String adjName) {
		this.id = id;
		this.name = name;
		this.pluName = pluName;
		this.adjName = adjName;
	}
	
	public void addCaste(String id, Caste caste) {
		
		if(this.flier) caste.setFlier(true);
		if(this.playable) caste.setPlayable(true);;
		CASTES.put(id, caste);
	}
	
	public void addBodyPart(BodyPart bp) {
		BODY_PARTS.add(bp);
	}

	@Override
	public String name() {
		return name;
	}
	
	
	
	
	
	

}
