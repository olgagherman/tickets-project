package md.utm.fi.model.dao;

import java.util.List;

import md.utm.fi.model.entity.User;

public interface UserDAO extends GenericDao {

	User findUser(String login, String password);

	List<User> getAllUsers();

	User findUser(Integer id);

	void deleteUser(Integer id);
}
