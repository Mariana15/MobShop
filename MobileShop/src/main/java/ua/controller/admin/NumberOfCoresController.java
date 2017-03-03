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
import ua.entity.Diagonal;
import ua.entity.NumberOfCores;
import ua.service.NumberOfCoresService;
import ua.validator.FrontCameraValidator;
import ua.validator.NumberOfCoresValidator;

@Controller
@RequestMapping("/admin/noc")
@SessionAttributes(names = "noc")
public class NumberOfCoresController {
	@Autowired
	private NumberOfCoresService numberOfCoresService;
	
	@ModelAttribute("noc")
	public NumberOfCores getForm() {
		return new NumberOfCores();
	}
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("page", numberOfCoresService.findAll(filter, pageable));
		return "admin-noc";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		numberOfCoresService.delete(id);
		return "redirect:/admin/noc"+getParams(pageable, filter);
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("noc", numberOfCoresService.findOne(id));
		model.addAttribute("page", numberOfCoresService.findAll(filter, pageable));
		return "admin-noc";
	}

	@RequestMapping(method=POST)
	public String save(@ModelAttribute("noc")  NumberOfCores noc, SessionStatus status,Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
	
		numberOfCoresService.save(noc);
		status.setComplete();
		return "redirect:/admin/noc"+getParams(pageable, filter);
	}
}
