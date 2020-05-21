package com.daniel.flightcheckin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daniel.flightcheckin.integration.ReservationRestClient;
import com.daniel.flightcheckin.integration.dto.Reservation;
import com.daniel.flightcheckin.integration.dto.ReservationUpdateRequest;

@Controller
public class CheckInController {
	
	@Autowired
	ReservationRestClient restClient;

	@RequestMapping("/showStartCheckin")
	public String showStartCheckin() {
		return "startCheckIn";
	}
	
	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("reservationId")Long reservationId, ModelMap modelMap) {
		Reservation reservation = restClient.findReservation(reservationId);
		modelMap.addAttribute("reservation", reservation);
		return "displayReservationDetails";
	}
	
	@RequestMapping("/completeCheckIn")
	public String completeCheckIn(@RequestParam("reservationId")Long reservationId, @RequestParam("numberOfBags") int numberOfBags) {
		ReservationUpdateRequest updateReservation = new ReservationUpdateRequest();
		updateReservation.setId(reservationId);
		updateReservation.setCheckedIn(true);
		updateReservation.setNumberOfBags(numberOfBags);
		restClient.updateReservation(updateReservation);
		return "checkInConfirmation";
	}
}
