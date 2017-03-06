package ua.service;

import java.security.Principal;

import ua.entity.User;

public interface UserService {

	void save(User user);
	 User findByUsername(String username);
	 public int getUserId(Principal principal);
	 
	 void addItem(int Id, Principal principal);
	 
	 void deleteItems(int id,  Principal principal);
	 
}
