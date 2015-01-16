package org.javacademie.music.domain;

import java.util.HashSet;
import java.util.Set;

public class Artiste {
	
	private Integer codeArtiste;
	
	private String nomArtiste;
	
	private Set<Album> albums;
	

	
	public Artiste() {
		
		super();
		
		this.albums = new HashSet<Album>();
		
		
	}

	public Integer getCodeArtiste() {
		return codeArtiste;
	}

	public void setCodeArtiste(Integer codeArtiste) {
		this.codeArtiste = codeArtiste;
	}

	public String getNomArtiste() {
		return nomArtiste;
	}

	public void setNomArtiste(String nomArtiste) {
		this.nomArtiste = nomArtiste;
	}

	public Set<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

	@Override
	public String toString() {
		return "Artiste [codeArtiste=" + codeArtiste + ", nomArtiste="
				+ nomArtiste + ", albums=" + albums + "]";
	}

	
	
	
	
	

}
