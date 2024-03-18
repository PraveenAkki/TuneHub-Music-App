package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Songs 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	String artist;
	String genre;
	String link;
	
	@ManyToMany
	List<PlayList> playlist;
	@ManyToMany
	List<UserPlayList> userplaylist;
	public Songs() {
		super();
	}
	public Songs(int id, String name, String artist, String genre, String link, List<PlayList> playlist,
			List<UserPlayList> userplaylist) {
		super();
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.genre = genre;
		this.link = link;
		this.playlist = playlist;
		this.userplaylist = userplaylist;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public List<PlayList> getPlaylist() {
		return playlist;
	}
	public void setPlaylist(List<PlayList> playlist) {
		this.playlist = playlist;
	}
	public List<UserPlayList> getUserplaylist() {
		return userplaylist;
	}
	public void setUserplaylist(List<UserPlayList> userplaylist) {
		this.userplaylist = userplaylist;
	}
	@Override
	public String toString() {
		return "Songs [id=" + id + ", name=" + name + ", artist=" + artist + ", genre=" + genre + ", link=" + link
				+ ", playlist=" + playlist + ", userplaylist=" + userplaylist + "]";
	}

	
	
}
