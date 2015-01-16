package org.javacademie.music.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.javacademie.music.db.HibernateUtils;
import org.javacademie.music.domain.Album;
import org.javacademie.music.domain.Chanson;

public class ChansonDao {
	
private static Logger logger = LogManager.getLogger(ChansonDao.class);
	
	public void createChanson(Chanson chanson) throws Exception {
		
		logger.info("Creating Chanson : " + chanson + "...");
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		session.save(chanson);
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
		
		logger.info("Chanson created.");
	}

	public Chanson findChansonById(int id) throws Exception {
		
		logger.info("Finding Chanson with id : " + id + "...");
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		Chanson result = (Chanson)session.get(Chanson.class, id);
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
		
		if (result != null) {

			logger.info("Chanson found : " + result);
		}
		else {
			logger.info("Chanson not found");
		}
		
		return result;
	}
	
	public void updateChanson(Chanson chanson) throws Exception {

		logger.info("Updating Chanson : " + chanson + "...");
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		session.merge(chanson);
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
		
		logger.info("Chanson updated.");
	}

	public Chanson findChansonByCodeChansonAndCodeAlbum(int codeChanson, int codeAlbum)throws Exception {

		logger.info("Finding Song with id : " + codeChanson + "and" + codeAlbum + "...");

		Session session = HibernateUtils.getSession();

		session.beginTransaction();
		
		List<Chanson> listeChanson = session.createCriteria(Chanson.class)
				.add(Restrictions.like("codeChanson", codeChanson))
				.list();
	
		session.getTransaction().commit();

		HibernateUtils.closeSession(session);
			
		for(Chanson chanson : listeChanson){
			if (chanson.getAlbum().getCodeAlbum().equals(codeAlbum)){
				return chanson;
			}
		}

		return null;
		 
	
		
	}

}
