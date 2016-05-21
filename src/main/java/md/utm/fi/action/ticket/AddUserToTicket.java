package md.utm.fi.action.ticket;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import md.utm.fi.model.dao.TicketDAO;
import md.utm.fi.model.dao.UserDAO;
import md.utm.fi.model.entity.User;

public class AddUserToTicket extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private TicketDAO ticketDAO;
	private Integer ticketId;
	private Integer userId;

	public String addUsersToTheTicket() {
		/*
		 * Ticket ticket = ticketDAO.findTicket(ticketId);
		 * userDAO.addUsersToTheTicket(userId, ticket);
		 */
		User user = userDAO.findUser(userId);
		ticketDAO.addUsersToTheTicket(user, ticketId);

		return Action.SUCCESS;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public TicketDAO getTicketDAO() {
		return ticketDAO;
	}

	public void setTicketDAO(TicketDAO ticketDAO) {
		this.ticketDAO = ticketDAO;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

}
