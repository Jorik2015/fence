package com.abner.fence.web;

public interface Context {
	Object get(Object key);

	void put(Object key, Object value);

	void remove(Object key);

	void reset();
}
