package com.dbarrio.model.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.dbarrio.model.dto.Tipo;
import com.dbarrio.model.util.HibernateUtil;

public class TipoDao extends DaoGenerico{
	
	public void persist(Tipo transientInstance) {
		super.persist(transientInstance);
	}

	public void attachDirty(Tipo instance) {
		super.attachDirty(instance);
	}

	public void attachClean(Tipo instance) {
		super.attachClean(instance);
	}

	public void delete(Tipo persistentInstance) {
		super.delete(persistentInstance);
	}

	public Tipo merge(Tipo detachedInstance) {
		return (Tipo) super.merge(detachedInstance);
	}

	public Tipo findById(Integer id) {
		return (Tipo) super.findById(Tipo.class.getName(), id);
	}

	public List findByExample(String entityName, Tipo instance) {
		return super.findByExample(entityName, instance);
	}	
}
