package com.vuntech.parking.entrance.service.service;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.vuntech.parking.entrance.service.model.VehicleEntry;
import com.vuntech.parking.entrance.service.repository.VehicleEntryRepository;

@Service
public class EntryService {
	
	 private final VehicleEntryRepository repository;

	    public EntryService(VehicleEntryRepository repository) {
	        this.repository = repository;
	    }

	    public VehicleEntry register(VehicleEntry entry) {
	        entry.setEntryTime(LocalDateTime.now());
	        return repository.save(entry);
	    }
	    
	    public VehicleEntry registerExit(Long id) {
	        VehicleEntry entry = repository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Vehicle entry not found"));

	        LocalDateTime exitTime = LocalDateTime.now();
	        entry.setExitTime(exitTime);

	        long duration = Duration.between(entry.getEntryTime(), exitTime).toMinutes();
	        entry.setDurationInMinutes(duration);

	        return repository.save(entry);
	    }

}
