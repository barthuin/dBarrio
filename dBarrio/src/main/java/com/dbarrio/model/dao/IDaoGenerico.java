package com.dbarrio.model.dao;


import java.util.List;

import org.hibernate.SessionFactory;

import com.dbarrio.model.dto.Alimentacion;


public interface IDaoGenerico {

	
	SessionFactory getSessionFactory();

	public void persist(Object transientInstance);
	
	public void attachDirty(Object instance);
	
	public void attachClean(Object instance);
	
	public void delete(Object persistentInstance);

	public Object merge(Object detachedInstance);

	public Object findById(String entityName, Integer id);

	public List findByExample(String entityName, Object instance);
}
