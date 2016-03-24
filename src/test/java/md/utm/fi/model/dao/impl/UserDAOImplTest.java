package md.utm.fi.model.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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

	@Test
	@Transactional
	public void testCreateUser() {
		user = new User();
		Project project = new Project();
		project.setCreatedDate(new Date());
		project.setName("grig");
		projectDao.save(project);
		user.setCreatedDate(new DateTime(2012, 1, 1, 0, 0, 0).toDate());
		user.setEmail("ion@mail.ru");
		user.setName("Ion");
		user.setPassword("ion83");
		user.setSurname("Bushmaciu");
		List<Project> projects = new ArrayList<Project>();
		projects.add(project);
		user.setProjects(projects);
		testable.save(user);
		Assert.assertTrue(user.getId() > 0);

	}

	@Test
	@Ignore // @Transactional
	public void testDeleteUser() {

		testable.deleteUser(5);

	}

}
