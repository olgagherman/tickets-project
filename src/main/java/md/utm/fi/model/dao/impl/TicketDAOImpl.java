package md.utm.fi.model.dao.impl;

import java.awt.print.Book;
import java.util.List;

import md.utm.fi.exception.ObjectsNotFoundException;
import md.utm.fi.model.dao.TicketDAO;
import md.utm.fi.model.entity.Ticket;

@SuppressWarnings("unchecked")
public class TicketDAOImpl extends GenericDaoImpl implements TicketDAO {
	public List<Book> retrieveAllUploadedTicketBooks(Ticket ticket) {
		return getHibernateTemplate().find("from Book b where b.uploader.id=?", ticket.getId());
	}

	public Ticket findTicket(String login, String password) {
		List<Ticket> find = getHibernateTemplate().find("from Ticket where email=? and password=?", login, password);
		if (find.isEmpty()) {
			throw new ObjectsNotFoundException(Ticket.class, login, password);
		}
		return find.iterator().next();
	}

	public List<Ticket> getAllTickets() {
		return getHibernateTemplate().find("from Ticket order by id desc");
	}

	public Ticket findTicket(Integer id) {
		return get(Ticket.class, id);
	}

	public void deleteTicket(Integer id) {
		delete(findTicket(id));
	}
}
