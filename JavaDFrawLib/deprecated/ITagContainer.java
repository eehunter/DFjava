package com.oyosite.ticon.rawlib.deprecated;

public interface ITagContainer {
	
	public Tag[] getTags();
	public void setTags(Tag... tags);
	public void addTags(Tag... tags);
	public void addTag(Tag tag);
	public void removeTag(String name);
	public boolean hasTag(String name);
	public Tag getTag();
	
	

}
