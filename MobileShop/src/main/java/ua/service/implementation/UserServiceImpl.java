package ua.service.implementation;

import java.security.Principal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Item;
import ua.entity.Role;
import ua.entity.User;
import ua.repository.ItemRepository;
import ua.repository.UserRepository;
import ua.service.UserService;

@Service("userDetailsService")
public class UserServiceImpl implements UserDetailsService, UserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}
	@Override
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRole(Role.ROLE_USER);
		userRepository.save(user);
	}

   
	@PostConstruct
	public void admin(){
		User user = userRepository.findByUsername("admin");
		if(user==null){
			user = new User();
			user.setEmail("");
			user.setPassword(encoder.encode("admin"));
			user.setRole(Role.ROLE_ADMIN);
			user.setUsername("admin");
			userRepository.save(user);
		}
	}
	@Override
	public User findByUsername(String username) 
		throws UsernameNotFoundException {
			return userRepository.findByUsername(username);
		}
	@Override
	public int getUserId(Principal principal){
		 
	      String name = principal.getName();
	      User  user = findByUsername(name);
	      return user.getId();
	}
	@Override
	@Transactional
	public void addItem( int Id, Principal principal) {
		Item item = itemRepository.findOne(Id);
		String name = principal.getName();
	    User user = findByUsername(name);
	      user.getItems().add(item);
	      userRepository.save(user);
	     
	     
	}
	
	@Override
	@Transactional
	public void deleteItems(int id,  Principal principal) {
		String name = principal.getName();
	     User user = findByUsername(name);
	     user.getItems().removeIf(i->i.getId()==id);
	   
	     userRepository.save(user);
	}
}