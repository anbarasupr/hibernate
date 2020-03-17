package hql.min_max_hql;

import java.math.BigDecimal;

import org.hibernate.*;

import entities.HibernateUtil;

public class ProductModel {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public BigDecimal min() {
		BigDecimal result = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createQuery("select min(p.price) from Product p");
			result = (BigDecimal) query.getResultList().get(0);
			transaction.commit();
		} catch (Exception e) {
			result = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public BigDecimal max() {
		BigDecimal result = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createQuery("select max(p.price) from Product p");
			result = (BigDecimal) query.getResultList().get(0);
			transaction.commit();
		} catch (Exception e) {
			result = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

}
