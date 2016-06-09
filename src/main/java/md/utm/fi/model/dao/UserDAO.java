package md.utm.fi.model.dao;

import java.util.List;

import md.utm.fi.model.entity.Project;
import md.utm.fi.model.entity.Ticket;
import md.utm.fi.model.entity.User;

public interface UserDAO extends GenericDao {

	User findUser(String login, String password);

	List<User> getUsersForProject(Integer projectId);

	List<User> getUsersNotWithTheProject(Integer projectId);

	List<User> getAllUsers();

	User findUser(Integer id);

	void deleteUser(Integer id);

	void addUsersToTheProject(Integer[] selectedUsers, Project project);

	void addUsersToTheTicket(Integer userId, Ticket ticket);

	public int getCountTickets();

	public List<Ticket> getUserTickets(Integer userId);

	public List<Project> getUserProjects(Integer userId);
	/*
	 * public List<Project> retrieveAllProjects(User user);
	 */
}
