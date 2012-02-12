package com.fence.dao;

import java.util.List;

public interface GenericDao<T> {
	T save(T domain);

	T saveOrUpdate(T domain);

	T update(T instance);

	boolean delete(T domain);

	boolean delete(List<T> domainList);

	int getCount();

	int getCount(String propertyName, Object value);

	T findById(Integer id);

	List<T> findAll();

	List<T> findAll(final int firstResult, final int size);

}