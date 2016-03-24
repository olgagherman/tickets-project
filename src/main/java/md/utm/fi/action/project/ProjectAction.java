package md.utm.fi.action.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import md.utm.fi.model.dao.ProjectDAO;
import md.utm.fi.model.entity.Project;

public class ProjectAction implements ModelDriven<Project> {

	private Project project = new Project();

	private ProjectDAO projectDAO;

	private List<Project> projectList;

	private Integer projectId;

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

	public String addProject() throws Exception {
		project.setCreatedDate(new Date());
		projectDAO.save(project);
		if (project.getName() != null) {
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

	// list all Projects
	public String listAllProjects() {
		projectList = projectDAO.getAllProjects();
		if (projectList == null) {
			projectList = new ArrayList<Project>();
		}
		return Action.SUCCESS;
	}

}
