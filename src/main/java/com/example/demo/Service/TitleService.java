package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.TitleRepository;
import com.example.demo.entity.Title;

@Service
public class TitleService {
	
	@Autowired
	private TitleRepository titleRepository;
	
	@Transactional(readOnly = true)
	public Title findById(Long titleId) {
		return titleRepository.findById(titleId).orElseThrow(RuntimeException::new);
	}
	
	@Transactional(readOnly = true)
	public List<Title> findAll() {
		return titleRepository.findAll();
	}
	
	@Transactional
	public Title save(Title title) {
		return titleRepository.save(title);
	}
}
