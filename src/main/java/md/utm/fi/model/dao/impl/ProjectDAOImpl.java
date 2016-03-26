package md.utm.fi.model.dao.impl;

import java.util.List;

import md.utm.fi.model.dao.ProjectDAO;
import md.utm.fi.model.entity.Project;
import md.utm.fi.model.entity.User;

@SuppressWarnings("unchecked")
public class ProjectDAOImpl extends GenericDaoImpl implements ProjectDAO {
	public List<User> retrieveAllProjectUser(Project id) {
		String value = "from  User user0_ left outer join userAssignProject project1_ on user0_.id=project1_.user_id left outer join Project project2_ on project1_.project_id=project2_.id  where project2_.id=?";
		return getHibernateTemplate().find(value, id.getId());
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
