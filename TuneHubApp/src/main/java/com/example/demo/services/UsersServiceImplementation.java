package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;
@Service
public class UsersServiceImplementation implements UsersService
{
	@Autowired
	UsersRepository repo;

	@Override
	public String addUser(Users user) {
		repo.save(user);
		return "User is created and saved!";
	}

	@Override
	public boolean emailExists(String email) {
		
		if(repo.findByEmail(email) == null)
		{
			return false;
		}
		else {
			return true;
		}
		
	}

	@Override
	public boolean validateUser(String email, String password) {
		
		Users user = repo.findByEmail(email);
		String db_password = user.getPassword();
		String hash = this.bytesToHex(password.getBytes());
		System.out.println(hash);
		System.out.println(db_password);
		
		if(db_password.equals(hash))
		{
			return true; 
		}
		else {
			return false;
		}
	}

	@Override
	public String getRole(String email) {
		return (repo.findByEmail(email).getRole());
	}

	@Override
	public Users getUser(String email) {
		return repo.findByEmail(email); 
	}

	@Override
	public void updateUser(Users user) {
		repo.save(user);
		
	}
	
	@Override
	public  String bytesToHex(byte[] hash) {
	    StringBuilder hexString = new StringBuilder(2 * hash.length);
	    for (int i = 0; i < hash.length; i++) {
	        String hex = Integer.toHexString(0xff & hash[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    } 
	    return hexString.toString();
	}

}
