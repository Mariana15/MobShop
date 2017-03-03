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
import ua.entity.OS;
import ua.entity.TypeSim;
import ua.service.TypeSimService;
import ua.validator.TypeSimValidator;

@Controller
@RequestMapping("/admin/ts")
@SessionAttributes(names = "ts")
public class TypeSimController {
	@Autowired
	private TypeSimService typeSimService;
	@InitBinder("ts")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new TypeSimValidator(typeSimService));
	}
	@ModelAttribute("ts")
	public TypeSim getForm() {
		return new TypeSim();
	}
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("page", typeSimService.findAll(filter, pageable));
		return "admin-ts";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		typeSimService.delete(id);
		return "redirect:/admin/ts"+getParams(pageable, filter);
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("ts", typeSimService.findOne(id));
		model.addAttribute("page", typeSimService.findAll(filter, pageable));
		return "admin-ts";
	}

	@RequestMapping(method=POST)
	public String save(@ModelAttribute("ts") @Valid TypeSim ts,BindingResult br, SessionStatus status,Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			model.addAttribute("page", typeSimService.findAll(filter, pageable));
			return "admin-ts";
		}
		typeSimService.save(ts);
		status.setComplete();
		return "redirect:/admin/ts"+getParams(pageable, filter);
	}
}
