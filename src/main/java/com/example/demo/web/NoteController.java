package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.TitleService;
import com.example.demo.Service.NoteService;
import com.example.demo.entity.Title;
import com.example.demo.entity.Note;

@Controller
@RequestMapping("note")
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	
	@Autowired
	private TitleService titleService;

	@GetMapping("index/{titleId}")
	public String index(@PathVariable("titleId") long titleId, Model model) {
		Title title = titleService.findById(titleId);
		model.addAttribute("title", title);
		return "note/index";
	}
	
	@GetMapping("/{titleId}/form")
	public String form(Model model, @PathVariable("titleId") Long titleId) {
		Note note = new Note();
		note.setTitle(titleService.findById(titleId));
		model.addAttribute("note", note);
		return "note/form";
	}
	
	@PostMapping("/{titleId}/form")
	public String create(@PathVariable("titleId") Long titleId, Note note) {
		note.setTitle(titleService.findById(titleId));
		noteService.save(note);
		return "redirect:/title/index/" + note.getTitle().getDiscription().getId();
	}
	
	@GetMapping("/{titleId}/edit/{noteId}")
	public String edit(@PathVariable("titleId") long titleId, @PathVariable("noteId") long noteId, Model model) {
		Note note = noteService.findById(noteId);
		model.addAttribute("note", note);
		return "note/edit";
	}
	
	@PostMapping("/{titleId}/edit/{noteId}")
	public String update(@PathVariable("titleId") long titleId, @PathVariable("noteId") long noteId, Note note) {
		note.setId(noteId);
		note.setTitle(titleService.findById(titleId));
		noteService.save(note);
		return "redirect:/title/index/" + note.getTitle().getDiscription().getId();
	}	
}
