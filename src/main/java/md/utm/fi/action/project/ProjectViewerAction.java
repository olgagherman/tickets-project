package md.utm.fi.action.project;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import md.utm.fi.model.dao.ProjectDAO;
import md.utm.fi.model.dao.UserDAO;
import md.utm.fi.model.entity.Project;
import md.utm.fi.model.entity.User;

public class ProjectViewerAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private ProjectDAO projectDAO;
	private Project project;
	private Integer projectId;
	private List<User> usersList;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	public ProjectDAO getProjectDAO() {
		return projectDAO;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public Project getProject() {
		return project;
	}

	public String getBodyProject() {
		project = projectDAO.findProject(projectId);
		listAllProjectUsers();
		if (project == null) {
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	public String listAllProjectUsers() {
		usersList = projectDAO.retrieveAllProjectUser(projectDAO.findProject(projectId));
		if (usersList == null) {
			usersList = new ArrayList<User>();
		}
		return Action.SUCCESS;
	}

}
