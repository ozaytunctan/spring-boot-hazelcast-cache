package org.ozaytunctan.service.spec;

import org.ozaytunctan.model.Ticket;

public interface TicketService {
	
	public Ticket addTicket(Ticket ticket);
	
	public Ticket getTicket(Integer ticketId);
		
	

}
