package com.vuntech.parking.entrance.service.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vuntech.parking.entrance.service.model.VehicleEntry;
import com.vuntech.parking.entrance.service.service.EntryService;

@RestController
@RequestMapping("/entries")
public class EntryController {

	   private final EntryService service;

	    public EntryController(EntryService service) {
	        this.service = service;
	    }

	    @PostMapping
	    public ResponseEntity<VehicleEntry> registerEntry(@RequestBody VehicleEntry entry) {
	        return ResponseEntity.ok(service.register(entry));
	    }
}
