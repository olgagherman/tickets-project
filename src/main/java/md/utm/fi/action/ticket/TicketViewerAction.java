package md.utm.fi.action.ticket;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import md.utm.fi.model.dao.ProjectDAO;
import md.utm.fi.model.dao.TicketDAO;
import md.utm.fi.model.entity.Ticket;
import md.utm.fi.model.entity.User;

public class TicketViewerAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private Ticket ticket = new Ticket();

	private TicketDAO ticketDAO;

	private ProjectDAO projectDAO;

	private List<Ticket> ticketList;

	private Integer ticketId;
	private Integer projectId;
	private List<User> usersList;

	public List<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}

	private String nameProject;
	private String nameUser;

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
		projectId = ticket.getProject().getId();
		nameProject = ticket.getProject().getName();
		if (ticket.getState().equals("Assigned")) {
			setNameUser(ticket.getUser().getName() + " " + ticket.getUser().getSurname());
		} else {
			setNameUser("NonAssigned");
		}

		if (ticket == null) {
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	public ProjectDAO getProjectDAO() {
		return projectDAO;
	}

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	public String listAllProjectUsers() {
		ticket = ticketDAO.findTicket(ticketId);
		projectId = ticket.getProject().getId();
		usersList = projectDAO.retrieveAllProjectUser(projectDAO.findProject(projectId));
		if (usersList == null) {
			usersList = new ArrayList<User>();
		}
		return Action.SUCCESS;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

}
