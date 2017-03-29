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

import com.dbarrio.model.dto.Chat;
import com.dbarrio.model.util.HibernateUtil;

/**
 * Home object for domain model class Chat.
 * @see com.mercadolocal.model.dao.Chat
 * @author Hibernate Tools
 */
public class ChatDao {

	private static final Log log = LogFactory.getLog(ChatDao.class);

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

	public void persist(Chat transientInstance) {
		log.debug("persisting Chat instance");
		try {
			session.persist(transientInstance);
			tx.commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Chat instance) {
		log.debug("attaching dirty Chat instance");
		try {
			session.saveOrUpdate(instance);
			tx.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Chat instance) {
		log.debug("attaching clean Chat instance");
		try {
			session.lock(instance, LockMode.NONE);
			tx.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Chat persistentInstance) {
		log.debug("deleting Chat instance");
		try {
			session.delete(persistentInstance);
			tx.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Chat merge(Chat detachedInstance) {
		log.debug("merging Chat instance");
		try {
			Chat result = (Chat) session.merge(detachedInstance);
			tx.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Chat findById(java.lang.Integer id) {
		log.debug("getting Chat instance with id: " + id);
		try {
			Chat instance = (Chat) session.get("com.mercadolocal.model.dto.Chat", id);
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

	public List findByExample(Chat instance) {
		log.debug("finding Chat instance by example");
		try {
			List results = session.createCriteria("com.mercadolocal.model.dto.Chat")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
