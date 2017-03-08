package ua.service.implementation;

import java.security.Principal;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
public class UserServiceImpl implements UserDetailsService, UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void setItemRepository(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public void setEncoder(BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}

	@Override
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRole(Role.ROLE_USER);
		userRepository.save(user);
	}

	@PostConstruct
	public void admin() {
		User user = userRepository.findByUsername("admin");
		if (user == null) {
			user = new User();
			user.setEmail("");
			user.setPassword(encoder.encode("admin"));
			user.setRole(Role.ROLE_ADMIN);
			user.setUsername("admin");
			userRepository.save(user);
		}
	}

	@Override
	public User findByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}

	@Override
	public int getUserId(Principal principal) {

		String name = principal.getName();
		User user = findByUsername(name);
		return user.getId();
	}

	@Override
	@Transactional
	public void addItem(int Id, Principal principal) {
		Item item = itemRepository.findOne(Id);
		String name = principal.getName();
		User user = findByUsername(name);
		user.getItems().add(item);
		userRepository.save(user);

	}

	@Transactional
	public String preparationToSend(String username) {

		String mailBody = "";
		User user = userRepository.findByUsername(username);
		for (Item item : user.getItems()) {
			mailBody = "User Detail:" + " \n  \n" + "Name:" + user.getUsername() + " \n  \n" + "Email:" + user.getEmail() + " \n  \n"

					+ "Item Detail:" + " \n  \n"

					+ "Producer:" + item.getProducer().getName() + " \n  \n" + "Price: " + item.getPrice() + " \n  \n" + "Description " + item.getDescription().getName();

		}
		return mailBody;

	}

	@Override
	@Transactional
	public void deleteItems(int id, Principal principal) {
		String name = principal.getName();
		User user = findByUsername(name);
		user.getItems().removeIf(i -> i.getId() == id);

		userRepository.save(user);
	}

	@Override
	public void buyItems(int id, Principal principal) {
		String name = principal.getName();
		User user = findByUsername(name);
		user.getItems().removeIf(i -> i.getId() == id);
		userRepository.save(user);
	}

	@Override
	@Transactional
	public void sendMail(String content, String email, String mailBody) {

		Properties properties = System.getProperties();

		properties.setProperty("mail.smtp.starttls.enable", "true");

		properties.setProperty("mail.smtp.auth", "true");

		properties.setProperty("mail.smtp.port", "465");

		properties.setProperty("mail.smtp.host", "smtp.gmail.com");

		properties.setProperty("mail.smtp.socketFactory.port", "465");

		properties.setProperty("mail.smtp.socketFactory.class",

				"javax.net.ssl.SSLSocketFactory");

		Session session = Session.getDefaultInstance(properties,

				new Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {

						return new PasswordAuthentication("marianabenk@gmail.com", "viktor09");

					}

				});

		try {

			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(email));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(

					email));

			message.setSubject(content, "UTF-8");

			message.setText(mailBody);

			Transport.send(message);

		} catch (MessagingException е) {

			е.printStackTrace();
		}
	}

}