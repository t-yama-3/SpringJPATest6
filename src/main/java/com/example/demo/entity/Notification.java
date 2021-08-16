package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String subject;
	
	@OneToMany(mappedBy = "notification", cascade = CascadeType.ALL)
	private List<Discription> discriptions;
	
	public Notification() {}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public List<Discription> getDiscriptions() {
		return discriptions;
	}
	public void setDiscriptions(List<Discription> discriptions) {
		this.discriptions = discriptions;
	}
}
