package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {
	
	@Autowired
	EquipmentService equipmentService;
	
	@GetMapping
	public String index (Model model) {
		List<Equipment> equipmentList = equipmentService.getAllEquipment();
		model.addAttribute("equipmentList", equipmentList);
		return "equipment/index";
	}
	
	@GetMapping("form")
	public String form (EquipmentForm equipmentForm) {
		return "equipment/form";
	}
	
	@PostMapping("form")
	public String create (@Validated EquipmentForm equipmentForm, BindingResult result) {
		if (result.hasErrors()) {
			return "equipment/form";
		}
		equipmentService.createEquipment(equipmentForm.getEquipmentName());
		return "redirect:/equipment";
	}
	
	@GetMapping("edit/{id}")
	public String edit (EquipmentForm equipmentForm, @PathVariable Integer id) {
		Equipment equipment  = equipmentService.getEquipment(id);
		equipmentForm.setEquipmentId(id);
		equipmentForm.setEquipmentName(equipment.getEquipmentName());
		equipmentForm.setRoom(equipment.getRoom());
		return "equipment/edit";
	}
}
