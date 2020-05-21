package com.daniel.flightcheckin.integration;

import com.daniel.flightcheckin.integration.dto.Reservation;
import com.daniel.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

	public Reservation findReservation(Long id);
	public Reservation updateReservation(ReservationUpdateRequest request);
}
