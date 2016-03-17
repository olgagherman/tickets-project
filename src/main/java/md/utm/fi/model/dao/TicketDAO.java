package md.utm.fi.model.dao;

import java.util.List;

import md.utm.fi.model.entity.Ticket;

public interface TicketDAO extends GenericDao {
	Ticket findTicket(String login, String password);

	List<Ticket> getAllTickets();

	Ticket findTicket(Integer id);

	void deleteTicket(Integer id);

}
