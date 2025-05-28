package com.vuntech.parking.entrance.service.service;

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

}
