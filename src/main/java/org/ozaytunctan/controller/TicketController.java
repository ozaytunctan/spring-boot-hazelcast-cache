package org.ozaytunctan.controller;

import org.ozaytunctan.model.Ticket;
import org.ozaytunctan.service.spec.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@PostMapping(path = "/addTicket")
	public ResponseEntity<Boolean> addTicket(@RequestBody Ticket ticket) {
		ticketService.addTicket(ticket);
		return ResponseEntity.ok(true);
	}

	@PostMapping(path = "/getTicketById/{ticketId}")
	public ResponseEntity<Ticket> getTicket(@PathVariable Integer ticketId) {
		return ResponseEntity.ok(ticketService.getTicket(ticketId));
	}
}
