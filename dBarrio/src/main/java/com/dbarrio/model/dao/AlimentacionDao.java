package com.dbarrio.model.dao;
// Generated 13-ene-2017 18:41:00 by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.dbarrio.model.dto.Alimentacion;
import com.dbarrio.model.util.HibernateUtil;

/**
 * Home object for domain model class Alimentacion.
 * @see com.mercadolocal.model.dao.Alimentacion
 * @author Hibernate Tools
 */
public class AlimentacionDao {

	private static final Log log = LogFactory.getLog(AlimentacionDao.class);

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

	public void persist(Alimentacion transientInstance) {
		log.debug("persisting Alimentacion instance");
		try {
			session.persist(transientInstance);
			tx.commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Alimentacion instance) {
		log.debug("attaching dirty Alimentacion instance");
		try {
			if (!session.isOpen()){
				session = HibernateUtil.getSessionFactory().getCurrentSession();
				tx = session.beginTransaction();
			}
			session.saveOrUpdate(instance);
			tx.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Alimentacion instance) {
		log.debug("attaching clean Alimentacion instance");
		try {
			session.lock(instance, LockMode.NONE);
			tx.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Alimentacion persistentInstance) {
		log.debug("deleting Alimentacion instance");
		try {
			session.delete(persistentInstance);
			tx.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Alimentacion merge(Alimentacion detachedInstance) {
		log.debug("merging Alimentacion instance");
		try {
			Alimentacion result = (Alimentacion) session.merge(detachedInstance);
			tx.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Alimentacion findById(java.lang.Integer id) {
		log.debug("getting Alimentacion instance with id: " + id);
		try {
			Alimentacion instance = (Alimentacion) session
					.get("com.mercadolocal.model.dao.Alimentacion", id);
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

	public List findByExample(Alimentacion instance) {
		log.debug("finding Alimentacion instance by example");
		try {
			List results = session.createCriteria("com.mercadolocal.model.dao.Alimentacion")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
