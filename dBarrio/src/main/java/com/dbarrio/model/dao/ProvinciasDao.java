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

import com.dbarrio.model.dto.Provincias;
import com.dbarrio.model.util.HibernateUtil;


/**
 * Home object for domain model class Provincias.
 * @see com.alquilatujuego.model.dto.Provincias
 * @author Hibernate Tools
 */
public class ProvinciasDao {

	private static final Log log = LogFactory.getLog(ProvinciasDao.class);

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

	public void persist(Provincias transientInstance) {
		log.debug("persisting Provincias instance");
		try {
			session.persist(transientInstance);
			tx.commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Provincias instance) {
		log.debug("attaching dirty Provincias instance");
		try {
			session.saveOrUpdate(instance);
			tx.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Provincias instance) {
		log.debug("attaching clean Provincias instance");
		try {
			session.lock(instance, LockMode.NONE);
			tx.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Provincias persistentInstance) {
		log.debug("deleting Provincias instance");
		try {
			session.delete(persistentInstance);
			tx.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Provincias merge(Provincias detachedInstance) {
		log.debug("merging Provincias instance");
		try {
			Provincias result = (Provincias) session.merge(detachedInstance);
			tx.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Provincias findById(Integer id) {
		log.debug("getting Provincias instance with id: " + id);
		try {
			Provincias instance = (Provincias) session
					.get("com.mercadolocal.model.dto.Provincias", id);
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

	public List findByExample(Provincias instance) {
		log.debug("finding Provincias instance by example");
		try {
			List results = session.createCriteria("com.mercadolocal.model.dto.Provincias").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
