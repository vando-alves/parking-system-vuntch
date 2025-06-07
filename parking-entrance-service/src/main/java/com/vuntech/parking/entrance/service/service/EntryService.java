package com.vuntech.parking.entrance.service.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
	        
	        BigDecimal amount = calculateAmount(duration);
	        entry.setAmountToPay(amount);

	        return repository.save(entry);
	    }

	    private BigDecimal calculateAmount(long durationInMinutes) {
	        if (durationInMinutes <= 30) {
	            return BigDecimal.valueOf(5.00);
	        } else if (durationInMinutes <= 60) {
	            return BigDecimal.valueOf(8.00);
	        } else if (durationInMinutes <= 120) {
	            return BigDecimal.valueOf(12.00);
	        } else {
	            long extraHours = (durationInMinutes - 120 + 59) / 60; // arredonda para cima
	            BigDecimal extra = BigDecimal.valueOf(extraHours).multiply(BigDecimal.valueOf(2.00));
	            return BigDecimal.valueOf(12.00).add(extra).setScale(2, RoundingMode.HALF_UP);
	        }
	    }
	    
}
