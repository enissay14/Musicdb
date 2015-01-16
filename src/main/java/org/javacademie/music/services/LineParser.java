package org.javacademie.music.services;
import java.util.*;

import org.javacademie.music.App;
import org.jboss.logging.Logger;

public class LineParser {
	
	
	private static Logger logger = Logger.getLogger(LineParser.class);
	 
	private String text;
			  
	private static final String DELIM = ",";
			 
	public LineParser(String line) {
		if( line != "")    
			text = line;
		else
			logger.info("Format Error: Line Invalid! ");
		
	}
	
	public String[] parseText() {
		
		    String[] result = text.split(DELIM);
		     return result;
	  }

	} 


