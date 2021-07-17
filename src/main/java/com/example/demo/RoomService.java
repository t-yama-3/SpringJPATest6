package com.example.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoomService {
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional(readOnly = true)
	public Room getRoom (Integer roomId) {
		Room room = entityManager.find(Room.class, roomId);
		return room;
	}
	
	@Transactional
	public List<Room> getAllRoom () {
		String jpql = "SELECT r FROM Room r";
		return entityManager.createQuery(jpql, Room.class).getResultList();
	}
	
	@Transactional
	public Room createRoom (String roomName, Integer capacity, List<Equipment> equipments) {
		Room room = new Room();
		room.setRoomName(roomName);
		room.setCapacity(capacity);
		room.setEquipments(equipments);
		entityManager.persist(room);
		return room;
	}
	
	@Transactional
	public Room updateRoom (Integer roomId, String roomName, Integer capacity, List<Equipment> equipments) {
		Room room = getRoom(roomId);
		room.setRoomName(roomName);
		room.setCapacity(capacity);
		room.setEquipments(equipments);
		return room;
	}
}
