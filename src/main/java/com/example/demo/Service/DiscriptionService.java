package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.DiscriptionRepository;
import com.example.demo.entity.Discription;

@Service
public class DiscriptionService {
	
	@Autowired
	private DiscriptionRepository discriptionRepository;
	
	@Transactional(readOnly = true)
	public Discription findById(Long discriptionId) {
		return discriptionRepository.findById(discriptionId).orElseThrow(RuntimeException::new);
	}
	
	@Transactional(readOnly = true)
	public List<Discription> findAll() {
		return discriptionRepository.findAll();
	}
	
	@Transactional
	public Discription save(Discription discription) {
		return discriptionRepository.save(discription);
	}
}
