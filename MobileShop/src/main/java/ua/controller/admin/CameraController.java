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
import ua.entity.Camera;
import ua.service.CameraService;

@Controller
@RequestMapping("/admin/camera")
@SessionAttributes(names = "camera")
public class CameraController {
	@Autowired
	private CameraService cameraService;

	@ModelAttribute("camera")
	public Camera getForm() {
		return new Camera();
	}

	@ModelAttribute("filter")
	public BasicFilter getFilter() {
		return new BasicFilter();
	}

	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("page", cameraService.findAll(filter, pageable));
		return "admin-camera";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		cameraService.delete(id);
		return "redirect:/admin/camera" + getParams(pageable, filter);
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {
		model.addAttribute("camera", cameraService.findOne(id));
		model.addAttribute("page", cameraService.findAll(filter, pageable));
		return "admin-camera";
	}

	@RequestMapping(method = POST)
	public String save(@ModelAttribute("camera") Camera camera, SessionStatus status, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter) {

		cameraService.save(camera);
		status.setComplete();
		return "redirect:/admin/camera" + getParams(pageable, filter);
	}
}
