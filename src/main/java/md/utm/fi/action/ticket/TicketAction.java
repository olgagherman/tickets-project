package md.utm.fi.action.ticket;

import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import md.utm.fi.model.dao.ProjectDAO;
import md.utm.fi.model.dao.TicketDAO;
import md.utm.fi.model.entity.Project;
import md.utm.fi.model.entity.Ticket;

public class TicketAction implements ModelDriven<Ticket> {

	public enum Complexity {
		Easy, Medium, Hard
	}

	private EnumSet<Complexity> listComplexity;

	public EnumSet<Complexity> getListComplexity() {
		return listComplexity;
	}

	private Ticket ticket = new Ticket();

	private TicketDAO ticketDAO;

	private ProjectDAO projectDAO;

	private List<Ticket> ticketList;

	private Integer ticketId;

	private String nameProject;
	private String ticketComplexity;

	List<String> nameProjects;

	private String nameUser;
	private List<String> nameUsers;

	public List<String> getNameProjects() {
		return nameProjects;
	}

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
		ticket.setComplexity(ticketComplexity);
		ticketDAO.save(ticket);

		Project proj = projectDAO.findProject(nameProject);
		projectDAO.refresh(proj);

		// List<Ticket> tickets = proj.getTickets();
		// tickets.add(ticket);
		// proj.setTickets(tickets);
		// projectDAO.saveOrUpdate(proj);

		ticket.setProject(proj);
		ticketDAO.saveOrUpdate(ticket);

		Ticket ticket2 = ticketDAO.findTicket(ticket.getId());

		if (ticket.getName() != null) {
			ticket = new Ticket();
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
			populateDropDown();
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
		ticket = new Ticket();
		if (ticketList == null) {
			ticketList = new ArrayList<Ticket>();
		}
		return Action.SUCCESS;
	}

	public String getNameProject() {
		return nameProject;
	}

	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}

	public ProjectDAO getProjectDAO() {
		return projectDAO;
	}

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	public String populateDropDown() {
		listComplexity = EnumSet.allOf(Complexity.class);
		nameProjects = projectDAO.getAllProjectName();
		// nameUsers = projectDAO.getAllUserProjectName();
		return Action.SUCCESS;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public List<String> getNameUsers() {
		return nameUsers;
	}

	public void setNameUsers(List<String> nameUsers) {
		this.nameUsers = nameUsers;
	}

	public String getTicketComplexity() {
		return ticketComplexity;
	}

	public void setTicketComplexity(String ticketComplexity) {
		this.ticketComplexity = ticketComplexity;
	}

}
