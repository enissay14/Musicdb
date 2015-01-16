package org.javacademie.music;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacademie.music.db.HibernateUtils;
import org.javacademie.music.services.DocIterator;
import org.javacademie.music.services.DocReader;
import org.javacademie.music.services.DocWriter;
import org.javacademie.music.services.LineParser;
import org.javacademie.music.services.Updater;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;



public class App 
{
	private static Logger logger = LogManager.getLogger(App.class);
	
	static String directoryName = "C:/Users/MW/Desktop/EMSE Etude/JAcadémie/Projet 1/Music Files/";
	
	static LocalDateTime timePoint = LocalDateTime.now();
	
	static String dateInFormat = timePoint.getYear()+""+timePoint.getMonthValue()+""+timePoint.getDayOfMonth()+"_"+timePoint.getHour()+""+timePoint.getMinute()+""+timePoint.getSecond();
	
	static File destDir = new File("C:/Users/MW/Desktop/EMSE Etude/JAcadémie/Projet 1/processed_"+dateInFormat);	
	
	static String[] tokens = null;
	
	
   
    public static void main( String[] args ) {
    	
    	DocIterator docIter = new DocIterator(new File(directoryName));
    	
		logger.info("Precessing files on " + directoryName );
		
		try {
			
			HibernateUtils.setUp();
		
			while (docIter.hasMoreDocuments()) {
				
				File doc = docIter.nextDocument();
				
				if(doc.getName().contains(".music") ){
					
					DocReader reader = new DocReader(doc);
					
					logger.info("Inside " +doc.getName() + " ...");
					
					ArrayList<String> lines = reader.readDocumentLineByLine();
					
					for(int i = 0; i < lines.size(); i++){
						
						if(  lines.get(i).matches(".+")) {
						
							logger.info("parsing the line " + i +" : ["+ lines.get(i) + "]...");
							    
							LineParser parser = new LineParser( lines.get(i));
							
							tokens = parser.parseText();
							
							Updater updater = new Updater();
							
							updater.updateDatabase(tokens);
						
						}
						
						else {
							
							logger.info("Line "+i+" is Empty!");
						
						}
						
					}
					
					logger.info("Processing of " +doc.getName() +" finished !");
					
					DocWriter docWriter = new DocWriter();
					
					docWriter.moveDocuments(doc, destDir);
					
					}
				
				else{
					
					logger.info("Format Error : " +doc.getName() + " is Invalid! ");
				
				}
			}
		
		HibernateUtils.tearDown();
			
		} catch (Exception e) {
			
			logger.info("Hibernate Initiation Problem!");
			e.printStackTrace();
		}
		
		logger.info("Done.");
        
    }
    
      
}

