package org.javacademie.music.services;

import org.javacademie.music.dao.AlbumDao;
import org.javacademie.music.dao.ArtisteDao;
import org.javacademie.music.dao.ChansonDao;
import org.javacademie.music.domain.Album;
import org.javacademie.music.domain.Artiste;
import org.javacademie.music.domain.Chanson;
import org.jboss.logging.Logger;

public class Updater {

	private static Logger logger = Logger.getLogger(Updater.class);
	
	Integer codeArtiste;
	
	String nomArtiste;
	
	Integer codeAlbum;
	
	String nomAlbum;
	
	Integer codeChanson;
	
	String titreChanson;
	
	Integer duree;
	
	public void updateDatabase(String[] tokens) throws Exception {
	
	codeArtiste  = Integer.valueOf(tokens[0].trim()) ;
	nomArtiste = tokens[1].trim();
	codeAlbum = Integer.valueOf(tokens[2].trim());
	nomAlbum = tokens[3].trim();
	codeChanson = Integer.valueOf(tokens[4].trim());
	titreChanson = tokens[5].trim();
	duree = Integer.valueOf(tokens[6].trim());
	
	ArtisteDao artisteDao = new ArtisteDao();
	AlbumDao albumDao = new AlbumDao();
	ChansonDao chansonDao = new ChansonDao();
	
		Artiste artiste = artisteDao.findArtisteByCodeArtiste(codeArtiste);
		if (artiste == null) {
		 Artiste singer = new Artiste();
		 singer.setCodeArtiste(codeArtiste);
		 singer.setNomArtiste(nomArtiste);
		 artisteDao.createArtiste(singer);
		 artiste = singer;
		}
		else
		{
			artiste.setNomArtiste(nomArtiste);
			artisteDao.updateArtiste(artiste);
		}

		Album album = albumDao.findAlbumByCodeAlbum(codeAlbum);
		if (album == null) {
			Album alb = new Album();
			alb.setCodeAlbum(codeAlbum);
			alb.setNomAlbum(nomAlbum);
			alb.ajouterArtiste(artiste);
			albumDao.createAlbum(alb);
			album=alb;
		}
		else
		{
			album.setNomAlbum(nomAlbum);
			albumDao.updateAlbum(album);
		}
	
		Chanson chanson = chansonDao.findChansonByCodeChansonAndCodeAlbum(codeChanson, codeAlbum);
		if (chanson == null) {
			Chanson song = new Chanson();
			song.setCodeChanson(codeChanson);
			song.setTitreChanson(titreChanson);
			song.setDuree(duree);
			song.ajouterAlbum(album);
			chansonDao.createChanson(song);
			chanson=song;
		}
		else
		{
			chanson.setCodeChanson(codeChanson);
			chanson.setDuree(duree);
			chansonDao.updateChanson(chanson);
		}
	}

	

	

}
