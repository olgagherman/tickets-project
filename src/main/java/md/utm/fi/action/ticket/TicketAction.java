package md.utm.fi.action.ticket;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import md.utm.fi.model.dao.TicketDAO;
import md.utm.fi.model.entity.Ticket;

public class TicketAction implements ModelDriven<Ticket> {

	private Ticket ticket = new Ticket();

	private TicketDAO ticketDAO;

	private List<Ticket> ticketList;

	private Integer ticketId;

	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	public Ticket getModel() {
		return ticket;
	}

	public void setTicketDAO(TicketDAO ticketDAO) {
		this.ticketDAO = ticketDAO;
	}

	public TicketDAO getTicketDAO() {
		return ticketDAO;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String addTicket() throws Exception {
		ticket.setCreatedDate(new Date());
		ticketDAO.save(ticket);
		if (ticket.getName() != null) {
			return Action.SUCCESS;
		}
		return Action.ERROR;
	}

	public String updateTicket() {
		ticketDAO.saveOrUpdate(ticket);
		return Action.SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String editTicket() {
		String returnType = Action.NONE;
		if (ticketId != null) {
			ActionContext.getContext().getValueStack().getRoot().remove(ticket);
			ticket = getTicketDAO().findTicket(ticketId);
			ActionContext.getContext().getValueStack().getRoot().add(ticket);
			returnType = Action.SUCCESS;
		}
		return returnType;
	}

	public String removeTicket() {
		if (ticketId != null) {
			getTicketDAO().deleteTicket(ticketId);
		}
		return Action.SUCCESS;
	}

	// list all Tickets
	public String listAllTickets() {
		ticketList = ticketDAO.getAllTickets();
		if (ticketList == null) {
			ticketList = new ArrayList<Ticket>();
		}
		return Action.SUCCESS;
	}
}
