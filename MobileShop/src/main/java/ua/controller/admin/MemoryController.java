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
import ua.entity.Memory;
import ua.service.MemoryService;
import ua.validator.FrontCameraValidator;
import ua.validator.MemoryValidator;
@Controller
@RequestMapping("/admin/memory")
@SessionAttributes(names = "memory")
public class MemoryController {
	@Autowired
	private MemoryService memoryService;
	
	@ModelAttribute("memory")
	public Memory getForm() {
		return new Memory();
	}
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("page", memoryService.findAll(filter, pageable));
		return "admin-memory";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		memoryService.delete(id);
		return "redirect:/admin/memory"+getParams(pageable, filter);
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("memory", memoryService.findOne(id));
		model.addAttribute("page", memoryService.findAll(filter, pageable));
		return "admin-memory";
	}

	@RequestMapping(method=POST)
	public String save(@ModelAttribute("memory") Memory memory, SessionStatus status,Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		
		memoryService.save(memory);
		status.setComplete();
		return "redirect:/admin/memory"+getParams(pageable, filter);
	}
}
