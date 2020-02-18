package avg_hql;

import java.math.BigDecimal;
import org.hibernate.*;

import entities.HibernateUtil;

public class ProductModel {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public Long sumQuantities() {
		Long result = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createQuery("select sum(p.quantity) from Product p");
			result = (Long) query.getResultList().get(0);
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

	public BigDecimal total() {
		BigDecimal result = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createQuery("select sum(p.price * p.quantity) from Product p");
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
