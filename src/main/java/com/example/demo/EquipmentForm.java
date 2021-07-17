package com.example.demo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EquipmentForm {
	
	private Integer equipmentId;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String equipmentName;
	
	private Room room;

	public Integer getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(Integer equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
}
