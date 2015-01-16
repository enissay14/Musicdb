package org.javacademie.music.dao;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.javacademie.music.db.HibernateUtils;
import org.javacademie.music.domain.Artiste;

public class ArtisteDao {
	
private static Logger logger = LogManager.getLogger(ArtisteDao.class);
	
	public void createArtiste(Artiste artiste) throws Exception {
		
		logger.info("Creating artiste : " + artiste + "...");
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		session.save(artiste);
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
		
		logger.info("artiste created.");
	}

	public boolean isArtisteOnDatabase(int codeArtiste) throws Exception {
		
		logger.info("Finding artiste with codeArtiste : " + codeArtiste + "...");
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		Artiste result = (Artiste)session.get(Artiste.class, codeArtiste);
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
		
		if (result != null) {

			logger.info("artiste found : " + result);
			return false;
		}
		else {
			logger.info("artiste not found");
			return true;
		}
		
	}
	
	public void updateArtiste(Artiste artiste) throws Exception {

		logger.info("Updating artiste : " + artiste + "...");
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		session.merge(artiste);
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
		
		logger.info("artiste updated.");
	}

	public Artiste findArtisteByCodeArtiste(int codeArtiste) throws Exception {

		logger.info("Finding Artist with CodeArtiste : " + codeArtiste + "...");

		Session session = HibernateUtils.getSession();

		session.beginTransaction();

		Artiste result = (Artiste) session.get(Artiste.class, (Serializable) codeArtiste);

		session.getTransaction().commit();

		HibernateUtils.closeSession(session);

		if (result != null) {

			logger.info("Artiste found : " + result);
		} else {
			logger.info("Artiste not found");
		}

		return result;
	}


}
