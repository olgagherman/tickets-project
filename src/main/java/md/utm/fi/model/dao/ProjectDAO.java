package md.utm.fi.model.dao;

import java.util.List;

import md.utm.fi.model.entity.Project;
import md.utm.fi.model.entity.User;

public interface ProjectDAO extends GenericDao {

	List<Project> getAllProjects();

	Project findProject(Integer id);

	void deleteProject(Integer id);

	List<User> retrieveAllProjectUser(Project id);

	public void deleteProjectUser(Integer projectId, Integer userId);

	List<String> getAllProjectName();

	public Project findProject(String name);

	List<Project> getUserProjects(Integer userId);
}
