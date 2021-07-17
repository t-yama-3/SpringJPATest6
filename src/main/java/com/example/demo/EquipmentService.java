package com.example.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EquipmentService {
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional(readOnly = true)
	public Equipment getEquipment (Integer equipmentId) {
		Equipment equipment = entityManager.find(Equipment.class, equipmentId);
		return equipment;
	}
	
	@Transactional(readOnly = true)
	public List<Equipment> getAllEquipment () {
		String jpql = "SELECT e FROM Equipment e";
		List<Equipment> equipments = entityManager.createQuery(jpql, Equipment.class).getResultList();
		return equipments;
	}
	
	@Transactional
	public Equipment createEquipment (String equipmentName) {
		Equipment equipment = new Equipment();
		equipment.setEquipmentName(equipmentName);
		entityManager.persist(equipment);
		return equipment;
	}
}
