package md.utm.fi.model.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
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
	private HibernateTransactionManager transactionManager;
	@Autowired
	private ProjectDAO projectDao;
	@Autowired
	private SessionFactory sessionFactory;
	private User user;
	private Project project;

	// @Test
	// @Transactional
	public void testCreateUser() {
		Transaction beginTransaction = transactionManager.getSessionFactory().getCurrentSession().beginTransaction();
		beginTransaction.begin();

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
		// testable.deleteUser(5);
		// List<Project> projects = new ArrayList<Project>();
		// projects.add(project);
		// user.setProjects(projects);
		// testable.save(user);
		// Assert.assertTrue(user.getId() > 0);

	}

	// @Test
	public void testGetUser() {
		Transaction beginTransaction = transactionManager.getSessionFactory().getCurrentSession().beginTransaction();
		beginTransaction.begin();
		User findUser = testable.findUser(6);

		System.out.println(findUser.getEmail());
		testable.refresh(findUser);
		List<Project> project2 = findUser.getProject();
		for (Project project : project2) {
			System.out.println(project.getName());
		}
		beginTransaction.commit();
	}

	@Test
	public void testGetUsers() {
		Transaction beginTransaction = transactionManager.getSessionFactory().getCurrentSession().beginTransaction();
		beginTransaction.begin();
		project = projectDao.findProject(6);
		// String value = "from User user0_ left outer join userAssignProject
		// project1_ on user0_.id=project1_.user_id left outer join Project
		// project2_ on project1_.project_id=project2_.id where user0_.id=?";
		// Session currentSession =
		// transactionManager.getSessionFactory().getCurrentSession();
		// Query query = currentSession.createQuery(value);
		// query.setInteger(1, user.getId());
		// List<User> userlist = query.list();
		projectDao.retrieveAllProjectUser(project);
		// List<User> userlist = projectDao.retrieveAllProjectUser(project);
		// testable.save(user);

		beginTransaction.commit();
	}
	/*
	 * @Test // @Transactional public void testDeleteUser() {
	 * 
	 * testable.deleteUser(25);
	 * 
	 * }
	 */

}