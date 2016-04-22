package md.utm.fi.action.ticket;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import md.utm.fi.model.dao.ProjectDAO;
import md.utm.fi.model.dao.TicketDAO;
import md.utm.fi.model.entity.Ticket;

public class TicketViewerAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private Ticket ticket = new Ticket();

	private TicketDAO ticketDAO;

	private ProjectDAO projectDAO;

	private List<Ticket> ticketList;

	private Integer ticketId;

	private String nameProject;

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public TicketDAO getTicketDAO() {
		return ticketDAO;
	}

	public void setTicketDAO(TicketDAO ticketDAO) {
		this.ticketDAO = ticketDAO;
	}

	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getNameProject() {
		return nameProject;
	}

	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}
	
	public String getBodyTicket() {
		ticket = ticketDAO.findTicket(ticketId);

		nameProject = ticket.getProject().getName();
		if (ticket == null) {
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
}
