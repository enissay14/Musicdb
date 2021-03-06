package org.javacademie.music.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
	
	private static SessionFactory sessionFactory;
	
	public static void setUp() throws Exception {
	
		Configuration configuration = new Configuration().configure();
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		
		HibernateUtils.sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
	}
	
	public static Session getSession() throws Exception {
		
		return HibernateUtils.sessionFactory.openSession();
	}
	
	public static void closeSession(Session session) throws Exception {
		
		session.close();
	}
	
	public static void tearDown() throws Exception {
		
		HibernateUtils.sessionFactory.close();
	}
}
