package ua.controller.admin;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static ua.service.utils.ParamBuilder.getParams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.dto.filter.BasicFilter;
import ua.entity.NumberOfSimCards;
import ua.service.NumberOfSimCardsService;

@Controller
@RequestMapping("/admin/nosc")
@SessionAttributes(names = "nosc")
public class NumberOfSimCardsController {
	@Autowired
	private NumberOfSimCardsService numberOfSimCardsService;

	@ModelAttribute("nosc")
	public NumberOfSimCards getForm() {
		return new NumberOfSimCards();
	}

	@ModelAttribute("filter")
	public BasicFilter getFilter() {
		return new BasicFilter();
	}

	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("page", numberOfSimCardsService.findAll(filter, pageable));
		return "admin-nosc";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		numberOfSimCardsService.delete(id);
		return "redirect:/admin/nosc" + getParams(pageable, filter);
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("nosc", numberOfSimCardsService.findOne(id));
		model.addAttribute("page", numberOfSimCardsService.findAll(filter, pageable));
		return "admin-nosc";
	}

	@RequestMapping(method = POST)
	public String save(@ModelAttribute("nosc") NumberOfSimCards nosc, SessionStatus status, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {

		numberOfSimCardsService.save(nosc);
		status.setComplete();
		return "redirect:/admin/nosc" + getParams(pageable, filter);
	}
}
