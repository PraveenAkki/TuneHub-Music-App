package com.example.demo.services;

import java.util.List;


import com.example.demo.entities.UserPlayList;


public interface UserPlayListService
{

	public void adduserPlayList(UserPlayList userplaylist);

	public List<UserPlayList> fetchPlaylists();

}
