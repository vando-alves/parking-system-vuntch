package com.vuntech.parking_slot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuntech.parking_slot.Model.ParkingSlotControl;
import com.vuntech.parking_slot.Repository.ParkingSlotControlRepository;

@Service
public class ParkingSlotControlService {

	  @Autowired
	    private ParkingSlotControlRepository repository;

	    public ParkingSlotControl getStatus(Long id) {
	        return repository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Controle de vagas não encontrado"));
	    }

	    public ParkingSlotControl increaseOccupied(Long id) {
	        ParkingSlotControl control = getStatus(id);
	        if (control.getOccupiedSlots() < control.getTotalSlots()) {
	            control.setOccupiedSlots(control.getOccupiedSlots() + 1);
	        }
	        return repository.save(control);
	    }

	    public ParkingSlotControl decreaseOccupied(Long id) {
	        ParkingSlotControl control = getStatus(id);
	        if (control.getOccupiedSlots() > 0) {
	            control.setOccupiedSlots(control.getOccupiedSlots() - 1);
	        }
	        return repository.save(control);
	    }
}
