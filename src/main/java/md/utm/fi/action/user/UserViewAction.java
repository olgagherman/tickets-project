package md.utm.fi.action.user;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import md.utm.fi.model.dao.ProjectDAO;
import md.utm.fi.model.dao.TicketDAO;
import md.utm.fi.model.dao.UserDAO;
import md.utm.fi.model.entity.Project;
import md.utm.fi.model.entity.Ticket;
import md.utm.fi.model.entity.User;

public class UserViewAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private TicketDAO ticketDAO;
	private ProjectDAO projectDAO;
	private User user;
	private Ticket ticket;
	private Project project;
	private Integer userId;
	private Integer projectId;
	private List<User> usersList;
	private List<Project> projects;
	private List<Ticket> userProjectTickets;

	public String getBodyUser() {
		user = userDAO.findUser(userId);
		userDAO.refresh(user);
		getUserProjects();
		if (user == null) {
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	public String getTicketsForTheUser() {
		setProject(projectDAO.findProject(projectId));

		userProjectTickets = ticketDAO.getTicketsForUser(userId, projectId);
		return Action.SUCCESS;
	}

	public TicketDAO getTicketDAO() {
		return ticketDAO;
	}

	public void setTicketDAO(TicketDAO ticketDAO) {
		this.ticketDAO = ticketDAO;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}

	public void getUserProjects() {
		projects = user.getProjects();

	}

	public List<Ticket> getUserProjectTickets() {
		return userProjectTickets;
	}

	public void setUserProjectTickets(List<Ticket> userProjectTickets) {

		this.userProjectTickets = userProjectTickets;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public ProjectDAO getProjectDAO() {
		return projectDAO;
	}

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
