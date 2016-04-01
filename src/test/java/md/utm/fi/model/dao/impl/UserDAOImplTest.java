package md.utm.fi.model.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import md.utm.fi.model.dao.ProjectDAO;
import md.utm.fi.model.dao.TicketDAO;
import md.utm.fi.model.dao.UserDAO;
import md.utm.fi.model.entity.Project;
import md.utm.fi.model.entity.Ticket;
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
	private TicketDAO ticketDAO;

	private User user;
	private Project project;

	@Test
	// @Transactional
	public void testCreateUser() {
		// Transaction beginTransaction =
		// transactionManager.getSessionFactory().getCurrentSession().beginTransaction();
		// beginTransaction.begin();

		project = new Project();
		project.setCreatedDate(new Date());
		project.setName("test");
		project.setDescription("Adaugat de test");
		projectDao.save(project);
		user = new User();

		List<User> users = new ArrayList<User>();
		List<Project> projects = new ArrayList<Project>();
		projects.add(project);

		user.setCreatedDate(new DateTime(2012, 1, 1, 0, 0, 0).toDate());
		user.setEmail("ion@mail.ru");
		user.setName("Ion");
		user.setPassword("ion83");
		user.setSurname("Bushmaciu");
		testable.save(user);
		user.setProjects(projects);
		testable.saveOrUpdate(user);
		users.add(user);

		// testable.refresh(project);
		user = new User();
		user.setCreatedDate(new DateTime(2012, 1, 1, 0, 0, 0).toDate());
		user.setEmail("ion@mail.ru");
		user.setName("Ion");
		user.setPassword("ion83");
		user.setSurname("Bushmaciu");
		testable.save(user);
		user.setProjects(projects);
		testable.saveOrUpdate(user);
		users.add(user);

		project.setUsers(users);
		projectDao.saveOrUpdate(project);

		Project project = projectDao.findProject(2);
		projectDao.refresh(project);

		// testable.deleteUser(5);
		// List<Project> projects = new ArrayList<Project>();
		// projects.add(project);
		// user.setProjects(projects);
		// testable.save(user);
		// Assert.assertTrue(user.getId() > 0);
		List<User> userlist = project.getUsers();
	}

	@Test
	public void testGetUser() {
		Transaction beginTransaction = transactionManager.getSessionFactory().getCurrentSession().beginTransaction();
		beginTransaction.begin();
		User findUser = testable.findUser(45);

		System.out.println(findUser.getEmail());
		testable.refresh(findUser);
		List<Project> project2 = findUser.getProjects();
		for (Project project : project2) {
			System.out.println(project.getName());
		}
		beginTransaction.commit();
	}

	@Test
	public void testGetUsers() {
		// Transaction beginTransaction =
		// transactionManager.getSessionFactory().getCurrentSession().beginTransaction();
		// beginTransaction.begin();
		Project project = projectDao.findProject(28);
		projectDao.refresh(project);
		// String value = "from User user0_ left outer join userAssignProject
		// project1_ on user0_.id=project1_.user_id left outer join Project
		// project2_ on project1_.project_id=project2_.id where user0_.id=?";
		// Session currentSession =
		// transactionManager.getSessionFactory().getCurrentSession();
		// Query query = currentSession.createQuery(value);
		// query.setInteger(1, user.getId());
		// List<User> userlist = query.list();
		// projectDao.retrieveAllProjectUser(project);
		List<User> userlist = project.getUsers();
		// testable.save(user);
		/*
		 * for (User us : userlist) { System.out.println(us.getName()); }
		 */
		// beginTransaction.commit();
	}

	/*
	 * @Test // @Transactional public void testDeleteUser() {
	 * 
	 * testable.deleteUser(25);
	 * 
	 * }
	 */
	@Test
	public void selectTest() throws Exception

	{
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session session = hibernateUtil.getSession();
		Query query = session.createQuery("from user where Id > 10");
		List results = query.list();
	}

	@Test
	public void selectNamProjectTest() {
		List<String> names = projectDao.getAllProjectName();
		for (String next : names) {
			System.out.println("next name: " + next);
		}
		int i = 4;
	}

	@Test
	public void addProjTicket() {
		List<Ticket> tickets = new ArrayList<Ticket>();
		Project proj = new Project();
		proj.setCreatedDate(new Date());
		proj.setName("testname");
		projectDao.save(proj);

		Ticket ticket = new Ticket();
		ticket.setName("T2");
		ticket.setComplexity(3);
		ticket.setCreatedDate(new Date());
		ticket.setProject(proj);
		ticketDAO.save(ticket);
		tickets.add(ticket);

		ticket = new Ticket();
		ticket.setName("T2");
		ticket.setComplexity(3);
		ticket.setCreatedDate(new Date());
		ticket.setProject(proj);
		ticketDAO.save(ticket);
		tickets.add(ticket);

		// Project proj = projectDao.findProject(2);

		// projectDao.refresh(proj);

		/*
		 * if (!proj.getTickets().isEmpty()) { tickets = proj.getTickets(); }
		 */

		proj.setTickets(tickets);
		projectDao.saveOrUpdate(proj);
		Project proj1 = projectDao.findProject(proj.getId());
		projectDao.refresh(proj1);

	}
}
