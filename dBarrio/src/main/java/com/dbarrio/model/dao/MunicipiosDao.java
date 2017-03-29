package com.dbarrio.model.dao;
// Generated 23-dic-2016 19:05:29 by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;

import com.dbarrio.model.dto.Municipios;
import com.dbarrio.model.dto.Provincias;
import com.dbarrio.model.util.HibernateUtil;


/**
 * Home object for domain model class Municipios.
 * @see com.alquilatujuego.model.dto.Municipios
 * @author Hibernate Tools
 */
public class MunicipiosDao {

	private static final Log log = LogFactory.getLog(MunicipiosDao.class);

	private Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	private Transaction tx = session.beginTransaction();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Municipios transientInstance) {
		log.debug("persisting Municipios instance");
		try {
			session.persist(transientInstance);
			tx.commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Municipios instance) {
		log.debug("attaching dirty Municipios instance");
		try {
			session.saveOrUpdate(instance);
			tx.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Municipios instance) {
		log.debug("attaching clean Municipios instance");
		try {
			session.lock(instance, LockMode.NONE);
			tx.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Municipios persistentInstance) {
		log.debug("deleting Municipios instance");
		try {
			session.delete(persistentInstance);
			tx.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Municipios merge(Municipios detachedInstance) {
		log.debug("merging Municipios instance");
		try {
			Municipios result = (Municipios) session.merge(detachedInstance);
			tx.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Municipios findById(Integer id) {
		log.debug("getting Municipios instance with id: " + id);
		try {
			Municipios instance = (Municipios) session
					.get("com.mercadolocal.model.dto.Municipios", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Municipios instance) {
		log.debug("finding Municipios instance by example");
		try {
			List results = session
					.createCriteria("com.mercadolocal.model.dto.Municipios").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
