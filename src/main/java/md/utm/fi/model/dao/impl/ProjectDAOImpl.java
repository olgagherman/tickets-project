package md.utm.fi.model.dao.impl;

import java.util.List;

import md.utm.fi.model.dao.ProjectDAO;
import md.utm.fi.model.entity.Project;
import md.utm.fi.model.entity.User;

@SuppressWarnings("unchecked")
public class ProjectDAOImpl extends GenericDaoImpl implements ProjectDAO {
	public List<User> retrieveAllProjectUser(int id) {
		return getHibernateTemplate().find("from User u where u.project.id=?", id);
	}

	public List<Project> getAllProjects() {
		return getHibernateTemplate().find("from Project order by id desc");
	}

	public Project findProject(Integer id) {
		return get(Project.class, id);
	}

	public void deleteProject(Integer id) {
		delete(findProject(id));
	}

	public void deleteProjectUser(int id) {
		// return getHibernateTemplate().delete().
	}

}
