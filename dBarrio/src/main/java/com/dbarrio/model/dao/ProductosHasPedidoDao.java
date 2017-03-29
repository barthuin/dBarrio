package com.dbarrio.model.dao;
// Generated 10-feb-2017 18:15:51 by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.dbarrio.model.dto.ProductosHasPedido;
import com.dbarrio.model.dto.ProductosHasPedidoId;
import com.dbarrio.model.util.HibernateUtil;

/**
 * Home object for domain model class ProductosHasPedido.
 * @see kk.ProductosHasPedido
 * @author Hibernate Tools
 */
public class ProductosHasPedidoDao {

	private static final Log log = LogFactory.getLog(ProductosHasPedidoDao.class);

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

	public void persist(ProductosHasPedido transientInstance) {
		log.debug("persisting ProductosHasPedido instance");
		try {
			session.persist(transientInstance);
			tx.commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ProductosHasPedido instance) {
		log.debug("attaching dirty ProductosHasPedido instance");
		try {
			session.saveOrUpdate(instance);
			tx.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProductosHasPedido instance) {
		log.debug("attaching clean ProductosHasPedido instance");
		try {
			session.lock(instance, LockMode.NONE);
			tx.commit();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ProductosHasPedido persistentInstance) {
		log.debug("deleting ProductosHasPedido instance");
		try {
			session.delete(persistentInstance);
			tx.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProductosHasPedido merge(ProductosHasPedido detachedInstance) {
		log.debug("merging ProductosHasPedido instance");
		try {
			ProductosHasPedido result = (ProductosHasPedido) session.merge(detachedInstance);
			tx.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProductosHasPedido findById(ProductosHasPedidoId id) {
		log.debug("getting ProductosHasPedido instance with id: " + id);
		try {
			ProductosHasPedido instance = (ProductosHasPedido) session
					.get("com.mercadolocal.model.dto.ProductosHasPedido", id);
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

	public List findByExample(ProductosHasPedido instance) {
		log.debug("finding ProductosHasPedido instance by example");
		try {
			List results = session.createCriteria("com.mercadolocal.model.dto.ProductosHasPedido")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
