package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.NotificationService;
import com.example.demo.entity.Notification;

@Controller
@RequestMapping("/notification")
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
	@GetMapping
	public String index(Model model) {
		List<Notification> notificationList = notificationService.findAll();
		model.addAttribute("notificationList", notificationList);
		return "notification/index";
	}
	
//	@GetMapping("/show/{notificationId}")
//	public String show(@PathVariable("notificationId") long notificationId, Model model) {
//		Notification notification = notificationService.findById(notificationId);
//		System.out.println(notification.getDiscriptions());
//		model.addAttribute("notification", notification);
//		return "notification/show";
//	}
	
	@GetMapping("form")
	public String form(Model model) {
		Notification notification = new Notification();
		model.addAttribute("notification", notification);
		return "notification/form";
	}
	
	@PostMapping("form")
	public String create(Notification notification) {
		notificationService.save(notification);
		return "redirect:/notification";
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable long id, Model model) {
		Notification notification = notificationService.findById(id);
		model.addAttribute("notification", notification);
		return "notification/edit";
	}
	
	@PostMapping("edit/{id}")
	public String update(@PathVariable long id, Notification notification) {
		notificationService.save(notification);
		return "redirect:/notification";
	}
}
