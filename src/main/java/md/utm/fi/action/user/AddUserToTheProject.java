package md.utm.fi.action.user;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import md.utm.fi.model.dao.ProjectDAO;
import md.utm.fi.model.dao.UserDAO;

public class AddUserToTheProject extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private ProjectDAO projectDAO;
	private Integer projectId;

	private Integer[] selectedUsers;

	public void setSelectedUsers(Integer[] selectedUsers) {
		this.selectedUsers = selectedUsers;
	}

	public Integer[] getSelectedUsers() {
		return selectedUsers;
	}

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	public ProjectDAO getProjectDAO() {
		return projectDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public String addUsersToTheProject() {
		userDAO.addUsersToTheProject(selectedUsers, projectDAO.findProject(projectId));
		return Action.SUCCESS;
	}

}
