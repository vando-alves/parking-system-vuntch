package com.vuntech.parking.entrance.service.model;

import java.time.LocalDateTime;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class VehicleEntry {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String Plate;

	    private LocalDateTime entryTime;

	    private LocalDateTime exitTime;

	    private Long durationInMinutes;
	    // Getters and Setters
}
