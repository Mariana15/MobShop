package ua.controller.admin;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.dto.filter.BasicFilter;
import ua.entity.Description;
import ua.service.DescriptionService;
import ua.validator.DescriptionValidator;

@Controller
@RequestMapping("/admin/description")
@SessionAttributes(names = "description")
public class DescriptionController {

	@Autowired
	private DescriptionService descriptionService;

	@ModelAttribute("description")
	public Description getForm() {
		return new Description();
	}

	@ModelAttribute("filter")
	public BasicFilter getFilter() {
		return new BasicFilter();
	}

	@InitBinder("description")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new DescriptionValidator(descriptionService));
	}

	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("page", descriptionService.findAll(pageable, filter));

		return "admin-description";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		descriptionService.delete(id);
		return "redirect:/admin/description" + getParams(pageable, filter);
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("description", descriptionService.findOne(id));
		show(model, pageable, filter);
		return "admin-description";
	}

	@PostMapping
	public String save(@ModelAttribute("description") @Valid Description description, BindingResult br, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter, SessionStatus status) {
		if (br.hasErrors()) {
			show(model, pageable, filter);
			return "admin-description";
		}
		descriptionService.save(description);
		status.setComplete();
		return "redirect:/admin/description" + getParams(pageable, filter);
	}
}
