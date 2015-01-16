package org.javacademie.music.domain;

import java.util.HashSet;
import java.util.Set;



public class Chanson {
	
	private Integer id;

	private Integer codeChanson;
	
	private String titreChanson;
	
	private Integer duree;
	
	private Album album;
	
	public Chanson() {
		
		super();
		
	}

	public void ajouterAlbum(Album album) {
		
		album.getChansons().add(this);
		
		this.setAlbum(album);
		
	}

	public Album getAlbum() {
		return album;
	}
	
	public void setAlbum(Album album) {
		this.album = album;
	}

	public Integer getCodeChanson() {
		return codeChanson;
	}

	public void setCodeChanson(Integer codeChanson) {
		this.codeChanson = codeChanson;
	}

	public String getTitreChanson() {
		return titreChanson;
	}

	public void setTitreChanson(String nomChanson) {
		this.titreChanson = nomChanson;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Chanson [codeChanson=" + codeChanson + ", nomChanson="
				+ titreChanson + ", duree=" + duree + "]";
	}
	
	

}
