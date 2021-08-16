package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.NotificationRepository;
import com.example.demo.entity.Notification;

@Service
public class NotificationService {
	
	@Autowired
	private NotificationRepository notificationRepository;
	
	@Transactional(readOnly = true)
	public Notification findById(Long notificationId) {
		return notificationRepository.findById(notificationId).orElseThrow(RuntimeException::new);
	}
	
	@Transactional(readOnly = true)
	public List<Notification> findAll() {
		return notificationRepository.findAll();
	}
	
	@Transactional
	public Notification save(Notification notification) {
		return notificationRepository.save(notification);
	}
}
