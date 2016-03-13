package md.utm.fi.model.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import md.utm.fi.model.dao.GenericDao;

public class GenericDaoImpl extends HibernateDaoSupport implements GenericDao {

	public <T> T get(Class<T> entity, Serializable id) {
		return getHibernateTemplate().get(entity, id);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> get(Class<T> entity) {
		return getHibernateTemplate().find("from " + entity.getSimpleName());
	}

	public <T> Serializable save(T entity) {
		return getHibernateTemplate().save(entity);
	}

	public <T> void saveOrUpdate(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	public <T> void saveOrUpdate(Collection<T> entities) {
		getHibernateTemplate().saveOrUpdate(entities);
	}

	public <T> void delete(T entity) {
		getHibernateTemplate().delete(entity);
	}

	public <T> void delete(Collection<T> entities) {
		getHibernateTemplate().delete(entities);

	}

	public <T> void refresh(T entity) {
		getHibernateTemplate().refresh(entity);
	}

}