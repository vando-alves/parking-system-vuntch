package com.vuntech.parking_slot.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ParkingSlotControl {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private Integer totalSlots;

	    private Integer occupiedSlots;

	    public Integer getAvailableSlots() {
	        return totalSlots - occupiedSlots;
	    }

	    // Getters e Setters

}
