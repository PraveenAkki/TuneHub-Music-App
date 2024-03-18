package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.PlayList;
import com.example.demo.entities.Songs;
import com.example.demo.entities.UserPlayList;
import com.example.demo.services.SongsService;
import com.example.demo.services.UserPlayListService;

@Controller
public class UserPlayListController 
{
	@Autowired
	UserPlayListService upserv;
	@Autowired
	SongsService sserv;
	
	@GetMapping("/createUserplaylist")
	public String createUserPlayList(Model model) 
	{
		//fetch the songs
		List<Songs> songslist = sserv.fetchAllSongs();
		
		//Adding the songs in model
		model.addAttribute("songslist", songslist);
		
		//sending createplaylist
		return "createUserplaylist";
	}
	
	@PostMapping("/adduserplaylist")
	public String adduserPlayList(@ModelAttribute UserPlayList userplaylist) {
		//adding playlist
		upserv.adduserPlayList(userplaylist);
		
		//update song table
		List<Songs> songsList = userplaylist.getSongs();
		for(Songs song:songsList) 
		{
			song.getUserplaylist().add(userplaylist);
			sserv.updateSong(song);
		}
		return "customerhome"; 
	}
	
	@GetMapping("/viewUserplaylist")
	public String viewplaylists(Model model) {
		//fetch the Playlists
		List<UserPlayList> plist = upserv.fetchPlaylists();
		
		//Adding the playlists in model
		model.addAttribute("plist", plist);
		
		//sending viewplaylist
		return "viewUserplaylist";
	}
}
