package md.utm.fi.model.dao;

import java.util.List;

import md.utm.fi.model.entity.Project;
import md.utm.fi.model.entity.User;

public interface UserDAO extends GenericDao {

	User findUser(String login, String password);

	List<User> getUsersForProject(Integer projectId);

	List<User> getUsersNotWithTheProject(Integer projectId);

	List<User> getAllUsers();

	User findUser(Integer id);

	void deleteUser(Integer id);

	void addUsersToTheProject(Integer[] selectedUsers, Project project);

	/*
	 * public List<Project> retrieveAllProjects(User user);
	 */
}
