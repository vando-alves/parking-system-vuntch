package com.vuntech.parking_slot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vuntech.parking_slot.Model.ParkingSlotControl;
import com.vuntech.parking_slot.Service.ParkingSlotControlService;

@RestController
@RequestMapping("/slots")
public class ParkingSlotControlController {

	   @Autowired
	    private ParkingSlotControlService service;

	    @GetMapping("/{id}")
	    public ResponseEntity<ParkingSlotControl> getStatus(@PathVariable Long id) {
	        return ResponseEntity.ok(service.getStatus(id));
	    }

	    @PostMapping("/{id}/enter")
	    public ResponseEntity<ParkingSlotControl> occupySlot(@PathVariable Long id) {
	        return ResponseEntity.ok(service.increaseOccupied(id));
	    }

	    @PostMapping("/{id}/exit")
	    public ResponseEntity<ParkingSlotControl> freeSlot(@PathVariable Long id) {
	        return ResponseEntity.ok(service.decreaseOccupied(id));
	    }
}
