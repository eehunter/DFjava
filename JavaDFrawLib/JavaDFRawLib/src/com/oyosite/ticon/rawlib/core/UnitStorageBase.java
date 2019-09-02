package com.oyosite.ticon.rawlib.core;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

public class UnitStorageBase {
	
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder;
	public Document gameDataUnits;
	
	public UnitStorageBase() {
		try {
			builder = factory.newDocumentBuilder();
			gameDataUnits = builder.newDocument();
			gameDataUnits.appendChild(gameDataUnits.createElement("gameDataUnits"));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	


}
