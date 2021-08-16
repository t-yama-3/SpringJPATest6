package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.NoteRepository;
import com.example.demo.entity.Note;

@Service
public class NoteService {
	
	@Autowired
	private NoteRepository noteRepository;
	
	@Transactional(readOnly = true)
	public Note findById(Long noteId) {
		return noteRepository.findById(noteId).orElseThrow(RuntimeException::new);
	}
	
	@Transactional(readOnly = true)
	public List<Note> findAll() {
		return noteRepository.findAll();
	}
	
	@Transactional
	public Note save(Note note) {
		return noteRepository.save(note);
	}
}
