package md.utm.fi.model.dao;

import java.util.List;

import md.utm.fi.model.entity.Project;

public interface ProjectDAO extends GenericDao {

	List<Project> getAllProjects();

	Project findProject(Integer id);

	void deleteProject(Integer id);

}
