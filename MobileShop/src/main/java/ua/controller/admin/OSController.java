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
import ua.entity.OS;
import ua.service.OSService;
import ua.validator.OSValidator;

@Controller
@RequestMapping("/admin/os")
@SessionAttributes(names = "os")
public class OSController {
	@Autowired
	private OSService osService;
	@InitBinder("os")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new OSValidator(osService));
	}
	@ModelAttribute("os")
	public OS getForm() {
		return new OS();
	}
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("page", osService.findAll(filter, pageable));
		return "admin-os";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		osService.delete(id);
		return "redirect:/admin/os"+getParams(pageable, filter);
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("os", osService.findOne(id));
		model.addAttribute("page", osService.findAll(filter, pageable));
		return "admin-os";
	}

	@RequestMapping(method=POST)
	public String save(@ModelAttribute("os") @Valid OS os,BindingResult br, SessionStatus status,Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			model.addAttribute("page", osService.findAll(filter, pageable));
			return "admin-os";
		}
		osService.save(os);
		status.setComplete();
		return "redirect:/admin/os"+getParams(pageable, filter);
	}
}
