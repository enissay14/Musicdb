package org.javacademie.music.services;
import java.io.File;

import org.javacademie.music.App;
import org.jboss.logging.Logger;


public class DocIterator {
	
	private static Logger logger = Logger.getLogger(DocIterator.class);
	
	protected File[] files = null;
	protected int position = 0;
	
	public DocIterator(File dirFile){
		 
		files = dirFile.listFiles();
		position = 0;
		    
	}
	
	public File nextDocument() {
		
	    if (position >= files.length)
	      return null;
	    
	    File doc = null;
	    doc = files[position];
	    position++;
	    return doc;
	    
	  }
	
	public boolean hasMoreDocuments() {
	    if (files != null && position < files.length)
	      return true;
	    else
	      return false;
	  }
	
	

}