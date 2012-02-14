package com.abner.hibernate;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.abner.dao.GenericDao;

/**
 * Hibernate implementation of the Fence interface. Note that transactions are
 * declared with annotations and that some methods contain "readOnly = true"
 * which is an optimization that is particularly valuable when using Hibernate
 * (to suppress unnecessary flush attempts for read-only operations).
 * 
 */
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class HibernateDao<T> extends HibernateDaoSupport implements GenericDao {

	@Transactional
	public boolean delete(Object domain) {
		try {
			getHibernateTemplate().delete(domain);
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}

	@Transactional
	public boolean delete(List domainList) {
		try {
			getHibernateTemplate().deleteAll(domainList);
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}

	@Transactional
	public T save(Object domain) {
		try {
			getHibernateTemplate().save(domain);
			return (T) domain;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	@Transactional
	public T saveOrUpdate(Object domain) {
		try {
			getHibernateTemplate().saveOrUpdate(domain);
			return (T) domain;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	@Transactional
	public T update(Object domain) {
		try {
			getHibernateTemplate().update(domain);
			return (T) domain;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	@Transactional(readOnly = true)
	public List<T> findByExample(Object value) {
		return getHibernateTemplate().findByExample(value);
	}

	@Transactional(readOnly = true)
	public List<T> findByExample(String entityName, Object value) {
		return getHibernateTemplate().findByExample(entityName, value);
	}

	@Transactional(readOnly = true)
	public List<T> findAll() {
		String queryString = "from " + getTableName();
		return getHibernateTemplate().find(queryString);
	}

	@Transactional(readOnly = true)
	public List<T> findAll(int firstResult, int size) {
		DetachedCriteria date = DetachedCriteria.forClass(typeClass());
		return getHibernateTemplate().findByCriteria(date, firstResult, size);
	}

	@Transactional(readOnly = true)
	public T findById(Integer id) {
		return (T) getHibernateTemplate().get(typeClass(), id);
	}

	@Transactional(readOnly = true)
	public List<T> findByProperty(final String propertyName, final Object value) {
		HibernateCallback callback = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				String queryString = "from " + getTableName() + " e where e."
						+ propertyName + "=?";
				Query q = session.createQuery(queryString);
				q.setParameter(0, value);
				return q.list();
			}
		};

		return (List) getHibernateTemplate().execute(callback);
	}

	@Transactional(readOnly = true)
	public List<T> findIn(String propertyName, Object[] value) {
		DetachedCriteria date = DetachedCriteria.forClass(typeClass());
		date.add(Restrictions.in(propertyName, value));
		return getHibernateTemplate().findByCriteria(date);
	}

	@Transactional(readOnly = true)
	public int getCount() {
		String queryString = "select count(*) from " + getTableName();
		List result = getHibernateTemplate().find(queryString);
		return ((Long) result.get(0)).intValue();
	}

	@Transactional(readOnly = true)
	public int getCount(String propertyName, Object value) {
		String queryString = "select count(*) from " + getTableName()
				+ " as model where model." + propertyName + "= ? ";
		List result = getHibernateTemplate().find(queryString, value);
		return ((Long) result.get(0)).intValue();
	}

	@Transactional(readOnly = true)
	public int getCount(String[] propertyNames, Object[] values) {
		String queryString = "select count(*) from " + getTableName()
				+ " as model where ";
		for (String propertyName : propertyNames) {
			queryString += " model." + propertyName + "=? and";
		}
		queryString = StringUtils.removeEnd(queryString, "and");
		List result = getHibernateTemplate().find(queryString, values);
		return ((Long) result.get(0)).intValue();
	}

	@Transactional(readOnly = true)
	public List<T> findByProperty(String[] propertyNames, Object[] values) {
		String queryString = "from " + getTableName() + " as model where";
		for (String propertyName : propertyNames) {
			queryString += " model." + propertyName + "=? and";
		}
		queryString = StringUtils.removeEnd(queryString, "and");
		return getHibernateTemplate().find(queryString, values);
	}

	@Transactional(readOnly = true)
	public List<T> findByProperty(String propertyName, Object value,
			int firstResult, int size) {
		DetachedCriteria date = DetachedCriteria.forClass(typeClass());
		date.add(Restrictions.eq(propertyName, value));
		return getHibernateTemplate().findByCriteria(date, firstResult, size);
	}

	@Transactional(readOnly = true)
	public List fuzzyFindByProperty(String propertyName, Object value) {
		String queryString = " from " + getTableName()
				+ " as model where LOWER(model." + propertyName + ") like ?";
		String lowerValue = "%" + String.valueOf(value).toLowerCase() + "%";
		return getHibernateTemplate().find(queryString, lowerValue);
	}

	protected Class<T> typeClass() {
		Type[] types = ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments();
		if (types.length == 0) {
			throw new IllegalArgumentException(getClass().getName()
					+ " must be generic class");
		}
		return (Class<T>) types[0];
	}

	private String getTableName() {
		return typeClass().getName();
	}
}
