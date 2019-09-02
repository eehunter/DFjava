package com.oyosite.ticon.rawlib.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.oyosite.ticon.rawlib.creature.Caste;
import com.oyosite.ticon.rawlib.creature.CreatureType;
import com.oyosite.ticon.rawlib.item.Item;
import com.oyosite.ticon.rawlib.item.ItemEgg;
import com.oyosite.ticon.rawlib.material.MaterialType;
import com.oyosite.ticon.rawlib.material.MaterialTypeEggShell;
import com.oyosite.ticon.rawlib.material.MaterialTypeEggWhite;
import com.oyosite.ticon.rawlib.material.MaterialTypeEggYolk;
import com.oyosite.ticon.rawlib.unit.IUnit;

public class GameObjectRegistry {

	public static final Map<String, CreatureType> CREATURETYPES = new HashMap<String, CreatureType>();
	public static final ArrayList<Item> ITEMS = new ArrayList<Item>();
	public static final Map<String, MaterialType> MATERIALTYPES = new HashMap<String, MaterialType>();
	
	public static final Map<String, IUnit> UNITS = new HashMap<String, IUnit>(); 
	
	/**
	 * ONLY RUN ONCE PER RawStorageBase!
	 */
	public static void registerGameObjects(RawStorageBase raws) {
		//System.out.println(raws.gameDataCreatures.getDocumentElement().getTextContent());
		NodeList creatureNodes = raws.gameDataCreatures.getDocumentElement().getElementsByTagName("creature");
	    for(int i=0; i<creatureNodes.getLength(); i++) {
	    	String id = null, name = null, pluName = null, adjName = null;
			MaterialType shell_mat = new MaterialTypeEggShell(), yolk_mat = new MaterialTypeEggYolk(), white_mat = new MaterialTypeEggWhite();
	    	Map<String, Caste> castes = new HashMap<String, Caste>();
	    	boolean flier = false, sapient = false, playable = false;
	    	//System.out.println(creatureNodes.item(i).getTextContent());
	    	for (int j = 0; j<creatureNodes.item(i).getChildNodes().getLength(); j++) {
	    		//System.out.println(creatureNodes.item(i).getChildNodes().item(j).getTextContent());
	    		if (creatureNodes.item(i).getChildNodes().item(j).getNodeName() == "id") {id = creatureNodes.item(i).getChildNodes().item(j).getTextContent();}
	    		if (creatureNodes.item(i).getChildNodes().item(j).getNodeName() == "name") {name = creatureNodes.item(i).getChildNodes().item(j).getTextContent();}
	    		if (creatureNodes.item(i).getChildNodes().item(j).getNodeName() == "pluName") {pluName = creatureNodes.item(i).getChildNodes().item(j).getTextContent();}
	    		if (creatureNodes.item(i).getChildNodes().item(j).getNodeName() == "adjName") {adjName = creatureNodes.item(i).getChildNodes().item(j).getTextContent();}
	    		if (creatureNodes.item(i).getChildNodes().item(j).getNodeName() == "flier") {flier = true;}
	    		if (creatureNodes.item(i).getChildNodes().item(j).getNodeName() == "sapient") {sapient = true;}
	    		if (creatureNodes.item(i).getChildNodes().item(j).getNodeName() == "playable") {playable = true;}
	    		if (creatureNodes.item(i).getChildNodes().item(j).getNodeName() == "damage_limit") {}
	    		//if (creatureNodes.item(i).getChildNodes().item(j).getNodeName() == "adjName") {}
	    		//System.out.println(id);
	    		if (creatureNodes.item(i).getChildNodes().item(j).getNodeName() == "caste") {
	    			NodeList casteNodes = creatureNodes.item(i).getChildNodes().item(j).getChildNodes();
    				Caste caste = new Caste();
    				String casteName = "";
	    			for (int k = 0; k<casteNodes.getLength(); k++) {
		    			//System.out.println(casteNodes.item(k).getTextContent());
	    				
		    				
		    				if (casteNodes.item(k).getNodeName() == "name") {casteName = casteNodes.item(k).getTextContent();/*System.out.println("Caste Name: "+casteName);*/}
		    				if (casteNodes.item(k).getNodeName() == "weight") {caste.setWeight(Integer.parseInt(casteNodes.item(k).getTextContent()));}
		    				if (casteNodes.item(k).getNodeName() == "flier") {caste.setFlier(true);}
		    	    		if (casteNodes.item(k).getNodeName() == "sapient") {caste.setSapient(true);}
		    	    		if (casteNodes.item(k).getNodeName() == "playable") {caste.setPlayable(true);}
		    	    		if (casteNodes.item(k).getNodeName() == "restricted") {caste.setRestricted(Integer.parseInt(casteNodes.item(k).getTextContent()));}
		    				if (casteNodes.item(k).getNodeName() == "female") {
		    					//System.out.println(casteNodes.item(k).getChildNodes().getLength());
		    					for (int l = 0; l < casteNodes.item(k).getChildNodes().getLength(); l++) {
		    						if (casteNodes.item(k).getChildNodes().item(l).getNodeName() == "lays_eggs") {
		    							NodeList eggNodes = casteNodes.item(k).getChildNodes().item(l).getChildNodes();
		    							for (int m = 0; m<eggNodes.getLength(); m++) {
		    								if (eggNodes.item(m).getNodeName() == "shell_mat") {shell_mat = parseMaterialNodes(shell_mat, eggNodes.item(m), raws);}
		    								if (eggNodes.item(m).getNodeName() == "yolk_mat") {yolk_mat = parseMaterialNodes(yolk_mat, eggNodes.item(m), raws);}
		    								if (eggNodes.item(m).getNodeName() == "white_mat") {white_mat = parseMaterialNodes(white_mat, eggNodes.item(m), raws);}
		    								
		    								
		    								
		    								
		    							}
		    				    		ItemEgg egg = new ItemEgg("egg_"+id, name+" egg", name+" eggs", name+" egg", shell_mat, yolk_mat, white_mat);
		    				    		//System.out.println(egg.name);
		    				    		caste.setEggItem(egg);
		    						}
		    						if (casteNodes.item(k).getChildNodes().item(l).getNodeName() == "g_time") caste.g_length = Integer.parseInt(casteNodes.item(k).getChildNodes().item(l).getTextContent());
		    						if (casteNodes.item(k).getChildNodes().item(l).getNodeName() == "i_time") caste.i_length = Integer.parseInt(casteNodes.item(k).getChildNodes().item(l).getTextContent());
		    						//System.out.println(caste.i_length);
		    						//System.out.println(casteNodes.item(k).getChildNodes().item(l).getNodeName());
		    					}
		    					//System.out.println(casteNodes.item(k).getNodeName());
		    				}
		    				
	    				
	    				
	    			}

    				castes.put(casteName, caste);
	    		}
	    		
	    	}
	    	try {
	    		CreatureType type = new CreatureType(id, name, pluName, adjName);
	    		type.flier = flier;
	    		type.sapient = sapient;
	    		type.playable = playable;
	    		castes.forEach((k, v)->{if (v.getEggItem() != null) {v.getEggItem().setCreatureType(type);/*System.out.println(v.getEggItem().name);*/}});
	    		castes.forEach((k, v)->type.addCaste(k, v));
	    		CREATURETYPES.put(id, type);
	    		//System.out.println(id);
	    	}catch(Exception e) {e.printStackTrace();}
	    }
		
	}
	
	public static MaterialType parseMaterialNodes(MaterialType toBeParsed, Node node, RawStorageBase raws) {
		Document doc = raws.builder.newDocument();
		NodeList nodes = node.getChildNodes();
		for(int i = 0; i < nodes.getLength(); i++) {
			//System.out.println(nodes.item(i).getNodeName());
			if (nodes.item(i).getNodeName() == "template") {
				NodeList tempNodes = invokeTemplate(raws, nodes.item(i).getTextContent(), node.getNodeName());
				try{for(int j = 0; j < tempNodes.getLength(); j++) {
					//System.out.println(nodes.item(i).getNodeName());
					doc.importNode(tempNodes.item(j), true);
				}}catch(Exception e) {/*e.printStackTrace();*/}
			}else {doc.importNode(nodes.item(i), true);}
		}
		
		System.out.println(doc.getTextContent());
		
		for (int i = 0; i < doc.getChildNodes().getLength(); i++) {
			if (doc.getChildNodes().item(i).getNodeName() == "melt_point") {toBeParsed.meltingPoint = Integer.parseInt(doc.getChildNodes().item(i).getTextContent());}
			if (doc.getChildNodes().item(i).getNodeName() == "boil_point") {toBeParsed.boilingPoint = Integer.parseInt(doc.getChildNodes().item(i).getTextContent());}
			if (doc.getChildNodes().item(i).getNodeName() == "fireproof") {toBeParsed.heatDamagePoint = Integer.parseInt(doc.getChildNodes().item(i).getTextContent());}
			if (doc.getChildNodes().item(i).getNodeName() == "") {}
			if (doc.getChildNodes().item(i).getNodeName() == "") {}
			if (doc.getChildNodes().item(i).getNodeName() == "") {}
			if (doc.getChildNodes().item(i).getNodeName() == "") {}
			if (doc.getChildNodes().item(i).getNodeName() == "") {}
		}
		
		return toBeParsed;
		
	}
	
	public static NodeList invokeTemplate(RawStorageBase raws, String templateName, String templateItem) {
		
		for(int i=0; i<raws.gameDataTemplates.getDocumentElement().getChildNodes().getLength(); i++) {
			System.out.println("148: "+raws.gameDataTemplates.getDocumentElement().getChildNodes().item(i).getTextContent());
			System.out.println(templateName);
			System.out.println(templateName.equalsIgnoreCase(raws.gameDataTemplates.getDocumentElement().getChildNodes().item(i).getTextContent()));
			System.out.println("149: "+raws.gameDataTemplates.getDocumentElement().getChildNodes().item(i).getChildNodes().getLength());
			//System.out.println("149: "+getNode(raws.gameDataTemplates.getDocumentElement().getChildNodes().item(i), "name"));
			boolean foundTemp = false;
			NodeList tempNodes = null;
			for(int j = 0; j<raws.gameDataTemplates.getDocumentElement().getChildNodes().item(i).getChildNodes().getLength(); j++) {
				System.out.println("154: "+raws.gameDataTemplates.getDocumentElement().getChildNodes().item(i).getChildNodes().item(j).getParentNode().getNodeName());
				if (templateName.equalsIgnoreCase(raws.gameDataTemplates.getDocumentElement().getChildNodes().item(i).getTextContent())) {
					foundTemp = true;
					System.out.println("found temp");
				}
				if (templateItem.equalsIgnoreCase(raws.gameDataTemplates.getDocumentElement().getChildNodes().item(i).getChildNodes().item(j).getParentNode().getNodeName())) {
					tempNodes = raws.gameDataTemplates.getDocumentElement().getChildNodes().item(i).getChildNodes().item(j).getChildNodes();
					System.out.println("found item");
				}
			}
			
			if(foundTemp) return tempNodes;
			
			
			/*try{if (getNode(raws.gameDataTemplates.getDocumentElement().getChildNodes().item(i), "name").getTextContent() == templateName) {
				return getNode(raws.gameDataTemplates.getDocumentElement().getChildNodes().item(i), templateItem).getChildNodes();
			}}catch(Exception e) {e.printStackTrace();}*/
		}
		
		return null;
		
	}
	
	/**Returns the first node with name*/
	public static Node getNode(Node parentNode, String name) {
		System.out.println("162 "+((Element)parentNode).getTagName());
		System.out.println("163 "+((Element)parentNode).getChildNodes().item(0).getLocalName());
		return ((Element)parentNode).getElementsByTagName(name).item(0);
		/*System.out.println(nodeList.getLength());
		for(int i=0; i<nodeList.getLength(); i++) {
			if (nodeList.item(i).getNodeName() == name) return nodeList.item(i);
		}
		return null;*/
		
	}
}
