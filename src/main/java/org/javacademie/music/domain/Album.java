package org.javacademie.music.domain;

import java.util.HashSet;
import java.util.Set;

import org.javacademie.music.App;
import org.jboss.logging.Logger;

public class Album {
	
	private static Logger logger = Logger.getLogger(Album.class);
	
	private Integer codeAlbum;
	
	private String nomAlbum;
	
	private Set<Chanson> chansons;
	
	private Set<Artiste> artistes;
	
	
	public Album() {
		super();
		
		this.setArtistes(new HashSet<Artiste>());
		
		this.chansons = new HashSet<Chanson>();
		
	}

	public void ajouterArtiste(Artiste artiste) {
		
		this.artistes.add(artiste);
		
		artiste.getAlbums().add(this);
	}
	
	
	
	public void removeLigne(Chanson chanson) {
		
		this.chansons.remove(chanson);
	}


	public Integer getCodeAlbum() {
		return codeAlbum;
	}

	public void setCodeAlbum(Integer codeAlbum) {
		this.codeAlbum = codeAlbum;
	}

	public String getNomAlbum() {
		return nomAlbum;
	}

	public void setNomAlbum(String nomAlbum) {
		this.nomAlbum = nomAlbum;
	}

	public Set<Chanson> getChansons() {
		return chansons;
	}

	public void setChansons(Set<Chanson> chansons) {
		this.chansons = chansons;
	}

	@Override
	public String toString() {
		return "Album [codeAlbum=" + codeAlbum + ", nomAlbum=" + nomAlbum
				+ ", chansons=" + chansons + "]";
	}

	public Set<Artiste> getArtistes() {
		return artistes;
	}

	public void setArtistes(Set<Artiste> artistes) {
		this.artistes = artistes;
	}
	
	

}
