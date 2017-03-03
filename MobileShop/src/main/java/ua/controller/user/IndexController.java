package ua.controller.user;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.dto.filter.ItemFilter;
import ua.entity.User;
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
import ua.service.UserService;

@Controller
@RequestMapping("/")
@SessionAttributes(names = "index")
public class IndexController {
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
	private UserService userService;
	@Autowired
	private DescriptionService descriptionService;

	@RequestMapping("/")
	public String index(Principal principal, Model model, @PageableDefault Pageable pageable,@ModelAttribute("filter") ItemFilter filter){
		if(principal!=null)
			System.out.println(principal.getName());
		model.addAttribute("page", itemService.findAll(pageable, filter));
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("cameras", cameraService.findAll());
		model.addAttribute("categorys", categoryService.findAll());
		model.addAttribute("colors", colorService.findAll());
		model.addAttribute("diagonals",diagonalService.findAll());
		model.addAttribute("fcs", frontCameraService.findAll());
		model.addAttribute("memories", memoryService.findAll());
		model.addAttribute("nocs", numberOfCoresService.findAll());
		model.addAttribute("noscs", numberOfSimCardsService.findAll());
		model.addAttribute("oses",osService.findAll());
		model.addAttribute("tss",typeSimService.findAll());
		model.addAttribute("descriptions",descriptionService.findAll());
		return "user-index";
	}
	
	
	@RequestMapping("/admin")
	public String admin(){
		return "admin-admin";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "user-login";
	}
	
	@RequestMapping("/registration")
	public String registration(Model model){
		model.addAttribute("userForm", new User());
		return "user-registration";
	}
	
	@RequestMapping(value="/registration", method=POST)
	public String registration(@ModelAttribute User user){
		userService.save(user);
		return "redirect:/";
	}
	@RequestMapping(value="/pageItem/{id}")
	public String showItemDetail(@PathVariable(value = "id")  int id, Model model){
		model.addAttribute("item", itemService.findOne(id));
		return "user-pageItem";
	}
	
	@RequestMapping(value = "/ordernow/{id}")
	public String ordernow(@PathVariable(value = "id") int id, Principal principal) {
		userService.addItem(id, principal);
		return "redirect:/";

	}

	
	@RequestMapping("/shoppingCart")
	public String show(Model model, Principal principal) {	
	    model.addAttribute("carts",userService.findByUsername(principal.getName()));  
		return "user-shoppingCart";
	}
	
	@RequestMapping(value = "/shoppingCart/delete/{id}", method = RequestMethod.GET)
	public String deleteItems(@PathVariable(value = "id") int id, Principal principal) {
		userService.deleteItems(id, principal);
		return "redirect:/shoppingCart/";

	}
	
}