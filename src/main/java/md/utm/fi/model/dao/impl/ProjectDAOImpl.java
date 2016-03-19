package md.utm.fi.model.dao.impl;

import java.awt.print.Book;
import java.util.List;

import md.utm.fi.model.dao.ProjectDAO;
import md.utm.fi.model.entity.Project;

@SuppressWarnings("unchecked")
public class ProjectDAOImpl extends GenericDaoImpl implements ProjectDAO {
	public List<Book> retrieveAllUploadedProjectBooks(Project project) {
		return getHibernateTemplate().find("from Book b where b.uploader.id=?", project.getId());
	}

	public List<Project> getAllProjects() {
		return getHibernateTemplate().find("from Project order by id desc");
	}

	public Project findProject(Integer id) {
		return get(Project.class, id);
	}

	public void deleteProject(Integer id) {
		delete(findProject(id));
	}
}
