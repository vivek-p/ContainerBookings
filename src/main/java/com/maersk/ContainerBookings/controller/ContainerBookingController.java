package com.maersk.ContainerBookings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maersk.ContainerBookings.model.AvailablilityModel;
import com.maersk.ContainerBookings.model.BookingsModel;
import com.maersk.ContainerBookings.service.BookingsService;

@RestController
@RequestMapping("/containers")
public class ContainerBookingController {
	@Autowired
	private BookingsService bookingsService;
	
	@RequestMapping(value = "/checkAvailable", method = RequestMethod.POST, headers={"content-type=application/json"})
	public ResponseEntity<AvailablilityModel> checkAvailableSlots(@RequestParam BookingsModel inputData) {
		AvailablilityModel response = null;
		try {
			response = bookingsService.checkAvailability(inputData);
			return new ResponseEntity<AvailablilityModel>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<AvailablilityModel>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/generateContainerOrder", method = RequestMethod.POST, headers={"content-type=application/json"})
	public ResponseEntity<AvailablilityModel> saveContainerOrder(@RequestParam BookingsModel inputData) {
		AvailablilityModel response = null;
		try {
			response = bookingsService.saveContainerInfo(inputData);
			return new ResponseEntity<AvailablilityModel>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<AvailablilityModel>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
