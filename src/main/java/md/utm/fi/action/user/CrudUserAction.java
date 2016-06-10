package md.utm.fi.action.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import md.utm.fi.model.dao.UserDAO;
import md.utm.fi.model.entity.User;

public class CrudUserAction implements ModelDriven<User> {

	private User user = new User();

	private UserDAO userDAO;

	private List<User> userList;

	private Integer userId;

	private Integer projectId;
	private Integer userTickets;

	public Integer getUserTickets() {
		return userTickets;
	}

	public void setUserTickets(Integer userTickets) {
		this.userTickets = userTickets;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public User getModel() {
		return user;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String addUser() throws Exception {
		user.setCreatedDate(new Date());
		userDAO.save(user);
		if (user.getName() != null) {
			user = new User();
			return Action.SUCCESS;
		}
		return Action.ERROR;
	}

	public String updateUser() {
		userDAO.saveOrUpdate(user);
		return Action.SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String editUser() {
		String returnType = Action.NONE;
		if (userId != null) {
			ActionContext.getContext().getValueStack().getRoot().remove(user);
			user = getUserDAO().findUser(userId);
			ActionContext.getContext().getValueStack().getRoot().add(user);
			returnType = Action.SUCCESS;
		}
		return returnType;
	}

	public String removeUser() {
		if (userId != null) {
			User user = userDAO.findUser(userId);
			user.setProjects(null);
			user.setTickets(null);
			userDAO.saveOrUpdate(user);
			getUserDAO().deleteUser(userId);
		}
		return Action.SUCCESS;
	}

	// list all users

	public String listAllUsersNotBoundToProject() {
		userList = userDAO.getUsersNotWithTheProject(projectId);
		if (userList == null) {
			userList = new ArrayList<User>();
		}
		return Action.SUCCESS;
	}

	public String listAllUsers() {
		userList = userDAO.getAllUsers();
		if (userList == null) {
			userList = new ArrayList<User>();
		}
		return Action.SUCCESS;
	}

	public String listAllProjectUsers() {
		userList = userDAO.getUsersForProject(projectId);
		if (userList == null) {
			userList = new ArrayList<User>();
		}
		return Action.SUCCESS;
	}

	public String getBoardData() {
		userTickets = userDAO.getCountTickets();
		return Action.SUCCESS;
	}

}