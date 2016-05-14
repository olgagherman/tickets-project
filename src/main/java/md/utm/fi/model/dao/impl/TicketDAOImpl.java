package md.utm.fi.model.dao.impl;

import java.awt.print.Book;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import md.utm.fi.model.dao.TicketDAO;
import md.utm.fi.model.entity.Ticket;

@SuppressWarnings("unchecked")
public class TicketDAOImpl extends GenericDaoImpl implements TicketDAO {

	public List<Book> retrieveAllUploadedTicketBooks(Ticket ticket) {
		return getHibernateTemplate().find("from Book b where b.uploader.id=?", ticket.getId());
	}

	public List<Ticket> getAllTickets() {
		return getHibernateTemplate().find("from Ticket order by id desc");
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
	public Ticket findTicket(Integer id) {
		Ticket ticket = get(Ticket.class, id);
		ticket.getProject();
		refresh(ticket);
		return ticket;
	}

	public void deleteTicket(Integer id) {
		delete(findTicket(id));
	}

	public List<Ticket> getTicketsForUser(Integer userId, Integer projectId) {
		// return getHibernateTemplate().find(
		// "select t from Ticket t inner join t.project p inner join p.users u
		// where u.id=? and p.id=?", userId,
		// projectId);
		return getHibernateTemplate().find(
				"select t from Ticket t inner join t.user u inner join u.projects p where u.id=? and p.id=?", userId,
				projectId);
	}

}
