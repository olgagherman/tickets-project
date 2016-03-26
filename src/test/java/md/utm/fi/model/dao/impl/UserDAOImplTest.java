package md.utm.fi.model.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import md.utm.fi.model.dao.ProjectDAO;
import md.utm.fi.model.dao.UserDAO;
import md.utm.fi.model.entity.Project;
import md.utm.fi.model.entity.User;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDAOImplTest {

	@Autowired
	private UserDAO testable;
	@Autowired
	private ProjectDAO projectDao;
	@Autowired
	private SessionFactory sessionFactory;
	private User user;
	private Project project;

	@Test
	// @Transactional
	public void testCreateUser() {

		project = new Project();
		project.setCreatedDate(new Date());
		project.setName("test");
		projectDao.save(project);
		user = new User();
		List<User> users = new ArrayList<User>();

		user.setCreatedDate(new DateTime(2012, 1, 1, 0, 0, 0).toDate());
		user.setEmail("ion@mail.ru");
		user.setName("Ion");
		user.setPassword("ion83");
		user.setSurname("Bushmaciu");
		testable.save(user);
		users.add(user);
		// testable.refresh(project);
		user = new User();
		user.setCreatedDate(new DateTime(2012, 1, 1, 0, 0, 0).toDate());
		user.setEmail("ion@mail.ru");
		user.setName("Ion");
		user.setPassword("ion83");
		user.setSurname("Bushmaciu");
		testable.save(user);
		users.add(user);

		project.setUsers(users);
		projectDao.save(project);
		testable.deleteUser(5);
		// List<Project> projects = new ArrayList<Project>();
		// projects.add(project);
		// user.setProjects(projects);
		// testable.save(user);
		// Assert.assertTrue(user.getId() > 0);

		// List<User> userlist = projectDao.retrieveAllProjectUser(project);
		// testable.save(user);
	}

	@Test
	// @Transactional
	public void testDeleteUser() {

		testable.deleteUser(25);

	}

}