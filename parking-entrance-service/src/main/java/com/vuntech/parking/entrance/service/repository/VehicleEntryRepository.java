package com.vuntech.parking.entrance.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vuntech.parking.entrance.service.model.VehicleEntry;

public  interface VehicleEntryRepository extends JpaRepository<VehicleEntry, Long>{

}
