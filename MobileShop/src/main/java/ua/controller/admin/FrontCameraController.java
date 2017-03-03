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
import ua.entity.FrontCamera;
import ua.service.FrontCameraService;
import ua.validator.CameraValidator;
import ua.validator.FrontCameraValidator;


@Controller
@RequestMapping("/admin/fc")
@SessionAttributes(names = "fc")
public class FrontCameraController {
	@Autowired
	private FrontCameraService frontCameraService;

	@ModelAttribute("fc")
	public FrontCamera getForm() {
		return new FrontCamera();
	}
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("page", frontCameraService.findAll(filter, pageable));
		return "admin-fc";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		frontCameraService.delete(id);
		return "redirect:/admin/fc"+getParams(pageable, filter);
		
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("fc", frontCameraService.findOne(id));
		model.addAttribute("page", frontCameraService.findAll(filter, pageable));
		return "admin-fc";
	}

	@RequestMapping(method=POST)
	public String save(@ModelAttribute("fc")  FrontCamera fc, SessionStatus status,Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		
		frontCameraService.save(fc);
		status.setComplete();
		return "redirect:/admin/fc"+getParams(pageable, filter);
	}
}
