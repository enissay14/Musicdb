package org.javacademie.music.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.jboss.logging.Logger;

public class DocReader {
	
	private static Logger logger = Logger.getLogger(DocReader.class);
	
	private File document;
	
	private String extension; 
	  		 
	public DocReader(File doc) {
		
		
			document = doc;
		
	}
	
	public ArrayList<String> readDocumentLineByLine(){
		
		ArrayList<String> resultLines = new ArrayList<String>();
		
		String line;
		
		try (BufferedReader br = new BufferedReader(new FileReader(document))){
			
			while ((line = br.readLine()) != null) {
				
				resultLines.add(line);
				
			}
			
		}
		catch (IOException e) {
			logger.info("\nCould not read the document: " + document);
			e.printStackTrace();
		} 
		
		logger.info("Document read succesfully");
		return resultLines;
		
		
	}

}
