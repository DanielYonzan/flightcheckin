<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title></head>
<body>

<h2>Flight Details:</h2>

Airlines: ${reservation.flight.operatinAirlines} <br/>
Flight No: ${reservation.flight.flightNumber} <br/>
Departure City: ${reservation.flight.departureCity}  <br/>
Arrival City: ${reservation.flight.arrivalCity}  <br/>
Date Of Departure:${reservation.flight.dateOfDeparture} <br/>
Estimate Departure Time:${reservation.flight.estimatedDepartureTime} <br/>

<h2>Passenger Details</h2>

First Name: ${reservation.passenger.firstName} <br/>
Middle Name: ${reservation.passenger.middleName} <br/>
Last Name: ${reservation.passenger.lastName} <br/>
Email: ${reservation.passenger.email} <br/>
Phone: ${reservation.passenger.phone} <br/>


<form action="completeCheckIn" method="post">

Enter the number of Bags you want to check in: <input type="text" name="numberOfBags"/>
 <br/>
<input type="hidden" value="${reservation.id}" name="reservationId"/>  <br/>
<input type="submit" value="Check In"/>
</form>

</body>
</html>