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

		// 1 dk  sonra expire olsun
		Long expire = 1 * 60 * 1000L;
		cacheService.put("nowSale", ticket, expire);
		
		
		cacheService.put("ticket", ticket);
		cacheService.put("ticket", "ticket_active", ticket);
		return null;
	}

	@Override
	public Ticket getTicket(Integer ticketId) {
		Object nowSale;
		try {
			// superKey = cacheService.get("ticket");
			//
			// ticket_active = ((Map) superKey).get("ticket_active");
			nowSale = ((Map) cacheService.get("nowSale")).get("nowSale");
		} catch (HazelcastException e) {
			return null;
		}
		return (Ticket) nowSale;
	}

}
