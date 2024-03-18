package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.UserPlayList;

public interface UserPlayListRepository extends JpaRepository<UserPlayList, Integer>
{

}
