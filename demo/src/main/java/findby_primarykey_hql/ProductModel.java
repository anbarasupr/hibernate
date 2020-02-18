package findby_primarykey_hql;

import org.hibernate.*;
import entities.*;

public class ProductModel {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public Product find(int id) {
		Product product = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			org.hibernate.query.Query query = session.createQuery("select p from Product p where p.id = :id");
			query.setParameter("id", id);
			product = (Product) query.getSingleResult();
			transaction.commit();
		} catch (Exception e) {
			product = null;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return product;
	}

}
