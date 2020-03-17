package hql.call_sp_no_parameters_hql;

import java.util.List;
import org.hibernate.*;

import entities.HibernateUtil;
import entities.Product;

public class ProductModel {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public List<Product> findAll() {
		List<Product> products = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createNativeQuery("{call sp_findAll()}", Product.class);
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
