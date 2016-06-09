package md.utm.fi.model.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Transactional;

import md.utm.fi.exception.ObjectsNotFoundException;
import md.utm.fi.model.dao.UserDAO;
import md.utm.fi.model.entity.Project;
import md.utm.fi.model.entity.Ticket;
import md.utm.fi.model.entity.User;

@SuppressWarnings("unchecked")
public class UserDAOImpl extends GenericDaoImpl implements UserDAO {

	/*
	 * public List<Project> retrieveAllProjects(User user) { return
	 * getHibernateTemplate().find("from Project p where p.user.id=?",
	 * user.getId()); }
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
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

	@Transactional
	public List<User> getUsersNotWithTheProject(Integer projectId) {
		return getHibernateTemplate().find(
				"select us from User us where us not in (select u from User u join u.projects p where p.id=?)",
				projectId);
	}

	public List<User> getAllUsers() {
		return getHibernateTemplate().find("from User order by admin desc");
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
	public User findUser(Integer id) {
		User user = get(User.class, id);
		List<Project> pr = user.getProjects();
		List<Ticket> tk = user.getTickets();
		refresh(user);
		return user;
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

	public List<Project> getUserProjects(Integer userId) {
		User user = findUser(userId);
		return user.getProjects();
	}

	public List<Ticket> getUserTickets(Integer userId) {
		User user = findUser(userId);
		return user.getTickets();
	}

	@Transactional(readOnly = false)
	public void addUsersToTheTicket(Integer userId, Ticket ticket) {

		User user = findUser(userId);
		user.getTickets().add(ticket);
		saveOrUpdate(user);

	}

	@Transactional(readOnly = false)

	public int getCountTickets() throws DataAccessException {

		return DataAccessUtils.intResult(getHibernateTemplate().find("select count(*) from Ticket"));

	}

}
