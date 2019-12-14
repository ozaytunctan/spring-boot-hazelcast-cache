package org.ozaytunctan.service;

import java.util.Map;

import org.ozaytunctan.components.CacheService;
import org.ozaytunctan.exceptions.HazelcastException;
import org.ozaytunctan.model.Ticket;
import org.ozaytunctan.service.spec.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private CacheService cacheService;

	@Override
	public Ticket addTicket(Ticket ticket) {

		// 1 dk sonra expire olsun
		Long expire = 1 * 60 * 1000L;
		cacheService.put("nowSale", ticket, expire);

		cacheService.put("ticket", ticket);
		cacheService.put("ticket", "ticket_active", ticket);
		cacheService.put("ticket", "ticket_active2", ticket);

		return null;
	}

	@Override
	public Ticket getTicket(Integer ticketId) {
		Object nowSale;
		try {
			nowSale = cacheService.get("nowSale");
		} catch (HazelcastException e) {
			return null;
		}
		return (Ticket) nowSale;
	}

}
