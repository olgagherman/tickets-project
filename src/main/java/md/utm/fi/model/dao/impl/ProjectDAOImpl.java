package md.utm.fi.model.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import md.utm.fi.model.dao.ProjectDAO;
import md.utm.fi.model.entity.Project;
import md.utm.fi.model.entity.User;

@SuppressWarnings("unchecked")
public class ProjectDAOImpl extends GenericDaoImpl implements ProjectDAO {

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<User> retrieveAllProjectUser(Project project) {

		// String value = "from User user0_ left outer join userAssignProject
		// project1_ on user0_.id=project1_.user_id left outer join Project
		// project2_ on project1_.project_id=project2_.id where project2_.id=?";
		// getHibernateTemplate().find(value, project.getId());

		// refresh(project);

		project = findProject(project.getId());
		project.getUsers().isEmpty();
		return project.getUsers();
	}

	public List<Project> getAllProjects() {
		return getHibernateTemplate().find("from Project order by id desc");
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
	public Project findProject(Integer id) {
		return get(Project.class, id);
	}

	public Project findProject(String name) {
		// return get(Project.class, name);
		List<Project> find = getHibernateTemplate().find("from Project a where name=?", name);
		/*
		 * if (find.isEmpty()) { throw new
		 * ObjectsNotFoundException(Author.class, name, surname); }
		 */
		return find.iterator().next();
	}

	public void deleteProject(Integer id) {
		delete(findProject(id));
	}

	// TODO rewrite this method in order to use HQL
	@Transactional
	public void deleteProjectUser(Integer projectId, Integer userId) {
		Project project = findProject(projectId);
		Iterator<User> iterator = project.getUsers().iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == userId) {
				iterator.remove();
				break;
			}
		}
		saveOrUpdate(project);
	}

	public List<String> getAllProjectName() {
		List<Project> projects = getAllProjects();
		List<String> names = new ArrayList<String>();
		for (Project next : projects) {
			names.add(next.getName());
		}
		return names;

	}

	public List<Project> getUserProjects(Integer userId) {
		return getHibernateTemplate().find("select p from Project p inner join p.users u  where u.id=?", userId);
	}

}
