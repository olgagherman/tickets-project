package md.utm.fi.action.user;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import md.utm.fi.model.dao.UserDAO;
import md.utm.fi.model.entity.Project;
import md.utm.fi.model.entity.User;

public class UserViewAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private User user;

	private Integer userId;
	private List<User> usersList;
	private List<Project> projects;

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

	public String getBodyUser() {
		user = userDAO.findUser(userId);
		userDAO.refresh(user);
		getUserProjects();
		if (user == null) {
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	public void getUserProjects() {
		projects = user.getProjects();

	}

}
