package hql.call_sp_with_parameters_hql;

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.*;

import entities.HibernateUtil;
import entities.Product;

public class ProductModel {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public List between(BigDecimal min, BigDecimal max) {
		List products = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createNativeQuery("{call sp_findBetween(?, ?)}", Product.class);
			query.setParameter(1, min);
			query.setParameter(2, max);
			products = query.getResultList();
			transaction.commit();
		} catch (Exception e) {
			products = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return products;
	}

}
