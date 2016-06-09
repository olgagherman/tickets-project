package md.utm.fi.action.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import md.utm.fi.model.dao.ProjectDAO;
import md.utm.fi.model.dao.UserDAO;
import md.utm.fi.model.entity.Project;

//actionContext.getcontext.getsession.get();
public class ProjectAction implements ModelDriven<Project> {

	private Project project = new Project();

	private ProjectDAO projectDAO;

	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	private List<Project> projectList;

	private Integer projectId;

	private Integer userId;

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	public Project getModel() {
		return project;
	}

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	public ProjectDAO getProjectDAO() {
		return projectDAO;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String addProject() throws Exception {
		project.setCreatedDate(new Date());
		projectDAO.save(project);
		if (project.getName() != null) {
			project = new Project();
			return Action.SUCCESS;
		}
		return Action.ERROR;
	}

	public String updateProject() {
		projectDAO.saveOrUpdate(project);
		return Action.SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String editProject() {
		String returnType = Action.NONE;
		if (projectId != null) {
			ActionContext.getContext().getValueStack().getRoot().remove(project);
			project = getProjectDAO().findProject(projectId);
			ActionContext.getContext().getValueStack().getRoot().add(project);
			returnType = Action.SUCCESS;
		}
		return returnType;
	}

	public String removeProject() {
		if (projectId != null) {
			getProjectDAO().deleteProject(projectId);
		}
		return Action.SUCCESS;
	}

	public String removeProjectUser() {
		if (projectId != null) {
			projectDAO.deleteProjectUser(projectId, userId);
		}
		return Action.SUCCESS;
	}

	// list all Projects
	public String listAllProjects() {

		Map<String, Object> sesio = ActionContext.getContext().getSession();
		sesio.get("logged");
		boolean a = sesio.containsKey("admin");
		System.out.println(a);
		projectList = projectDAO.getAllProjects();
		if (projectList == null) {
			projectList = new ArrayList<Project>();
		}
		return Action.SUCCESS;
	}

	public String getUserProjects() {

		Map<String, Object> session = ActionContext.getContext().getSession();
		/* userId = session.containsKey("userId"); */
		userId = Integer.parseInt(session.get("userId").toString());
		 projectList = userDAO.getUserProjects(userId);

		if (projectList == null) {
			projectList = new ArrayList<Project>();
		}
		return Action.SUCCESS;
	}
}
