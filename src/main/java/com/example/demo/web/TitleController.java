package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.DiscriptionService;
import com.example.demo.Service.TitleService;
import com.example.demo.entity.Discription;
import com.example.demo.entity.Title;

@Controller
@RequestMapping("title")
public class TitleController {
	
	@Autowired
	private TitleService titleService;
	
	@Autowired
	private DiscriptionService discriptionService;

	@GetMapping("index/{discriptionId}")
	public String index(@PathVariable("discriptionId") long discriptionId, Model model) {
		Discription discription = discriptionService.findById(discriptionId);
		model.addAttribute("discription", discription);
		return "title/index";
	}
	
	@GetMapping("/{discriptionId}/form")
	public String form(Model model, @PathVariable("discriptionId") Long discriptionId) {
		Title title = new Title();
		title.setDiscription(discriptionService.findById(discriptionId));
		model.addAttribute("title", title);
		return "title/form";
	}
	
	@PostMapping("/{discriptionId}/form")
	public String create(@PathVariable("discriptionId") Long discriptionId, Title title) {
		title.setDiscription(discriptionService.findById(discriptionId));
		titleService.save(title);
		return "redirect:/title/index/" + discriptionId;
	}
	
	@GetMapping("/{discriptionId}/edit/{titleId}")
	public String edit(@PathVariable("discriptionId") long discriptionId, @PathVariable("titleId") long titleId, Model model) {
		Title title = titleService.findById(titleId);
		model.addAttribute("title", title);
		return "title/edit";
	}
	
	@PostMapping("/{discriptionId}/edit/{titleId}")
	public String update(@PathVariable("discriptionId") long discriptionId, @PathVariable("titleId") long titleId, Title title) {
		title.setId(titleId);
		title.setDiscription(discriptionService.findById(discriptionId));
		titleService.save(title);
		return "redirect:/title/index/" + discriptionId;
	}	
}
