package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.UserPlayList;
import com.example.demo.repositories.UserPlayListRepository;


@Service
public class UserPlayListServiceImplementation implements UserPlayListService
{
	@Autowired
	UserPlayListRepository uprepo;

	@Override
	public void adduserPlayList(UserPlayList userplaylist) {
		uprepo.save(userplaylist);
		
	}

	@Override
	public List<UserPlayList> fetchPlaylists() {
		return uprepo.findAll();
	}
}
