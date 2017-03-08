package ua.service.implementation;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.dto.filter.ItemFilter;
import ua.dto.form.ItemForm;
import ua.entity.Item;
import ua.entity.User;
import ua.repository.ItemRepository;
import ua.service.FileWriter;
import ua.service.FileWriter.Folder;
import ua.service.ItemService;
import ua.service.UserService;
import ua.service.specifications.ItemSpecification;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private FileWriter fileWriter;

	@Autowired
	private UserService userService;

	@Override
	@Transactional(readOnly = true)
	public List<Item> findAll() {
		return itemRepository.findAll();
	}

	@Override
	public void delete(int id) {
		itemRepository.delete(id);
	}

	@Override
	@Transactional
	public void save(ItemForm itemForm) {
		Item item = new Item();
		item.setId(itemForm.getId());
		item.setCategory(itemForm.getCategory());
		item.setName(itemForm.getName());
		item.setPrice(new BigDecimal(itemForm.getPrice().replace(',', '.')));
		item.setProducer(itemForm.getProducer());
		item.setCamera(itemForm.getCamera());
		item.setColor(itemForm.getColor());
		;
		item.setDiagonal(itemForm.getDiagonal());
		item.setFc(itemForm.getFc());
		item.setMemory(itemForm.getMemory());
		item.setNoc(itemForm.getNoc());
		item.setNosc(itemForm.getNosc());
		item.setOs(itemForm.getOs());
		item.setTs(itemForm.getTs());
		item.setDescription(itemForm.getDescription());
		item = itemRepository.saveAndFlush(item);

		if (fileWriter.write(Folder.ITEM, itemForm.getFile(), item.getId())) {
			if (item.getVersion() == null)
				item.setVersion(0);
			else
				item.setVersion(item.getVersion() + 1);
		}
		itemRepository.save(item);
	}

	@Override
	public Page<Item> findAll(Pageable pageable, ItemFilter filter) {
		Page<Item> items = itemRepository.findAll(new ItemSpecification(filter), pageable);
		return items;
	}

	@Override
	@Transactional(readOnly = true)
	public ItemForm findOne(int id) {
		Item entity = itemRepository.findOne(id);
		ItemForm itemForm = new ItemForm();
		itemForm.setId(entity.getId());
		itemForm.setCamera(entity.getCamera());
		itemForm.setCategory(entity.getCategory());
		itemForm.setProducer(entity.getProducer());
		itemForm.setColor(entity.getColor());
		itemForm.setDiagonal(entity.getDiagonal());
		itemForm.setFc(entity.getFc());
		itemForm.setMemory(entity.getMemory());
		itemForm.setNoc(entity.getNoc());
		itemForm.setNosc(entity.getNosc());
		itemForm.setOs(entity.getOs());
		itemForm.setTs(entity.getTs());
		itemForm.setDescription(entity.getDescription());
		itemForm.setPrice(String.valueOf(entity.getPrice()));
		itemForm.setVersion(String.valueOf(entity.getVersion()));
		return itemForm;
	}

	@Override
	public List<Item> findByUserId(Principal principal) {
		return itemRepository.findByUserId(userService.getUserId(principal));
	}

	@Override
	@Transactional
	public void addUsers(int id, Principal principal) {
		Item item = itemRepository.findOne(id);
		String name = principal.getName();
		User user = userService.findByUsername(name);
		item.getUsers().add(user);
	}

}
