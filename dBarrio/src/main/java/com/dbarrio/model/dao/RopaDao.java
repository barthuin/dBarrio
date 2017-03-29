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

import com.dbarrio.model.dto.Ropa;
import com.dbarrio.model.util.HibernateUtil;

/**
 * Home object for domain model class Ropa.
 * @see com.mercadolocal.model.dao.Ropa
 * @author Hibernate Tools
 */
public class RopaDao {

	private static final Log log = LogFactory.getLog(RopaDao.class);

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

	public void persist(Ropa transientInstance) {
		log.debug("persisting Ropa instance");
		try {
			session.persist(transientInstance);
			tx.commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Ropa instance) {
		log.debug("attaching dirty Ropa instance");
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

	public void attachClean(Ropa instance) {
		log.debug("attaching clean Ropa instance");
		try {
			session.lock(instance, LockMode.NONE);
			tx.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Ropa persistentInstance) {
		log.debug("deleting Ropa instance");
		try {
			session.delete(persistentInstance);
			tx.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Ropa merge(Ropa detachedInstance) {
		log.debug("merging Ropa instance");
		try {
			Ropa result = (Ropa) session.merge(detachedInstance);
			tx.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Ropa findById(java.lang.Integer id) {
		log.debug("getting Ropa instance with id: " + id);
		try {
			Ropa instance = (Ropa) session.get("com.mercadolocal.model.dao.Ropa", id);
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

	public List findByExample(Ropa instance) {
		log.debug("finding Ropa instance by example");
		try {
			List results = session.createCriteria("com.mercadolocal.model.dao.Ropa")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
