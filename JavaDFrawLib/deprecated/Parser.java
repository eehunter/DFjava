package com.oyosite.ticon.rawlib.deprecated;

import java.io.BufferedReader;
import java.io.FileReader;

public class Parser {
	
	
	
	public static void parse(String fileName) {
		FileReader input;
		BufferedReader bufRead;
		try {
			input = new FileReader(fileName);
			bufRead = new BufferedReader(input);
			
			
			String myLine = null;
			
			while ( (myLine = bufRead.readLine()) != null){    
				String[] array1 = myLine.split(":");
				// check to make sure you have valid data
				String[] array2 = array1[1].split(" ");
				for (int i = 0; i < array2.length; i++) {}
					//function(array1[0], array2[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
