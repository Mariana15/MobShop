package ua.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.dto.filter.ItemFilter;
import ua.dto.form.ItemForm;
import ua.editor.CameraEditor;
import ua.editor.CategoryEditor;
import ua.editor.ColorEditor;
import ua.editor.DescriptionEditor;
import ua.editor.DiagonalEditor;
import ua.editor.FrontCameraEditor;
import ua.editor.MemoryEditor;
import ua.editor.NumberOfCoresEditor;
import ua.editor.NumberOfSimCardsEditor;
import ua.editor.OSEditor;
import ua.editor.ProducerEditor;
import ua.editor.TypeSimEditor;
import ua.entity.Camera;
import ua.entity.Category;
import ua.entity.Color;
import ua.entity.Description;
import ua.entity.Diagonal;
import ua.entity.FrontCamera;
import ua.entity.Memory;
import ua.entity.NumberOfCores;
import ua.entity.NumberOfSimCards;
import ua.entity.OS;
import ua.entity.Producer;
import ua.entity.TypeSim;
import ua.service.CameraService;
import ua.service.CategoryService;
import ua.service.ColorService;
import ua.service.DescriptionService;
import ua.service.DiagonalService;
import ua.service.FrontCameraService;
import ua.service.ItemService;
import ua.service.MemoryService;
import ua.service.NumberOfCoresService;
import ua.service.NumberOfSimCardsService;
import ua.service.OSService;
import ua.service.ProducerService;
import ua.service.TypeSimService;
import ua.validator.ItemValidator;

@Controller
@RequestMapping("/admin/item")
@SessionAttributes(names = "item")
public class ItemController {
	@Autowired
	private ItemService itemService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProducerService producerService;
	@Autowired
	private CameraService cameraService;
	@Autowired
	private ColorService colorService;
	@Autowired
	private DiagonalService diagonalService;
	@Autowired
	private MemoryService memoryService;
	@Autowired
	private NumberOfCoresService numberOfCoresService;
	@Autowired
	private NumberOfSimCardsService numberOfSimCardsService;
	@Autowired
	private OSService osService;
	@Autowired
	private TypeSimService typeSimService;
	@Autowired
	private FrontCameraService frontCameraService;
	@Autowired
	private DescriptionService descriptionService;

	@InitBinder("item")
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
		binder.registerCustomEditor(Producer.class, new ProducerEditor(producerService));
		binder.registerCustomEditor(Color.class, new ColorEditor(colorService));
		binder.registerCustomEditor(OS.class, new OSEditor(osService));
		binder.registerCustomEditor(TypeSim.class, new TypeSimEditor(typeSimService));
		binder.registerCustomEditor(Camera.class, new CameraEditor(cameraService));
		binder.registerCustomEditor(Diagonal.class, new DiagonalEditor(diagonalService));
		binder.registerCustomEditor(Memory.class, new MemoryEditor(memoryService));
		binder.registerCustomEditor(NumberOfCores.class, new NumberOfCoresEditor(numberOfCoresService));
		binder.registerCustomEditor(NumberOfSimCards.class, new NumberOfSimCardsEditor(numberOfSimCardsService));
		binder.registerCustomEditor(FrontCamera.class, new FrontCameraEditor(frontCameraService));
		binder.registerCustomEditor(Description.class, new DescriptionEditor(descriptionService));
		binder.setValidator(new ItemValidator());
	}

	@ModelAttribute("item")
	public ItemForm getForm() {
		return new ItemForm();
	}

	@ModelAttribute("filter")
	public ItemFilter getFilter() {
		return new ItemFilter();
	}

	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ItemFilter filter) {
		model.addAttribute("page", itemService.findAll(pageable, filter));
		model.addAttribute("categorys", categoryService.findAll());
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("fcs", frontCameraService.findAll());
		model.addAttribute("tss", typeSimService.findAll());
		model.addAttribute("nocs", numberOfCoresService.findAll());
		model.addAttribute("noscs", numberOfSimCardsService.findAll());
		model.addAttribute("oses", osService.findAll());
		model.addAttribute("cameras", cameraService.findAll());
		model.addAttribute("colors", colorService.findAll());
		model.addAttribute("diagonals", diagonalService.findAll());
		model.addAttribute("memories", memoryService.findAll());
		model.addAttribute("descriptions", descriptionService.findAll());
		/// status.setComplete();
		return "admin-item";
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ItemFilter filter) {
		model.addAttribute("item", itemService.findOne(id));
		show(model, pageable, filter);
		return "admin-item";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") ItemFilter filter) {
		itemService.delete(id);
		return "redirect:/admin/item" + getParams(pageable, filter);
	}

	/*
	 * @RequestMapping(method=POST) public String
	 * save(@ModelAttribute("item") @Valid ItemForm item, BindingResult br,
	 * Model model, SessionStatus sessionStatus, @PageableDefault Pageable
	 * pageable, @ModelAttribute("filter") ItemFilter filter){
	 * if(br.hasErrors()){
	 * 
	 * model.addAttribute("page", itemService.findAll(filter, pageable));
	 * model.addAttribute("categorys", categoryService.findAll());
	 * model.addAttribute("producers", producerService.findAll());
	 * model.addAttribute("fcs", frontCameraService.findAll());
	 * model.addAttribute("tss", typeSimService.findAll());
	 * model.addAttribute("nocs", numberOfCoresService.findAll());
	 * model.addAttribute("noscs", numberOfSimCardsService.findAll());
	 * model.addAttribute("oses", osService.findAll());
	 * model.addAttribute("cameras", cameraService.findAll());
	 * model.addAttribute("colors", colorService.findAll());
	 * model.addAttribute("diagonals", diagonalService.findAll());
	 * model.addAttribute("memories", memoryService.findAll()); return
	 * "admin-item"; } itemService.save(item); sessionStatus.setComplete();
	 * return "redirect:/admin/item"; }
	 */
	@PostMapping
	public String save(@ModelAttribute("item") @Valid ItemForm item, BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") ItemFilter filter) {
		if (br.hasErrors()) {
			show(model, pageable, filter);
			return "admin-item";
		}
		itemService.save(item);
		status.setComplete();
		return "redirect:/admin/item" + getParams(pageable, filter);
	}

	private String getParams(Pageable pageable, ItemFilter filter) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("?page=");
		buffer.append(String.valueOf(pageable.getPageNumber() + 1));
		buffer.append("&size=");
		buffer.append(String.valueOf(pageable.getPageSize()));
		if (pageable.getSort() != null) {
			buffer.append("&sort=");
			Sort sort = pageable.getSort();
			sort.forEach((order) -> {
				buffer.append(order.getProperty());
				if (order.getDirection() != Direction.ASC)
					buffer.append(",desc");
			});
		}
		if (!filter.getSearch().isEmpty()) {
			buffer.append("&search=");
			buffer.append(filter.getSearch());
		}
		if (!filter.getMaxPrice().isEmpty()) {
			buffer.append("&maxPrice=");
			buffer.append(filter.getMaxPrice());
		}
		if (!filter.getMinPrice().isEmpty()) {
			buffer.append("&minPrice=");
			buffer.append(filter.getMinPrice());
		}

		for (Integer id : filter.getProducerIds()) {
			buffer.append("&producerIds=");
			buffer.append(id);
		}
		for (Integer id : filter.getProducerIds()) {
			buffer.append("&cameraIds=");
			buffer.append(id);
		}
		for (Integer id : filter.getProducerIds()) {
			buffer.append("&categoryIds=");
			buffer.append(id);
		}
		for (Integer id : filter.getProducerIds()) {
			buffer.append("&colorIds=");
			buffer.append(id);
		}
		for (Integer id : filter.getProducerIds()) {
			buffer.append("&diagonalIds=");
			buffer.append(id);
		}
		for (Integer id : filter.getProducerIds()) {
			buffer.append("&fcIds=");
			buffer.append(id);
		}
		for (Integer id : filter.getProducerIds()) {
			buffer.append("&memoryIds=");
			buffer.append(id);
		}
		for (Integer id : filter.getProducerIds()) {
			buffer.append("&nocIds=");
			buffer.append(id);
		}
		for (Integer id : filter.getProducerIds()) {
			buffer.append("&noscIds=");
			buffer.append(id);
		}
		for (Integer id : filter.getProducerIds()) {
			buffer.append("&osIds=");
			buffer.append(id);
		}
		for (Integer id : filter.getProducerIds()) {
			buffer.append("&tsIds=");
			buffer.append(id);
		}

		return buffer.toString();
	}
}
