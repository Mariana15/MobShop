package ua.service;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.dto.filter.BasicFilter;
import ua.dto.filter.ItemFilter;
import ua.dto.form.ItemForm;
import ua.entity.Camera;
import ua.entity.Item;

public interface ItemService {
	ItemForm findOne(int id) ;
	List<Item> findAll();
	
	void delete(int id);
	

	void save(ItemForm form);
	 List<Item> findByUserId(Principal principal);
	 void addUsers(int id, Principal principal);
	
	Page<Item> findAll(Pageable pageable, ItemFilter filter);

}
