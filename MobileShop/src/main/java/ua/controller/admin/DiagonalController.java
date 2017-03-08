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
import ua.entity.Diagonal;
import ua.service.DiagonalService;

@Controller
@RequestMapping("/admin/diagonal")
@SessionAttributes(names = "diagonal")
public class DiagonalController {
	@Autowired
	private DiagonalService diagonalService;

	@ModelAttribute("diagonal")
	public Diagonal getForm() {
		return new Diagonal();
	}

	@ModelAttribute("filter")
	public BasicFilter getFilter() {
		return new BasicFilter();
	}

	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("page", diagonalService.findAll(filter, pageable));
		return "admin-diagonal";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		diagonalService.delete(id);
		return "redirect:/admin/diagonal" + getParams(pageable, filter);
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("diagonal", diagonalService.findOne(id));
		model.addAttribute("page", diagonalService.findAll(filter, pageable));
		return "admin-diagonal";
	}

	@RequestMapping(method = POST)
	public String save(@ModelAttribute("diagonal") Diagonal diagonal, SessionStatus status, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {

		diagonalService.save(diagonal);
		status.setComplete();
		return "redirect:/admin/diagonal" + getParams(pageable, filter);
	}
}
