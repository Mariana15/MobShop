package ua.controller.admin;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static ua.service.utils.ParamBuilder.getParams;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.dto.filter.BasicFilter;
import ua.entity.Category;
import ua.service.CategoryService;
import ua.validator.CategoryValidator;


@Controller
@RequestMapping("/admin/category")
@SessionAttributes(names = "category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@ModelAttribute("category")
	public Category getForm() {
		return new Category();
	}
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("page", categoryService.findAll(filter, pageable));
		return "admin-category";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		categoryService.delete(id);
		return "redirect:/admin/category"+getParams(pageable, filter);
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("category", categoryService.findOne(id));
		model.addAttribute("page", categoryService.findAll(filter, pageable));
		return "admin-category";
	}

	@RequestMapping(method=POST)
	public String save(@ModelAttribute("category")  Category category, SessionStatus status,Model model,  @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
	
		categoryService.save(category);
		status.setComplete();
		return "redirect:/admin/category"+getParams(pageable, filter);
	}
}
