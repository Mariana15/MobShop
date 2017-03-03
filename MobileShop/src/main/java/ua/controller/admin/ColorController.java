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
import ua.entity.Color;
import ua.service.ColorService;
import ua.validator.ColorValidator;

@Controller
@RequestMapping("/admin/color")
@SessionAttributes(names = "color")
public class ColorController {
	@Autowired
	private ColorService colorService;
	@InitBinder("color")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new ColorValidator(colorService));
	}
	@ModelAttribute("color")
	public Color getForm() {
		return new Color();
	}
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("page", colorService.findAll(filter, pageable));
		return "admin-color";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		colorService.delete(id);
		return "redirect:/admin/color"+getParams(pageable, filter);
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("color", colorService.findOne(id));
		model.addAttribute("page", colorService.findAll(filter, pageable));
		return "admin-color";
	}

	@RequestMapping(method=POST)
	public String save(@ModelAttribute("color") @Valid Color color,BindingResult br, SessionStatus status,Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			model.addAttribute("page", colorService.findAll(filter, pageable));
			return "admin-color";
		}
		colorService.save(color);
		status.setComplete();
		return "redirect:/admin/color"+getParams(pageable, filter);
	}
}
