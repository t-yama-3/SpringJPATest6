package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.DiscriptionService;
import com.example.demo.Service.NotificationService;
import com.example.demo.entity.Discription;
import com.example.demo.entity.Notification;

@Controller
@RequestMapping("/discription")
public class DiscriptionController {
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private DiscriptionService discriptionService;
	
	@GetMapping("index/{notificationId}")
	public String index(@PathVariable("notificationId") long notificationId, Model model) {
		Notification notification = notificationService.findById(notificationId);
		model.addAttribute("notification", notification);
		return "discription/index";
	}
	
	@GetMapping("/{notificationId}/form")
	public String form(Model model, @PathVariable("notificationId") Long nortificationId) {
		Discription discription = new Discription();
		discription.setNotification(notificationService.findById(nortificationId));
		model.addAttribute("discription", discription);
		return "discription/form";
	}
	
	@PostMapping("/{notificationId}/form")
	public String create(@PathVariable("notificationId") Long notificationId, Discription discription) {
		discription.setNotification(notificationService.findById(notificationId));
		discriptionService.save(discription);
		return "redirect:/discription/index/" + notificationId;
	}
	
	@GetMapping("/{notificationId}/edit/{discriptionId}")
	public String edit(@PathVariable("notificationId") long notificationId, @PathVariable("discriptionId") long discriptionId, Model model) {
		Discription discription = discriptionService.findById(discriptionId);
		model.addAttribute("discription", discription);
		return "discription/edit";
	}
	
	@PostMapping("/{notificationId}/edit/{discriptionId}")
	public String update(@PathVariable("notificationId") long notificationId, @PathVariable("discriptionId") long discriptionId, Discription discription) {
		discription.setId(discriptionId);
		discription.setNotification(notificationService.findById(notificationId));
		discriptionService.save(discription);
		return "redirect:/discription/index/" + notificationId;
	}
}
