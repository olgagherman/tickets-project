package md.utm.fi.model.dao.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import md.utm.fi.exception.ObjectsNotFoundException;
import md.utm.fi.model.dao.UserDAO;
import md.utm.fi.model.entity.Project;
import md.utm.fi.model.entity.User;

@SuppressWarnings("unchecked")
public class UserDAOImpl extends GenericDaoImpl implements UserDAO {

	/*
	 * public List<Project> retrieveAllProjects(User user) { return
	 * getHibernateTemplate().find("from Project p where p.user.id=?",
	 * user.getId()); }
	 */
	public User findUser(String login, String password) {
		List<User> find = getHibernateTemplate().find("from User where email=? and password=?", login, password);
		if (find.isEmpty()) {
			throw new ObjectsNotFoundException(User.class, login, password);
		}
		return find.iterator().next();
	}

	public List<User> getUsersForProject(Integer projectId) {
		return getHibernateTemplate().find("select u from User u join u.projects p where p.id=?", projectId);
	}

	public List<User> getUsersNotWithTheProject(Integer projectId) {
		return getHibernateTemplate().find("select u from User u join u.projects p where p.id<>?", projectId);
	}

	public List<User> getAllUsers() {
		return getHibernateTemplate().find("from User order by admin desc");
	}

	public User findUser(Integer id) {
		return get(User.class, id);
	}

	public void deleteUser(Integer id) {
		delete(findUser(id));
	}

	@Transactional(readOnly = false)
	public void addUsersToTheProject(Integer[] selectedUsers, Project project) {
		for (Integer userId : selectedUsers) {
			User user = findUser(userId);
			user.getProjects().add(project);
			saveOrUpdate(user);
		}
	}

}
