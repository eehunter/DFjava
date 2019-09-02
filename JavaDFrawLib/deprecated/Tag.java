package com.oyosite.ticon.rawlib.deprecated;

import java.util.ArrayList;

public class Tag {
	
	private final String name;
	private final TagParameter[] params;
	private final ArrayList<Tag> subTags = new ArrayList<>();
	private boolean disabled = false;
	
	public Tag (String name) {
		this.name = name;
		this.params = null;
	}
	
	public Tag (String name, TagParameter... params) {
		this.name = name;
		this.params = params;
	}
	
	public String getName() {
		return this.name;
	}
	
	public TagParameter[] getParams() {
		return this.params;
	}
	
	public boolean isDisabled() {
		return this.disabled;
	}
	
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	
	public ArrayList<Tag> getSubTags(){
		return subTags;
	}

}
