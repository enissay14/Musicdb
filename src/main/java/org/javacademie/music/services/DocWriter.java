package org.javacademie.music.services;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacademie.music.dao.ChansonDao;

public class DocWriter {
	
	private static Logger logger = LogManager.getLogger(ChansonDao.class);
	
	public void moveDocuments (File doc, File destDir) {
		
	logger.info("Copying file to " + destDir.getName() +"...");
		
	try {
		
		FileUtils.copyFileToDirectory(doc, destDir);
		
	} catch (IOException e) {
		
		logger.info("Copy of " + doc.getName() + " Impossible!");
		e.printStackTrace();
	}
	
	logger.info(doc.getName() +" copied to directory " + destDir.getName() +"!");
	
	}

}
