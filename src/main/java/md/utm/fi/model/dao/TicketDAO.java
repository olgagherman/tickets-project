package md.utm.fi.model.dao;

import java.util.List;

import md.utm.fi.model.entity.Ticket;

public interface TicketDAO extends GenericDao {

	List<Ticket> getAllTickets();

	Ticket findTicket(Integer id);

	void deleteTicket(Integer id);

	List<Ticket> getTicketsForUser(Integer userId, Integer projectId);
}
