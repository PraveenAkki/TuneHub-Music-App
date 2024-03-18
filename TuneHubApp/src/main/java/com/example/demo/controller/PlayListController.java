package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entities.PlayList;
import com.example.demo.entities.Songs;
import com.example.demo.services.PlayListService;
import com.example.demo.services.SongsService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PlayListController 
{
	@Autowired
	PlayListService pserv;
	
	@Autowired
	SongsService sserv;
	
	@GetMapping("/createplaylist")
	public String createPlayList(Model model) 
	{
		//fetch the songs
		List<Songs> songslist = sserv.fetchAllSongs();
		
		//Adding the songs in model
		model.addAttribute("songslist", songslist);
		
		//sending createplaylist
		return "createplaylist";
	}
	
	@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute PlayList playlist) {
		//adding playlist
		pserv.addPlaylist(playlist);
		
		//update song table
		List<Songs> songsList = playlist.getSongs();
		for(Songs song:songsList) {
			song.getPlaylist().add(playlist);
			sserv.updateSong(song);
		}
		return "admin";
	}
	
	@GetMapping("/viewplaylist")
	public String viewplaylists(Model model) {
		//fetch the Playlists
		List<PlayList> plist = pserv.fetchPlaylists();
		
		//Adding the playlists in model
		model.addAttribute("plist", plist);
		
		//sending viewplaylist
		return "viewplaylist";
	}
	
	
	
	
}
