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
@RequestMapping("")
public class RoomController {
	@Autowired
	RoomService roomService;
	
	@GetMapping("")
	public String index (Model model) {
		List<Room> roomList = roomService.getAllRoom();
		model.addAttribute("roomList", roomList);
		return "index";
	}
	
	@GetMapping("/form")
	public String form (RoomForm roomForm) {
		return "form";
	}
	
	@PostMapping("/form")
	public String create (@Validated RoomForm roomForm, BindingResult result) {
		if (result.hasErrors()) {
			return "form";
		}
		roomService.createRoom(roomForm.getRoomName(), roomForm.getCapacity(), null);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit (@PathVariable Integer id, RoomForm roomForm) {
		Room room = roomService.getRoom(id);
		roomForm.setRoomId(id);
		roomForm.setRoomName(room.getRoomName());
		roomForm.setCapacity(room.getCapacity());
		roomForm.setEquipments(room.getEquipments());
		return "edit";
	}
	
	@PostMapping("/edit/{id}")
	public String update (@PathVariable Integer id, @Validated RoomForm roomForm, BindingResult result) {
		if (result.hasErrors()) {
			return "edit";
		}
		System.out.println(roomForm.getRoomId());
		roomService.updateRoom(id, roomForm.getRoomName(), roomForm.getCapacity(), roomForm.getEquipments());
		return "redirect:/";
	}
}
