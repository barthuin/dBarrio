package com.dbarrio.model.dao;
// Generated 20-ene-2017 19:04:09 by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.dbarrio.model.dto.Recomendaciones;
import com.dbarrio.model.util.HibernateUtil;

/**
 * Home object for domain model class Recomendaciones.
 * @see kk.Recomendaciones
 * @author Hibernate Tools
 */
public class RecomendacionesDao {

	private static final Log log = LogFactory.getLog(RecomendacionesDao.class);

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

	public void persist(Recomendaciones transientInstance) {
		log.debug("persisting Recomendaciones instance");
		try {
			session.persist(transientInstance);
			tx.commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Recomendaciones instance) {
		log.debug("attaching dirty Recomendaciones instance");
		try {
			session.saveOrUpdate(instance);
			tx.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Recomendaciones instance) {
		log.debug("attaching clean Recomendaciones instance");
		try {
			session.lock(instance, LockMode.NONE);
			tx.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Recomendaciones persistentInstance) {
		log.debug("deleting Recomendaciones instance");
		try {
			session.delete(persistentInstance);
			tx.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Recomendaciones merge(Recomendaciones detachedInstance) {
		log.debug("merging Recomendaciones instance");
		try {
			Recomendaciones result = (Recomendaciones) session.merge(detachedInstance);
			tx.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Recomendaciones findById(java.lang.Integer id) {
		log.debug("getting Recomendaciones instance with id: " + id);
		try {
			Recomendaciones instance = (Recomendaciones) session.get("com.mercadolocal.model.dto.Recomendaciones",
					id);
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

	public List findByExample(Recomendaciones instance) {
		log.debug("finding Recomendaciones instance by example");
		try {
			List results = session.createCriteria("com.mercadolocal.model.dto.Recomendaciones")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
