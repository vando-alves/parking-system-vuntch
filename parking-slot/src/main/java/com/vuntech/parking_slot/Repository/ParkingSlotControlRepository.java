package com.vuntech.parking_slot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vuntech.parking_slot.Model.ParkingSlotControl;

public interface ParkingSlotControlRepository extends JpaRepository<ParkingSlotControl, Long> {

}
